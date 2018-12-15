package com.coderbd.controller;


import com.coderbd.entity.Vbftypes;
import com.coderbd.repo.VbfTypesRepo;
import com.coderbd.service.UserService;
import com.coderbd.service.VbftypesService;
import com.coderbd.utils.LoggedInUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping("/vbftype/")
public class VbfTypesController {
    @Autowired
    private VbfTypesRepo repo;

    @Autowired
    private LoggedInUser loggedInUser;

    @Autowired
    private UserService userService;

    @Autowired
    private VbftypesService service;


    @RequestMapping(value = "create.do", method = RequestMethod.GET)
    public ModelAndView getView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("obj", new Vbftypes());
        modelAndView.addObject("list", repo.findAll());
        modelAndView.setViewName("settings/vbf-type");
        return modelAndView;
    }

    @RequestMapping(value = "create.do", method = RequestMethod.POST)
    public String saveOrUpdate(@Valid @ModelAttribute("obj") Vbftypes obj, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "settings/vbf-type";
        } else {
            Vbftypes vbftys = service.findByVBFType(loggedInUser.getCurrentUserName());
            if (vbftys != null) {
                model.addAttribute("vbfTypeNameError", "You already have inserted this");
                model.addAttribute("obj", new Vbftypes());
                model.addAttribute("list", repo.findAll());
                return "settings/vbf-type";
            } else {

                repo.save(obj);
                model.addAttribute("successMessage", "Insert Success");
                model.addAttribute("list", repo.findAll());
                return "settings/vbf-type";
            }
        }

    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String updateRole(@PathVariable Long id, Model model) {
        Optional<Vbftypes> obj1 = repo.findById(id);
        model.addAttribute("obj", obj1);
        return "settings/vbf-type";
    }

    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String delRole(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("successMessage", "Delete Success");
        return "redirect:/vbftype/create";
    }
}


