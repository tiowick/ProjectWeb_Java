package com.java_web.ProjectWeb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java_web.ProjectWeb.models.Task;
import java.util.List;



@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
    //Optional<Task> findById(Long id);

    List<Task> findByUser_Id(Long id); //padrão Spring

    // @Query(value = "SELECT t FROM Task t WHERE t.user.id = :id ")
    // List<Task> findByUser_Id(@Param("id")Long id);

    // @Query(value = "SELECT * FROM task t WHERE t.user_id = :id", nativeQuery = true)
    // List<Task> findByUser_Id(@Param("id")Long id); 



}
