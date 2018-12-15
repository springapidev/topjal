package com.coderbd.serviceImpl;

import com.coderbd.entity.Departments;
import com.coderbd.entity.User;
import com.coderbd.entity.Vbfentry;
import com.coderbd.repo.VbfentryRepo;
import com.coderbd.service.VbfentryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VbfentryServiceImpl implements VbfentryService {
    @Autowired
    private VbfentryRepo repo;
    @Override
    public List<Vbfentry> findAllByUser(User user) {
        return repo.findAllByUser(user);
    }

    @Override
    public List<Vbfentry> findAllByUserAndAndDepartmentID(User user, Departments departments) {
        return repo.findAllByUserAndAndDepartmentID(user,departments);
    }
}
