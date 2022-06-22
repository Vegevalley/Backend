package com.hacakathon.vegetable.repository;

import com.hacakathon.vegetable.domain.RecepiContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeContentRepository extends JpaRepository<RecepiContent, Long> {
}
