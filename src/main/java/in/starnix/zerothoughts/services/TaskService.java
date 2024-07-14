package in.starnix.zerothoughts.services;

import in.starnix.zerothoughts.models.Task;
import in.starnix.zerothoughts.repositories.TaskRepository;
import in.starnix.zerothoughts.repositories.UserRepository;
import in.starnix.zerothoughts.validators.TaskValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskValidator taskValidator;
    @Autowired
    private UserRepository userRepository;

    public Task postTask(Task task) throws Exception{
        if(task.getTask() == null)
            throw new Exception("Task cannot be empty!");
        if(task.getParentId() == null)
            throw new Exception("Please provide a valid parent ID!");
        if(taskRepository.findByTaskId(task.getParentId()) == null && userRepository.findByUserId(task.getParentId()) == null)
            throw new Exception("Parent does not exist!");
        task.setTaskId(UUID.randomUUID().toString());
        return taskRepository.save(task);
    }

    public List<Task> getTasks(String parentId) throws Exception{

        return taskRepository.findByParentId(parentId);
    }

    public Task updateTask(Task task) throws Exception{
        Task temp = taskRepository.findByTaskId(task.getTaskId());
        if(temp == null)
            throw new Exception("Task does not exist!");
        if(task.getTask() != null)
            temp.setTask(task.getTask());
        temp.setComplete(task.isComplete());
        return taskRepository.save(temp);
    }

    public void deleteTask(Task task){

    }
}
