package com.hacakathon.vegetable.repository;

import com.hacakathon.vegetable.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
