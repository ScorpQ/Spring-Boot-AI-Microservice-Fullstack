package userservice.dto;

import java.time.LocalDateTime;
import lombok.Data;
import userservice.entities.User;

@Data
public class UserResponse {

    public UserResponse(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
    }
    private String id;
    private String email;
    private String password;
    private String lastName;
    private String firstName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
