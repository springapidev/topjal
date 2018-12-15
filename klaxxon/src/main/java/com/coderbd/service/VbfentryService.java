package com.coderbd.service;

import com.coderbd.entity.Departments;
import com.coderbd.entity.User;
import com.coderbd.entity.Vbfentry;

import java.util.List;

public interface VbfentryService {
    List<Vbfentry> findAllByUser(User user);
    List<Vbfentry> findAllByUserAndAndDepartmentID(User user, Departments departments);
}
