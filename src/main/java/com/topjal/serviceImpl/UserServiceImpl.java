package com.topjal.serviceImpl;


import com.topjal.entity.User;
import com.topjal.repo.UserRepo;
import com.topjal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo repo;

    @Override
    public User save(User user) {
        return repo.saveAndFlush(user);
    }

    @Override
    public User update(User user) {
        return repo.saveAndFlush(user);
    }

    @Override
    public void delete(Long id) {
repo.deleteById(id);
    }

    @Override
    public Optional<User> getUser(Long id) {
        return repo.findById(id);
    }

    @Override
    public Page<User> getAllUsers(int page, int perPageRow) {
        return repo.findAll(PageRequest.of(page,perPageRow));
    }

    @Override
    public User isEmailAlreadyExist(String email) {
        return repo.findByEmail(email);
    }

    @Override
    public User isMobileAlreadyExist(String mobile) {
        return repo.findByMobile(mobile);
    }

    @Override
    public User isUserNameAlreadyExist(String userName) {
        return repo.findByUserName(userName);
    }

    @Override
    public User findByActivationKey(String activationKey) {
        return repo.findByActivationKey(activationKey);
    }


}
