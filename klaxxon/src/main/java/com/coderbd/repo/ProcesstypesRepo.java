package com.coderbd.repo;

import com.coderbd.entity.Processtypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcesstypesRepo extends JpaRepository<Processtypes, Long> {
    Processtypes findByProcessType(String processType);
}
