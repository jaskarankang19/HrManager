package Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import Model.LocationsEntity;
import org.springframework.stereotype.Component;

@Component
public interface LocationRespository extends JpaRepository<LocationsEntity, Integer> {
	public List<LocationsEntity> findByCountryId(String countryId);
	public List<LocationsEntity> findByCity(String cityName);


}
