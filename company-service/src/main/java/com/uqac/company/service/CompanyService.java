package com.uqac.company.service;

import com.uqac.company.entity.Company;
import com.uqac.company.repository.CompanyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company saveCompany(Company company) {

        log.info("Inside saveCompany method of CompanyService");
        return companyRepository.save(company);
    }

    public Company findCompanyById(long companyId) {

        log.info("Inside findCompanyById method of CompanyService");
        return companyRepository.findByCompanyId(companyId);
    }


    public Company deleteById(long companyId) {
        log.info("Inside deleteCompanyById method of CompanyService");
        return companyRepository.deleteById(companyId);
    }
}
