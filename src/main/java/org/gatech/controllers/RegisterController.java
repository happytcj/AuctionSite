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

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String loadRegisterPage(@RequestParam(name="error", required = false) String error,
                                Model m) {
        m.addAttribute("error", error);
        return "register";
    }

    @PostMapping("/register")
    public String Register(@RequestParam("username") String userName,
                        @RequestParam("pass") String password,
                        HttpServletRequest request) {
        User user = userService.checkRegister(userName, password);
        if (user.getUserName() == null) { // we did not find a user with this registration
            return "redirect:/?error=t";
        }
        request.getSession(true)
                .setAttribute("user", user);
        return "redirect:/homepage";
    }
}
