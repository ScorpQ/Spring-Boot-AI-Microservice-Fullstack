package userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import userservice.entities.User;

public interface UserRepository extends JpaRepository<User, String> {
    
}
