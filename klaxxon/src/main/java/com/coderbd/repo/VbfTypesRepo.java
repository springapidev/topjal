package com.coderbd.repo;

import com.coderbd.entity.Vbftypes;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VbfTypesRepo extends JpaRepository<Vbftypes, Long> {
    Vbftypes findByVBFType(String vbfType);

}
