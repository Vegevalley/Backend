package com.hacakathon.vegetable.repository;

import com.hacakathon.vegetable.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(String userId);

    User findByUserName(String userName);

    boolean existsByUserId(String userId);
}
