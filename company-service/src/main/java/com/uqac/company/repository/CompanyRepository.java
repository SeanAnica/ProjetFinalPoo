package com.uqac.company.repository;

import com.uqac.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company findByCompanyId(long companyId);

    Company deleteById(long companyId);
}
