package com.coderbd.service;

import com.coderbd.entity.Companies;
import com.coderbd.entity.User;

import java.util.List;

public interface CompaniesService {
    List<Companies> findAllByUser(User user);
    Companies findByCompanyName(String companyName);
    Companies findByCompanyID(Long companyID);
}
