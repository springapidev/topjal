package com.coderbd.repo;

import com.coderbd.entity.Stakeholdertypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StakeholdertypesRepo extends JpaRepository<Stakeholdertypes, Long> {
    Stakeholdertypes findByStakeholderType(String stakeholderType);
}
