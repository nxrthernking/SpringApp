package harbour.SpringApp.service;

import harbour.SpringApp.model.User;
import harbour.SpringApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public void remove(Long id){
        userRepository.deleteById(id);
    }
}
