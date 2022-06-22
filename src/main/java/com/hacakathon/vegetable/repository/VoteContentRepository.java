package com.hacakathon.vegetable.repository;

import com.hacakathon.vegetable.domain.EMD;
import com.hacakathon.vegetable.domain.User;
import com.hacakathon.vegetable.domain.VegeContent;
import com.hacakathon.vegetable.domain.VoteContent;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoteContentRepository extends JpaRepository<VoteContent, Long> {

    List<VoteContent> findByUser(User user, Pageable pageable);
}
