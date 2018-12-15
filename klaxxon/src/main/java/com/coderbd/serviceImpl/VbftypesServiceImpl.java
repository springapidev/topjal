package com.coderbd.serviceImpl;

import com.coderbd.entity.Vbftypes;
import com.coderbd.repo.VbfTypesRepo;
import com.coderbd.service.VbftypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VbftypesServiceImpl implements VbftypesService {
    @Autowired
    private VbfTypesRepo repo;
    @Override
    public Vbftypes findByVBFType(String vbfType) {
        return repo.findByVBFType(vbfType);
    }
}
