package userservice.servies;

import userservice.entities.User;
import userservice.dto.UserResponse;
import userservice.dto.RegisterRequest;
import userservice.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponse getUserProfileById(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return new UserResponse(user);
    }
    
    public UserResponse register(RegisterRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        
        User savedUser = userRepository.save(user);
        return new UserResponse(savedUser);
    }

}
