package org.gatech.controllers;

import org.gatech.models.User;
import org.gatech.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Steph on 2/25/2018.
 */
@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/homepage")
    public String loadHomepage(@RequestParam(name="success", required = false) String success, Model m, HttpServletRequest request) {
        m.addAttribute("user", request.getSession().getAttribute("user"));
        m.addAttribute("success", success);
        return "homepage";
    }
}
