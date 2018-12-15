package com.coderbd.repo;

import com.coderbd.entity.Privilize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Mohmmad Rajaul Islam
 */

@Repository
public interface PrivilizeRepo extends JpaRepository<Privilize, Long> {
    Privilize findByPrivilizeName(String privilizeName);


}
