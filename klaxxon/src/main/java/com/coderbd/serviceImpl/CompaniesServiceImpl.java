package com.coderbd.serviceImpl;

import com.coderbd.entity.Companies;
import com.coderbd.entity.User;
import com.coderbd.repo.CompaniesRepo;
import com.coderbd.service.CompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompaniesServiceImpl implements CompaniesService {
    @Autowired
    private CompaniesRepo repo;

    @Override
    public List<Companies> findAllByUser(User user) {
        return repo.findAllByUser(user);
    }

    @Override
    public Companies findByCompanyName(String companyName) {
        return repo.findByCompanyName(companyName);
    }

    @Override
    public Companies findByCompanyID(Long companyID) {
        return repo.findByCompanyID(companyID);
    }
}
