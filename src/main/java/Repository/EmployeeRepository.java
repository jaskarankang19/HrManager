package Repository;

import Model.EmployeesEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeRepository extends CrudRepository<EmployeesEntity, Integer> {

}
