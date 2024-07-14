package in.starnix.zerothoughts.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "tasks_test")
public class Task {
    @Id
    private String taskId;
    private String task;
    private boolean isComplete;
    private String parentId;
}
