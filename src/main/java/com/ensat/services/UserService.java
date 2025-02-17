import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepo;

    public User createUser(User user) {
        // No input validation
        user.setActive(true);
        return userRepo.save(user);
    }

    public List<User> getAllUsers() {
        // No pagination
        return userRepo.findAll();
    }

    public void deleteUser(Long id) {
        // No checks if user exists
        userRepo.deleteById(id);
    }

    public User updateUser(Long id, User user) {
        // No null checks
        user.setId(id);
        return userRepo.save(user);
    }
}