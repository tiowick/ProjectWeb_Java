package com.java_web.ProjectWeb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java_web.ProjectWeb.models.Task;
import com.java_web.ProjectWeb.models.User;
import com.java_web.ProjectWeb.repositories.TaskRepository;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    public Task findById(long id){
        Optional<Task> task = this.taskRepository.findById(id);
        return task.orElseThrow(() -> new RuntimeException(
           "Tarefa não encontrada! id: " + id + " Tipo: " + Task.class.getName() 
        ));

    }

    @Transactional
    public Task create(Task obj){

        User user = this.userService.findById(obj.getUser().getId());
        obj.setId(null);
        obj.setUser(user);
        obj = this.taskRepository.save(obj);
        return obj;
    }

    @Transactional
    public Task update(Task obj){
        Task newObj = findById(obj.getId());
        newObj.setDescription(obj.getDescription());
        return this.taskRepository.save((newObj));
    }

    public void delete(long id){
        findById(id);
        try {
            this.taskRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possivel deletar pois há entidades relacionadas!");
            // TODO: handle exception
        }
    }
}
