package com.hacakathon.vegetable.repository;

import com.hacakathon.vegetable.domain.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByVegeContent(long commentId);

    List<Comment> findAllByRecepiContent(long commentId);
}
