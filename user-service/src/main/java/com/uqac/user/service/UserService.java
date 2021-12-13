package com.uqac.user.service;

import com.uqac.user.VO.Department;
import com.uqac.user.VO.ResponseTemplateVO;
import com.uqac.user.entity.User;
import com.uqac.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate; //avec ce rest template on peut appeler le micro
    //service des départements

    public User saveUser(User user) {
        log.info("Inside saveUser from UserService");
        return userRepository.save(user);
    }

    public List<ResponseTemplateVO> getAllUsersWithDepartments(){
        log.info("Inside getAllUsers from UserService");
        List<User> allUsers = userRepository.findAll();
        List<ResponseTemplateVO> responseTemplateVOs = new ArrayList<ResponseTemplateVO>();

        for(User u : allUsers){
            Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + u.getDepartmentId(),
                    Department.class);
            ResponseTemplateVO tmpResponseTemplateVO = new ResponseTemplateVO(u,department);
            if(tmpResponseTemplateVO != null){
                responseTemplateVOs.add(tmpResponseTemplateVO);
            }
        }

        return responseTemplateVOs;
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment from UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        //call department microservice
        //avant on avait http://localhost:9001/departments dans l'url mais avec le registre de services
        //on met directement le nom du service qu'on a configuré avec le serveur eureka
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
                Department.class);
        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }
}
