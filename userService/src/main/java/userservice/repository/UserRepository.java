package java.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.userservice.entities.User;

public interface UserRepository extends JpaRepository<User, String> {
    
}
