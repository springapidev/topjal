package com.coderbd.controller;


import com.coderbd.entity.Companies;
import com.coderbd.entity.Departments;
import com.coderbd.entity.User;
import com.coderbd.repo.DepartmentsRepo;
import com.coderbd.service.CompaniesService;
import com.coderbd.service.DepartmentsService;
import com.coderbd.service.UserService;
import com.coderbd.utils.LoggedInUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;


@Controller
@RequestMapping("/department/")
public class DepartmentsController {
    @Autowired
    private DepartmentsRepo repo;

    @Autowired
    private LoggedInUser loggedInUser;

    @Autowired
    private UserService userService;

    @Autowired
    private CompaniesService companiesService;

    @Autowired
    private DepartmentsService departmentsService;

    @RequestMapping(value = "create.do", method = RequestMethod.GET)
    public ModelAndView getView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("obj", new Departments());
        modelAndView.addObject("companies", companiesService.findAllByUser(userService.isUserNameAlreadyExist(loggedInUser.getCurrentUserName())));
        modelAndView.addObject("list", repo.findAllByUser(userService.isUserNameAlreadyExist(loggedInUser.getCurrentUserName())));
        modelAndView.setViewName("departments/create");
        return modelAndView;
    }

    @RequestMapping(value = "create.do", method = RequestMethod.POST)
    public String saveOrUpdate(@Valid @ModelAttribute("obj") Departments obj, BindingResult bindingResult, @RequestParam("checkedID") Long id, Model model) {

        if (bindingResult.hasErrors()) {
            return "departments/create";
        } else {
            Departments departments1 = departmentsService.findByDepartmentNameAndCompanyIDAndAndUser(obj.getDepartmentName(),companiesService.findByCompanyID(id),userService.isUserNameAlreadyExist(loggedInUser.getCurrentUserName()));
            if (departments1 != null) {
                model.addAttribute("departmentNameError", "You already have inserted this");
                model.addAttribute("obj", new Departments());
                model.addAttribute("list", repo.findAllByUser(userService.isUserNameAlreadyExist(loggedInUser.getCurrentUserName())));
                model.addAttribute("companies", companiesService.findAllByUser(userService.isUserNameAlreadyExist(loggedInUser.getCurrentUserName())));
                return "departments/create";
            } else {
                obj.setUser(userService.isUserNameAlreadyExist(loggedInUser.getCurrentUserName()));
                obj.setCreatedDate(new Date());
                Companies co = new Companies();
                co.setCompanyID(id);
                obj.setCompanyID(co);
                repo.save(obj);
                model.addAttribute("successMessage", "Insert Success");
                model.addAttribute("list", repo.findAllByUser(userService.isUserNameAlreadyExist(loggedInUser.getCurrentUserName())));
                return "departments/create";
            }
        }

    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String updateRole(@PathVariable Long id, Model model) {
        Optional<Departments> obj1 = repo.findById(id);
        model.addAttribute("obj", obj1);
        return "departments/create";
    }

    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String delRole(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("successMessage", "Delete Success");
        return "redirect:/departments/create";
    }

    @RequestMapping(value = "list.do", method = RequestMethod.GET)
    public ModelAndView getList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", repo.findAllByUser(userService.isUserNameAlreadyExist(loggedInUser.getCurrentUserName())));
        modelAndView.setViewName("departments/list");
        return modelAndView;
    }
}
