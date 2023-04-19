package Repository;

import Model.DepartmentsEntity;
import Model.EmployeesEntity;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeRepository extends CrudRepository<EmployeesEntity, Integer> {
	List<EmployeesEntity> findByManagerId(Integer managerId);
	List<EmployeesEntity> findEmployeesEntitiesBySalaryBetween(Double start, Double end);
	List <EmployeesEntity> findByFirstNameEndingWith(String suffix);
	List<EmployeesEntity> findByDepartmentId(Integer departmentId);
	@Query("SELECT emp.departmentId, ROUND(AVG(emp.salary),2) FROM EmployeesEntity emp GROUP BY emp.departmentId ORDER BY emp.departmentId")
	List<Object[]> getAverageSalaryByDepartment();

	@Query("SELECT sup.employeeId,sup.firstName,sup.lastName,count(sub.employeeId), sup.departmentId AS total FROM EmployeesEntity sub JOIN EmployeesEntity sup ON sub.managerId = sup.employeeId\n" +
			"GROUP BY sup.employeeId, sup.firstName, sup.lastName")
	List<Object[]> getEmployeeUnderManager();



}
