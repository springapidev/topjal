package com.coderbd.controller;


import com.coderbd.entity.Companies;
import com.coderbd.repo.CompaniesRepo;
import com.coderbd.service.UserService;
import com.coderbd.utils.LoggedInUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;


@Controller
@RequestMapping("/company/")
public class CompaniesController {
    @Autowired
    private CompaniesRepo repo;

    @Autowired
    private LoggedInUser loggedInUser;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "create.do", method = RequestMethod.GET)
    public ModelAndView getView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("obj", new Companies());
        modelAndView.addObject("list", repo.findAllByUser(userService.isUserNameAlreadyExist(loggedInUser.getCurrentUserName())));
        modelAndView.setViewName("companies/create");
        return modelAndView;
    }

    @RequestMapping(value = "create.do", method = RequestMethod.POST)
    public String saveOrUpdate(@Valid Companies obj, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "companies/create";
        } else {
            Companies companies=repo.findByCompanyName(obj.getCompanyName());
            if (companies != null) {
                model.addAttribute("companyNameError", "You already have inserted this");
                model.addAttribute("obj", new Companies());
                model.addAttribute("list", repo.findAllByUser(userService.isUserNameAlreadyExist(loggedInUser.getCurrentUserName())));
                return "companies/create";
            }else{
               obj.setUser(userService.isUserNameAlreadyExist(loggedInUser.getCurrentUserName()));
               obj.setCreatedDate(new Date());
                repo.save(obj);
                model.addAttribute("successMessage", "Insert Success");
                 return  "redirect:/department/create.do";
            }}
      }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String updateRole(@PathVariable Long id, Model model) {
        Optional<Companies> obj1 = repo.findById(id);
        model.addAttribute("obj",obj1);
        return "companies/create";
    }

    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String delRole(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("successMessage", "Delete Success");
        return "redirect:/company/create";
    }

    @RequestMapping(value = "list.do", method = RequestMethod.GET)
    public ModelAndView getList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", repo.findAllByUser(userService.isUserNameAlreadyExist(loggedInUser.getCurrentUserName())));
        modelAndView.setViewName("companies/list");
        return modelAndView;
    }
}
