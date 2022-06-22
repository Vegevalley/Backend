package com.hacakathon.vegetable.repository;

import com.hacakathon.vegetable.domain.ImgInfo;
import com.hacakathon.vegetable.domain.RecepiContent;
import com.hacakathon.vegetable.domain.VegeContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImgInfoRepository extends JpaRepository<ImgInfo, Long> {
    ImgInfo findByVegeContent(VegeContent vegeContent);

    ImgInfo findByRecepiContent(RecepiContent recepiContent);
}
