package com.hacakathon.vegetable.repository;

import com.hacakathon.vegetable.domain.EMD;
import com.hacakathon.vegetable.domain.VegeContent;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VegeContentRepository extends JpaRepository<VegeContent, Long> {
    VegeContent findByVegeContentId(long vegeContentId);

    List<VegeContent> findByEmd(EMD emd, Pageable pageable);

    List<VegeContent> findByTitleContainsOrMainTextContainsAndEmd(String title, String mainText, EMD emd, Pageable pageable);
}
