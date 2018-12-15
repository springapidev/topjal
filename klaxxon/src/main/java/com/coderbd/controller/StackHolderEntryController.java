package com.coderbd.controller;


import com.coderbd.entity.Processtypes;
import com.coderbd.entity.Stakeholderentry;
import com.coderbd.repo.ProcesstypesRepo;
import com.coderbd.repo.StakeholderentryRepo;
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
@RequestMapping("/stack-holder-entry/")
public class StackHolderEntryController {

    @Autowired
    private StakeholderentryRepo repo;

    @Autowired
    private ProcesstypesRepo processtypesRepo;

    @Autowired
    private LoggedInUser loggedInUser;

    @Autowired
    private UserService userService;

    @Autowired
    private StakeholdertypesRepo stakeholdertypesRepo;


    @RequestMapping(value = "create.do", method = RequestMethod.GET)
    public ModelAndView getView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("obj", new Processtypes());
        modelAndView.addObject("list", repo.findAll());
        modelAndView.addObject("stackHolderTypelist", stakeholdertypesRepo.findAll());
        modelAndView.addObject("processTypelist", processtypesRepo.findAll());
        modelAndView.setViewName("settings/process-type");
        return modelAndView;
    }

    @RequestMapping(value = "create.do", method = RequestMethod.POST)
    public String saveOrUpdate(@Valid @ModelAttribute("obj") Stakeholderentry obj, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "settings/process-type";
        } else {
                repo.save(obj);
                model.addAttribute("successMessage", "Insert Success");
                model.addAttribute("list", repo.findAll());
                model.addAttribute("stackHolderTypelist", stakeholdertypesRepo.findAll());
                return "settings/process-type";
            }


    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String updateRole(@PathVariable Long id, Model model) {
        Optional<Stakeholderentry> obj1 = repo.findById(id);
        model.addAttribute("obj", obj1);
        return "settings/process-type";
    }

    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String delRole(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("successMessage", "Delete Success");
        return "redirect:/processtype/create.do";
    }
}


