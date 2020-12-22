package com.possenti.task.controller;

import com.possenti.task.entity.Task;
import com.possenti.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @GetMapping("/res")
    public String res() {
        return "Bem vindo autorizado!";
    }

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Task> findAll() {
        return repository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_USER')")
    public Task save(@RequestBody Task task) {
        return repository.save(task);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Task update(@RequestBody Task task) {
        return repository.save(task);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
