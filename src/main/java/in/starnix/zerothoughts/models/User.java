package in.starnix.zerothoughts.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;

@Data
@Entity
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "users_test")
public class User {
    @Id
    private String userId;
    private String name, email, password;
}
