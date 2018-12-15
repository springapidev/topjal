package com.coderbd.serviceImpl;

import com.coderbd.entity.Companies;
import com.coderbd.entity.Departments;
import com.coderbd.entity.User;
import com.coderbd.repo.DepartmentsRepo;
import com.coderbd.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {
    @Autowired
    private DepartmentsRepo repo;
    @Override
    public Departments findByDepartmentName(String departmentName) {
        return repo.findByDepartmentName(departmentName);
    }

    @Override
    public List<Departments> findAllByUser(User user) {
        return repo.findAllByUser(user);
    }

    @Override
    public Departments findByDepartmentNameAndCompanyIDAndAndUser(String departmentName, Companies companies, User user) {
        return repo.findByDepartmentNameAndCompanyIDAndAndUser(departmentName,companies,user);
    }

    @Override
    public List<Departments> findAllByUserAndAndCompanyID(User user, Companies companies) {
        return repo.findAllByUserAndAndCompanyID(user,companies);
    }
}
