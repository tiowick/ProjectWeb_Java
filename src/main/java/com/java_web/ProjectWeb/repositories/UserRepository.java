package com.java_web.ProjectWeb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.java_web.ProjectWeb.models.User;


public interface UserRepository extends JpaRepository<User, Long>{

    @Transactional(readOnly = true)
    User findByUsername(String username);
    
}
