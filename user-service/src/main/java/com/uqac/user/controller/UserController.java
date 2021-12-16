package com.uqac.user.controller;

import com.uqac.user.VO.ResponseTemplateVO;
import com.uqac.user.entity.User;
import com.uqac.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside saveUser from UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/only/{id}")
    public User getUserOnly(@PathVariable("id") Long userId){
        return userService.getUser(userId);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("Inside getUserWithDepartment from UserController");
        return userService.getUserWithDepartment(userId);
    }

    @GetMapping("/all")
    public List<ResponseTemplateVO> getAllUsersWithDepartments(){
        log.info("Inside getAllUsersWithDepartments from UserController");
        return userService.getAllUsersWithDepartments();
    }

}
