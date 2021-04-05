package harbour.SpringApp.service;

import harbour.SpringApp.model.Role;
import harbour.SpringApp.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Optional<Role> getById(Long id) {
        return roleRepository.findById(id);
    }

    public List<Role> getAll(){
        return roleRepository.findAll();
    }

    public void saveRole(Role role){
        roleRepository.save(role);
    }

    public void remove(Long id){
        roleRepository.deleteById(id);
    }
}
