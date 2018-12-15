package com.coderbd.controller;


import com.coderbd.entity.Stakeholdertypes;
import com.coderbd.repo.StakeholdertypesRepo;
import com.coderbd.service.UserService;
import com.coderbd.utils.LoggedInUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping("/stack-holder-type/")
public class StackHolderTypesController {
    @Autowired
    private StakeholdertypesRepo repo;

    @Autowired
    private LoggedInUser loggedInUser;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "create.do", method = RequestMethod.GET)
    public ModelAndView getView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("obj", new Stakeholdertypes());
        modelAndView.addObject("list", repo.findAll());
        modelAndView.setViewName("settings/stack-holder-type");
        return modelAndView;
    }

    @RequestMapping(value = "create.do", method = RequestMethod.POST)
    public String saveOrUpdate(@Valid @ModelAttribute("obj") Stakeholdertypes obj, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "settings/stack-holder-type";
        } else {
            Stakeholdertypes stakeholdertypes = repo.findByStakeholderType(obj.getStakeholderType());
            if (stakeholdertypes != null) {
                model.addAttribute("stackHolderTypeError", "You already have inserted this");
                model.addAttribute("obj", new Stakeholdertypes());
                model.addAttribute("list", repo.findAll());
                return "settings/stack-holder-type";
            } else {

                repo.save(obj);
                model.addAttribute("successMessage", "Insert Success");
                model.addAttribute("list", repo.findAll());
                return "settings/stack-holder-type";
            }
        }

    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String updateRole(@PathVariable Long id, Model model) {
        Optional<Stakeholdertypes> obj1 = repo.findById(id);
        model.addAttribute("obj", obj1);
        return "settings/stack-holder-type";
    }

    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String delRole(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("successMessage", "Delete Success");
        return "redirect:/stack-holder-type/create";
    }
}


