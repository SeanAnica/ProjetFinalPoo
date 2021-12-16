package com.uqac.company.controller;

import com.uqac.company.entity.Company;
import com.uqac.company.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
@Slf4j
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/")
    public Company saveCompany(@RequestBody Company company){
        log.info("Inside saveCompany method of CompanyController");
        return companyService.saveCompany(company);
    }

    @GetMapping("/{id}")
    public Company findCompanyById(@PathVariable("id") long companyId){
        log.info("Inside findCompanyById method of CompanyController");
        return companyService.findCompanyById(companyId);
    }

    @DeleteMapping("/{id}")
    public Company deleteCompanyById(@PathVariable("id") long companyId){
        log.info("Inside deleteCompanyById method of CompanyController");
        return companyService.deleteById(companyId);
    }
}
