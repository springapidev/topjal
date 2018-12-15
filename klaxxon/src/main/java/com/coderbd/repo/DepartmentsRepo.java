package com.coderbd.repo;

import com.coderbd.entity.Companies;
import com.coderbd.entity.Departments;
import com.coderbd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentsRepo extends JpaRepository<Departments, Long> {
    Departments findByDepartmentName(String departmentName);
    Departments findByDepartmentNameAndCompanyIDAndAndUser(String departmentName, Companies companies, User user);
    List<Departments> findAllByUser(User user);
    List<Departments> findAllByUserAndAndCompanyID(User user, Companies companies);

}
