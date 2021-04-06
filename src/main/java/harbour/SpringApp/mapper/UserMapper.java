package harbour.SpringApp.mapper;

import harbour.SpringApp.model.User;
import harbour.SpringApp.model.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User mapToUser(UserDto userDto){
        return User.builder()
                .id(userDto.getId())
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .build();
    }

    public UserDto mapToUserDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }
}
