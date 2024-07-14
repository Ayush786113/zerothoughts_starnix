package in.starnix.zerothoughts.controllers;

import in.starnix.zerothoughts.models.Task;
import in.starnix.zerothoughts.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("task")
    public ResponseEntity<Object> postTask(@RequestBody Task task){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(taskService.postTask(task));
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @GetMapping("task/{parentid}")
    public ResponseEntity<Object> getTasks(@PathVariable(name = "parentid") String parentId){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(taskService.getTasks(parentId));
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @PatchMapping("task")
    public ResponseEntity<Object> updateTask(@RequestBody Task task){
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(taskService.updateTask(task));
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }
}
