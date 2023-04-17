package Repository;

import Model.DepartmentsEntity;
import Model.EmployeesEntity;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeRepository extends CrudRepository<EmployeesEntity, Integer> {
	List<EmployeesEntity> findByManagerId(Integer managerId);
	List<EmployeesEntity> findEmployeesEntitiesBySalaryBetween(Double start, Double end);
	List <EmployeesEntity> findByFirstNameEndingWith(String suffix);
	List<EmployeesEntity> findByDepartmentId(Integer departmentId);



}
