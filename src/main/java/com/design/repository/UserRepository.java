package com.design.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.design.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{}
