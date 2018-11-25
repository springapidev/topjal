package com.topjal.controller;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.topjal.service.PostService;
import com.topjal.util.GeoIP;
import com.topjal.util.GeoLocations;
import com.topjal.util.SystemInfoCollect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class HomeController {
    @Autowired
    private PostService service;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "6") int perPage) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title","Hire Us to Build Your  Future ");
        modelAndView.addObject("list", service.getAllPosts(page, perPage));
        modelAndView.setViewName("index");
        try {
            GeoIP loGeoIP = GeoLocations.getLocation(SystemInfoCollect.getIPAddress());
            System.out.println(loGeoIP);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (GeoIp2Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            /* The user is logged in :) */
            return "redirect:/";
        }
        return "login";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/access-denied";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup() {
        return "signup";
    }

    @RequestMapping(value = "/forget-password", method = RequestMethod.GET)
    public String forgetPassword() {
        return "forget-password";
    }




}
