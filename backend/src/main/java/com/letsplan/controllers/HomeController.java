package com.letsplan.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value="/")
    public String index(){
        return "index";
    }
    
    @GetMapping(value="/home")
    public String home(){
        return "home";
    }

    @GetMapping(value="/registration")
    public String register(){
        return "register";
    }

    @GetMapping(value="/login")
    public String login(){
        return "login";
    }

    @GetMapping(value="l_evenement/{id}")
    public String evenementInvitation(){
        return "evenementInvitation";
    }
    
    @GetMapping(value="/evenement")
    public String evenement(){
        return "evenement";
    }

}
