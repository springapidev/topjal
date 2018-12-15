package com.coderbd.service;

import com.coderbd.entity.Companies;
import com.coderbd.entity.Departments;
import com.coderbd.entity.User;

import java.util.List;

public interface DepartmentsService {
    Departments findByDepartmentName(String departmentName);
    List<Departments> findAllByUser(User user);
    Departments findByDepartmentNameAndCompanyIDAndAndUser(String departmentName, Companies companies, User user);
    List<Departments> findAllByUserAndAndCompanyID(User user, Companies companies);
}
