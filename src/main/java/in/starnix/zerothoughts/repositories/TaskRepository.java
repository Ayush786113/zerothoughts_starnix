package in.starnix.zerothoughts.repositories;

import in.starnix.zerothoughts.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {
    Task findByTaskId(String taskId);
    List<Task> findByParentId(String parentId);
}
