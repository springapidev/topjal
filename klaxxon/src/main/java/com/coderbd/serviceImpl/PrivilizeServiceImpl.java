package com.coderbd.serviceImpl;

import com.coderbd.entity.Privilize;
import com.coderbd.repo.PrivilizeRepo;
import com.coderbd.service.PrivilizeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PrivilizeServiceImpl implements PrivilizeService {

    @Autowired
    PrivilizeRepo repo;
    @Override
    public Privilize save(Privilize privilize) {
        return repo.saveAndFlush(privilize);
    }

    @Override
    public Privilize update(Privilize privilize) {
        return repo.saveAndFlush(privilize);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Optional<Privilize> getPrivilize(Long id) {
        return repo.findById(id);
    }

    @Override
    public Page<Privilize> getAllPrivilizes(int page, int perPageRow) {
        return repo.findAll(PageRequest.of(page, perPageRow));
    }


    @Override
    public Privilize isAlreadyExist(String privilizeName) {
        return repo.findByPrivilizeName(privilizeName);
    }

}
