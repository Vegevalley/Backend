package com.hacakathon.vegetable.repository;

import com.hacakathon.vegetable.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
