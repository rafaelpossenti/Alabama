package com.possenti.task.controller;

import com.possenti.task.entity.Task;
import com.possenti.task.repository.TaskRepository;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<Task> findAll() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    public Task findbyId(@PathVariable("id") Long id) throws NotFound {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find task with id " + id));
    }

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_USER')")
    public Task save(@RequestBody Task task) {
        task.setData(LocalDate.now());
        return repository.save(task);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @PreAuthorize("hasRole('ROLE_USER')")
    public Task update(@RequestBody Task uTask, @PathVariable Long id) {
        return repository.findById(id)
                .map(task -> {
                    task.setName(uTask.getName());
                    task.setDescription(uTask.getDescription());
                    task.setData(LocalDate.now());
                    return repository.save(task);
                })
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find task with id " + id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("hasRole('ROLE_USER')")
    void deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
