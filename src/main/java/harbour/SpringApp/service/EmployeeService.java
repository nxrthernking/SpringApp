package harbour.SpringApp.service;

import harbour.SpringApp.mapper.EmployeeMapper;
import harbour.SpringApp.model.dto.EmployeeDto;
import harbour.SpringApp.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper mapper;

    public EmployeeDto getById(String employeeId) {
        return employeeRepository
                .findById(parseToLong(employeeId))
                .map(mapper::mapToEmployeeDto)
                .orElseThrow();
    }

    public List<EmployeeDto> getAll(){
        return employeeRepository.findAll()
                .stream()
                .map(mapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    public void saveEmployee(EmployeeDto employeeDto){
        employeeRepository.save(mapper.mapToEmployee(employeeDto));
    }

    public void remove(String employeeId){
        employeeRepository.deleteById(parseToLong(employeeId));
    }

    private Long parseToLong(String value){
        return Long.valueOf(value);
    }

}
