package com.hacakathon.vegetable.repository;

import com.hacakathon.vegetable.domain.VegeContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VegeContentRepository extends JpaRepository<VegeContent, Long> {
}
