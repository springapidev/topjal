package com.coderbd.controller;


import com.coderbd.entity.Companies;
import com.coderbd.entity.Departments;
import com.coderbd.entity.Vbfentry;
import com.coderbd.repo.*;
import com.coderbd.service.DepartmentsService;
import com.coderbd.service.UserService;
import com.coderbd.service.VbfentryService;
import com.coderbd.utils.LoggedInUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;


@Controller
@RequestMapping("/vbf/")
public class VbfEntryController {
    @Autowired
    private VbfentryRepo repo;

    @Autowired
    private LoggedInUser loggedInUser;

    @Autowired
    private UserService userService;

    @Autowired
    private CompaniesRepo companiesRepo;

    @Autowired
    private DepartmentsService departmentsService;

    @Autowired
    private VbfTypesRepo vbfTypesRepo;

    @Autowired
    private VbflikelihoodtypesRepo vbflikelihoodtypesRepo;

    @Autowired
    private VbfbusinessimpacttypesRepo vbfbusinessimpacttypesRepo;

    @Autowired
    private VbfentryService vbfentryService;


    //https://github.com/JVerstry/Web-Related-Examples/blob/master/Spring-REST-With-Ajax/src/main/java/com/jverstry/Controller/MyRESTController.java


    @RequestMapping(value = "create.do", method = RequestMethod.GET)
    public ModelAndView getView(HttpServletRequest request) {//@RequestParam("companyID") Long comID, @RequestParam("depId") Long departmentId
//        if (departmentId == null || comID == null) {
//            comID = 1L;
//            departmentId = 1L;
//        }
//        Departments departments = new Departments();
//        departments.setDepartmentID(departmentId);
       Companies co = new Companies();
     //  co.setCompanyID(comID);
     //   System.out.println("companyID: "+request.getParameter("companyID"));

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("obj", new Vbfentry());
        modelAndView.addObject("list", repo.findAllByUser(userService.isUserNameAlreadyExist(loggedInUser.getCurrentUserName())));
      modelAndView.addObject("companyList", companiesRepo.findAllByUser(userService.isUserNameAlreadyExist(loggedInUser.getCurrentUserName())));
       modelAndView.addObject("departmentList", departmentsService.findAllByUser(userService.isUserNameAlreadyExist(loggedInUser.getCurrentUserName())));
        modelAndView.addObject("vbfTypeList", vbfTypesRepo.findAll());
        modelAndView.addObject("vbfBiImpactList", vbfbusinessimpacttypesRepo.findAll());
        modelAndView.addObject("vbfLikelihoodList", vbflikelihoodtypesRepo.findAll());
              modelAndView.setViewName("vbfentry/create");
        return modelAndView;
    }

    @RequestMapping(value = "create.do", method = RequestMethod.POST)
    public String saveOrUpdate(@Valid Vbfentry obj, BindingResult bindingResult, Model model) {
        System.out.println(obj);
        if (bindingResult.hasErrors()) {
            return "vbfentry/create";
        } else {
            obj.setUser(userService.isUserNameAlreadyExist(loggedInUser.getCurrentUserName()));
            obj.setCreatedDate(new Date());
            repo.save(obj);
            model.addAttribute("successMessage", "Insert Success");
            return "redirect:/department/create.do";
        }
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String updateRole(@PathVariable Long id, Model model) {
        Optional<Vbfentry> obj1 = repo.findById(id);
        model.addAttribute("obj", obj1);
        return "vbfentry/create";
    }

    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String delRole(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("successMessage", "Delete Success");
        return "redirect:/vbf/create";
    }

    @RequestMapping(value = "list.do", method = RequestMethod.GET)
    public ModelAndView getList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", repo.findAllByUser(userService.isUserNameAlreadyExist(loggedInUser.getCurrentUserName())));
        modelAndView.setViewName("vbfentry/list");
        return modelAndView;
    }

//    @PostMapping("/getCompanyDepartmentValues")
//    public @ResponseBody List<Departments> getCompanyDepartmentValues(@RequestParam("companyID") Long comID) {
//        Companies co = new Companies();
//        co.setCompanyID(comID);
//        List<Departments> departmentsList = departmentsService.findAllByUserAndAndCompanyID(userService.isUserNameAlreadyExist(loggedInUser.getCurrentUserName()), co);
//        return departmentsList;
//    }


    public String sayHello(Model model){
        model.addAttribute("sayHello",sayHello(model));
        System.out.println("Heloooooooooooo");
        return "Heloooooooooooo";
    }
}
