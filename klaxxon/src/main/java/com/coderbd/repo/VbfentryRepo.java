package com.coderbd.repo;

import com.coderbd.entity.Departments;
import com.coderbd.entity.User;
import com.coderbd.entity.Vbfentry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VbfentryRepo extends JpaRepository<Vbfentry, Long> {

    List<Vbfentry> findAllByUser(User user);
    List<Vbfentry> findAllByUserAndAndDepartmentID(User user, Departments departments);
}
