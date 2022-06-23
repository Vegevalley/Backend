package com.hacakathon.vegetable.repository;

import com.hacakathon.vegetable.domain.ImgInfo;
import com.hacakathon.vegetable.domain.RecepiContent;
import com.hacakathon.vegetable.domain.VegeContent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface ImgInfoRepository extends JpaRepository<ImgInfo, Long> {
    ArrayList<ImgInfo> findByVegeContent(VegeContent vegeContent);

    ArrayList<ImgInfo> findByRecepiContent(RecepiContent recepiContent);
}
