package com.uqac.application.controller;

import com.uqac.application.model.ResponseTemplateVO;
import com.uqac.application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
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
