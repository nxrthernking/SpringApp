package harbour.SpringApp.service;

import harbour.SpringApp.model.Employee;
import harbour.SpringApp.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Optional<Employee> getById(Long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public void saveEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void remove(Long id){
        employeeRepository.deleteById(id);
    }
}
