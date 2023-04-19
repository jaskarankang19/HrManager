package Repository;

import Model.DepartmentsEntity;
import Model.EmployeesEntity;
import Model.JobsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface JobRepository extends CrudRepository<JobsEntity, Integer> {

}
