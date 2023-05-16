package com.java_web.ProjectWeb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java_web.ProjectWeb.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
