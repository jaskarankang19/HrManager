package Repository;

import Model.DepartmentsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface DepartmentRepository extends CrudRepository<DepartmentsEntity, Integer> {
	List<DepartmentsEntity> findByLocationId(Integer locationId);
}
