package com.coderbd.repo;

import com.coderbd.entity.Vbfbusinessimpacttypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VbfbusinessimpacttypesRepo extends JpaRepository<Vbfbusinessimpacttypes,Long> {
}
