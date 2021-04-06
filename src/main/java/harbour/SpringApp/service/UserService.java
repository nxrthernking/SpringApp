package harbour.SpringApp.service;

import harbour.SpringApp.exception.UserNotFoundException;
import harbour.SpringApp.mapper.UserMapper;
import harbour.SpringApp.model.User;
import harbour.SpringApp.model.dto.UserDto;
import harbour.SpringApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserDto getById(String userId) {
        return userRepository.findById(parseToLong(userId))
                .map(userMapper::mapToUserDto)
                .orElseThrow(UserNotFoundException::new);
    }

    public List<UserDto> getAll() {
        return userRepository.findAll()
                .stream().map(userMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    public void saveUser(UserDto userDto) {
        userRepository.save(userMapper.mapToUser(userDto));
    }

    public void remove(String userId) {
        userRepository.deleteById(parseToLong(userId));
    }

    private Long parseToLong(String value){
        return Long.valueOf(value);
    }
}
