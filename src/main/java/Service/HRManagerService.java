package Service;

import Model.EmployeesEntity;
import Repository.DepartmentRepository;

import Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service("HRManagerService")
@ComponentScan(basePackageClasses = {EmployeeRepository.class})
@ComponentScan(basePackageClasses = {DepartmentRepository.class})
public class HRManagerService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public void Test() {
        // demonstrate usage of all Repository classes
        //List all employees
        Iterable<EmployeesEntity> iterable = employeeRepository.findAll();
        iterable.forEach(emp -> System.out.println(emp.getFirstName()));
    }
}
