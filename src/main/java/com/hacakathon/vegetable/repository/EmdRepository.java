package com.hacakathon.vegetable.repository;

import com.hacakathon.vegetable.domain.EMD;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmdRepository extends JpaRepository<EMD, Long> {

    EMD findByEmdName(String emdName);
}
