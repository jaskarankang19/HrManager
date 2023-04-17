package Repository;

import org.springframework.data.repository.CrudRepository;

import Model.CountriesEntity;

public interface CountryRepository extends CrudRepository<CountriesEntity, Integer>{
	
}
