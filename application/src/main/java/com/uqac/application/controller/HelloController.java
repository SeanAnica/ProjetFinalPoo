package com.uqac.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/users")
    String getUsers(Model model) {
        /*List<ResponseTemplateVO> responseTemplateVOs = new ArrayList<ResponseTemplateVO>();
        responseTemplateVOs = (List<ResponseTemplateVO>) restTemplate.getForObject("http://USER-SERVICE/users/all", ResponseTemplateVO.class);
        model.addAttribute("users",responseTemplateVOs);*/
        return "users/list";
    }
}
