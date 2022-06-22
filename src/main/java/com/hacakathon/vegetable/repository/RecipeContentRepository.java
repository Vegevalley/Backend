package com.hacakathon.vegetable.repository;

import com.hacakathon.vegetable.domain.RecepiContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeContentRepository extends JpaRepository<RecepiContent, Long> {

    boolean existsByRecepiContentId(long recepiContentId);

    RecepiContent findByRecepiContentId(long recepiContentId);

    List<RecepiContent> findAll();

    List<RecepiContent> findByTitleContains(String title);
}
