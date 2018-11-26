package com.topjal.controller;


import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;
import com.topjal.entity.Role;
import com.topjal.entity.User;
import com.topjal.repo.RoleRepo;
import com.topjal.service.UserService;
import com.topjal.util.EmailService;
import com.topjal.util.SystemInfoCollect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;


@Controller
public class UserController {
    @Autowired
    private UserService service;
    @Autowired
    RoleRepo roleRepo;

    private static int currentPage = 1;
    private static int pageSize = 5;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public ModelAndView getuser(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int perPage) {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.addObject("users", service.getAllUsers(page, perPage));
        modelAndView.addObject("allRoles", roleRepo.findAll());
        modelAndView.setViewName("create-user");
        return modelAndView;
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public ModelAndView saveuser(@Valid User user, BindingResult bindingResult, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int perPage, @RequestParam("checkRoles") String[] markedRoles) {

        Set<Role> roles = new HashSet<>();
        for (String s : markedRoles) {
            Role role = new Role();
            role.setId(Long.parseLong(s));
            roles.add(role);
        }
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setJoiningDate(new Date());
        user.setActivated(true);
        ModelAndView modelAndView = new ModelAndView();
        User userNameExit = service.isUserNameAlreadyExist(user.getUserName());
        User emailExit = service.isEmailAlreadyExist(user.getEmail());
        User mobileExit = service.isMobileAlreadyExist(user.getMobile());
        System.out.println("===== " + user.getRoles().toString());
        if (userNameExit != null && user.getId() == null) {
            bindingResult.rejectValue("userName", "error.user", "This User Name already Exist!");
            modelAndView.addObject("users", service.getAllUsers(page, perPage));
            modelAndView.addObject("allRoles", roleRepo.findAll());
        } else if (emailExit != null && user.getId() == null) {
            bindingResult.rejectValue("email", "error.user", "This Email already Exist!");
            modelAndView.addObject("users", service.getAllUsers(page, perPage));
            modelAndView.addObject("allRoles", roleRepo.findAll());
        } else if (mobileExit != null && user.getId() == null) {
            bindingResult.rejectValue("mobile", "error.user", "This Mobile Number already Exist!");
            modelAndView.addObject("users", service.getAllUsers(page, perPage));
            modelAndView.addObject("allRoles", roleRepo.findAll());
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("create-user");
        } else {
            if (user.getId() != null) {
                service.update(user);
                modelAndView.addObject("successMessage", "Update Success");

            } else {
                service.save(user);
                modelAndView.addObject("successMessage", "Insert Success");

            }


            modelAndView.addObject("user", new User());
            modelAndView.addObject("users", service.getAllUsers(page, perPage));
            modelAndView.addObject("allRoles", roleRepo.findAll());
            modelAndView.setViewName("create-user");

        }

        return modelAndView;
    }

    @RequestMapping(value = "/user/edit/{id}", method = RequestMethod.GET)
    public String updateuser(@PathVariable Long id, Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int perPage) {
        Optional<User> user1 = service.getUser(id);
        User user = new User();
        user.setRoles(user1.get().getRoles());
        user.setId(id);
        System.out.println("======" + user.getId() + ", " + user.getUserName());
        model.addAttribute("user", user);
        model.addAttribute("users", service.getAllUsers(page, perPage));
        model.addAttribute("allRoles", roleRepo.findAll());
        return "create-user";
    }

    @RequestMapping(value = "/user/del/{id}", method = RequestMethod.GET)
    public String deluser(@PathVariable Long id, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int perPage) {
        service.delete(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("successMessage", "Delete Success");
        modelAndView.addObject("users", service.getAllUsers(page, perPage));
        modelAndView.addObject("allRoles", roleRepo.findAll());
        return "redirect:/user/create";
    }

    ///////////////////////////////Sign Up///////////////////////
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView signUp(@Valid User user, BindingResult bindingResult, HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();
// Lookup user in database by e-mail
        User emailExit = service.isEmailAlreadyExist(user.getEmail());
        User userNameExit = service.isUserNameAlreadyExist(user.getUserName());

        if (userNameExit != null) {
            bindingResult.rejectValue("userName", "error.user", "This User Name already Exist!");
        } else if (emailExit != null && user.getId() == null) {
            bindingResult.rejectValue("email", "error.user", "This Email already Exist!");
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("signup");
        } else {
            Set<Role> roles = new HashSet<>();
            Role role = roleRepo.findByRolename("ROLE_USER");
            role.setId(role.getId());
            roles.add(role);
            user.setRoles(roles);

            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setJoiningDate(new Date());
            user.setActivated(false);
            user.setIpAddress(SystemInfoCollect.getIPAddress());
            user.setMacAddress(SystemInfoCollect.getMAC());
            user.setActivationKey(UUID.randomUUID().toString());
            service.save(user);

            // for sending Email
            String appUrl = request.getScheme() + "://" + request.getServerName();
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setTo(user.getEmail());
            simpleMailMessage.setSubject("Registration Confirmation");
            simpleMailMessage.setText("To confirm your e-mail address, please click the link below: \n"
                    + appUrl + "/confirm?token=" + user.getActivationKey());
            simpleMailMessage.setFrom("no-reply@coderbd.com");
            emailService.sendEmail(simpleMailMessage);
            modelAndView.addObject("confirmationMessage", "A confirmation e-mail has been sent to " + user.getEmail());
        }
        modelAndView.setViewName("signup");

        return modelAndView;
    }

    // Process confirmation link
    @RequestMapping(value="/confirm", method = RequestMethod.GET)
    public ModelAndView showConfirmationPage(ModelAndView modelAndView, @RequestParam("token") String token) {

        User user = service.findByActivationKey(token);

        if (user == null) { // No token found in DB
            modelAndView.addObject("invalidToken", "Oops!  This is an invalid confirmation link.");
        } else { // Token found
            modelAndView.addObject("confirmationToken", user.getActivationKey());
        }

        modelAndView.setViewName("confirm");
        return modelAndView;
    }

    // Process confirmation link
    @RequestMapping(value="/confirm", method = RequestMethod.POST)
    public ModelAndView processConfirmationForm(ModelAndView modelAndView, BindingResult bindingResult, @RequestParam Map requestParams) {

        modelAndView.setViewName("confirm");

//        Zxcvbn passwordCheck = new Zxcvbn();
//
//        Strength strength = passwordCheck.measure(requestParams.get("password"));
//
//        if (strength.getScore() < 8) {
//            bindingResult.reject("password");
//
//            redir.addFlashAttribute("errorMessage", "Your password is too weak.  Choose a stronger one.");
//
//            modelAndView.setViewName("redirect:confirm?token=" + requestParams.get("token"));
//            System.out.println(requestParams.get("token"));
//            return modelAndView;
//        }
//
//        // Find the user associated with the reset token
//        User user = service.findByActivationKey(requestParams.get("token"));
//
//        // Set new password
//        user.setPassword(bCryptPasswordEncoder.encode(requestParams.get("password")));

        User user=service.findByActivationKey(requestParams.keySet().toString());
        // Set user to enabled
        user.setActivated(true);

        // Save user
        service.save(user);

        modelAndView.addObject("successMessage", "You may now login!");
        return modelAndView;
    }


}
