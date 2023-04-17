package Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import Model.LocationsEntity;

public interface LocationRespository extends CrudRepository<LocationsEntity, Integer> {
	public List<LocationsEntity> findByCountryId(String countryId);
}
