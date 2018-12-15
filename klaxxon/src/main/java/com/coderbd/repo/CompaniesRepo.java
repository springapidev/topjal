package com.coderbd.repo;

import com.coderbd.entity.Companies;
import com.coderbd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompaniesRepo extends JpaRepository<Companies, Long> {
    List<Companies> findAllByUser(User user);
    Companies findByCompanyName(String companyName);
    public Companies findByCompanyID(Long companyID);
}
