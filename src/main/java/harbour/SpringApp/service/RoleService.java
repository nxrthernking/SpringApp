package harbour.SpringApp.service;

import harbour.SpringApp.mapper.RoleMapper;
import harbour.SpringApp.model.dto.RoleDto;
import harbour.SpringApp.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    private final RoleMapper mapper;

    public RoleDto getById(String roleId) {
        return roleRepository.findById(parseToLong(roleId))
                .map(mapper::mapToRoleDto)
                .orElseThrow();
    }

    public List<RoleDto> getAll(){
        return roleRepository.findAll()
                .stream()
                .map(mapper::mapToRoleDto)
                .collect(Collectors.toList());
    }

    public void saveRole(RoleDto roleDto){
        roleRepository.save(mapper.mapToRole(roleDto));
    }

    public void remove(String roleId){
        roleRepository.deleteById(parseToLong(roleId));
    }

    private Long parseToLong(String value){
        return Long.valueOf(value);
    }

}
