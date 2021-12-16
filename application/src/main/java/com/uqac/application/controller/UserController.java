package com.uqac.application.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.uqac.application.model.ResponseTemplateVO;
import com.uqac.application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/application")
@Controller
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/users")
    String getUsers(Model model) {
        List<ResponseTemplateVO> usersWithDepartments = new ArrayList<ResponseTemplateVO>();
        ResponseEntity<List<ResponseTemplateVO>> responseEntity =
                restTemplate.exchange(
                        "http://USER-SERVICE/users/all",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<ResponseTemplateVO>>() {}
                );
        usersWithDepartments = responseEntity.getBody();
        model.addAttribute("users", usersWithDepartments);
        return "users/list";
    }

    @GetMapping("/signup")
    public String showAddUserForm(User user) {
        return "users/add";
    }

    @RequestMapping("/adduser")
    String addUser(@Valid User user, BindingResult result, Model model){
        if(result.hasErrors()){
            return "users/add";
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<String> response = restTemplate.postForEntity("http://USER-SERVICE/users/", user, String.class);

        return "redirect:users";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        restTemplate.delete("http://USER-SERVICE/users/" + id);
        return "redirect:/application/users/";
    }
}
