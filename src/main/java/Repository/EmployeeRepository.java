package Repository;

import Model.EmployeesEntity;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeRepository extends CrudRepository<EmployeesEntity, Integer> {
	List<EmployeesEntity> findByManagerId(Integer managerId);
}
