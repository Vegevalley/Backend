package com.hacakathon.vegetable.repository;

import com.hacakathon.vegetable.domain.VoteContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteContentRepository extends JpaRepository<VoteContent, Long> {
}
