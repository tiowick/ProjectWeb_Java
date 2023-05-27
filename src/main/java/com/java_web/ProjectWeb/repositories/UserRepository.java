package com.java_web.ProjectWeb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.java_web.ProjectWeb.models.User;


public interface UserRepository extends JpaRepository<User, Long>{
    
}
