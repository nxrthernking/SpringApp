package harbour.SpringApp.mapper;

import harbour.SpringApp.model.Role;
import harbour.SpringApp.model.dto.RoleDto;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    public Role mapToRole(RoleDto roleDto){
        return Role.builder()
                .id(roleDto.getId())
                .name(roleDto.getName())
                .build();
    }

    public RoleDto mapToRoleDto(Role role){
        return RoleDto.builder()
                .id(role.getId())
                .name(role.getName())
                .build();
    }
}
