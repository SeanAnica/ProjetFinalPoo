package com.uqac.cloud.gateway;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    /**
     * Ces méthodes seront appelées quand les services prendront trop de temps à répondre.
     * pour les faire fonctionner, il faut configurer les "filters" dans application.yml.
     * On configure hystrix dans application.yml de sorte que si on ne reçoit pas une réponse d'un
     * service en moins de 4 s, on est forwardé vers la fonction fall back associée.
     *
     * Hystrix.stream activé pour qu'on puisse utiliser l'information dans le dashboard.
     */

    @GetMapping("/userServiceFallBack")
    public String userServiceFallBackMethod() {
        return "User Service is taking longer than Expected." +
                " Please try again later";
    }

    @GetMapping("/departmentServiceFallBack")
    public String departmentServiceFallBackMethod() {
        return "Department Service is taking longer than Expected." +
                " Please try again later";
    }

    @GetMapping("/applicationFallBack")
    public String applicationFallBackMethod() {
        return "Application is taking longer than Expected." +
                " Please try again later";
    }
}
