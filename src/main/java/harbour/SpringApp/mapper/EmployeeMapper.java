package harbour.SpringApp.mapper;

import harbour.SpringApp.model.Employee;
import harbour.SpringApp.model.dto.EmployeeDto;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public Employee mapToEmployee(EmployeeDto employeeDto){
        return Employee.builder()
                .id(employeeDto.getId())
                .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .telephone(employeeDto.getTelephone())
                .address(employeeDto.getAddress())
                .build();
    }

    public EmployeeDto mapToEmployeeDto(Employee employee){
        return EmployeeDto.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .telephone(employee.getTelephone())
                .address(employee.getAddress())
                .build();
    }
}
