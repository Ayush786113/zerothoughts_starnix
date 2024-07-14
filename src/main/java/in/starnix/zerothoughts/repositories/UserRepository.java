package in.starnix.zerothoughts.repositories;

import in.starnix.zerothoughts.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByEmailAndPassword(String email, String password);
    User findByEmail(String email);
    User findByUserId(String userId);
}
