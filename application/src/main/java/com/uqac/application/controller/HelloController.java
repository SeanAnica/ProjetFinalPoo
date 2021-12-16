package com.uqac.application.controller;

import com.uqac.application.model.ResponseTemplateVO;
import com.uqac.application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/application")
@Controller
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/users")
    String getUsers(Model model) {

        User user = restTemplate.getForObject("http://USER-SERVICE/users/only/1", User.class);
        System.out.println("the firstname : " + user);
        model.addAttribute("users",user);

        return "users/list";
    }
}
