package com.coderbd.repo;

import com.coderbd.entity.Vbflikelihoodtypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VbflikelihoodtypesRepo extends JpaRepository<Vbflikelihoodtypes, Long> {
}
