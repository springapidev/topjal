package com.coderbd.repo;

import com.coderbd.entity.Stakeholderentry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StakeholderentryRepo extends JpaRepository<Stakeholderentry, Long> {

}
