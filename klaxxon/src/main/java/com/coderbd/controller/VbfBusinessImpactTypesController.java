package com.coderbd.controller;


import com.coderbd.entity.Vbfbusinessimpacttypes;
import com.coderbd.repo.VbfbusinessimpacttypesRepo;
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
@RequestMapping("/vbf-business-impact-type/")
public class VbfBusinessImpactTypesController {
    @Autowired
    private VbfbusinessimpacttypesRepo repo;

    @Autowired
    private LoggedInUser loggedInUser;

    @Autowired
    private UserService userService;



    @RequestMapping(value = "create.do", method = RequestMethod.GET)
    public ModelAndView getView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("obj", new Vbfbusinessimpacttypes());
        modelAndView.addObject("list", repo.findAll());
        modelAndView.setViewName("settings/vbf-business-impact-types");
        return modelAndView;
    }

    @RequestMapping(value = "create.do", method = RequestMethod.POST)
    public String saveOrUpdate(@Valid @ModelAttribute("obj") Vbfbusinessimpacttypes obj, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "settings/vbf-business-impact-types";
        } else {

                repo.save(obj);
                model.addAttribute("successMessage", "Insert Success");
                model.addAttribute("list", repo.findAll());
                return "settings/vbf-business-impact-types";
            }
        }



    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String updateRole(@PathVariable Long id, Model model) {
        Optional<Vbfbusinessimpacttypes> obj1 = repo.findById(id);
        model.addAttribute("obj", obj1);
        return "settings/vbf-business-impact-types";
    }

    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String delRole(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("successMessage", "Delete Success");
        return "redirect:/vbf-business-impact-type/create";
    }
}


