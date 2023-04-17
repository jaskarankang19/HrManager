package Service;

import Model.CountriesEntity;
import Model.DepartmentsEntity;
import Model.EmployeesEntity;
import Model.LocationsEntity;
import Repository.CountryRepository;
import Repository.DepartmentRepository;

import Repository.EmployeeRepository;
import Repository.LocationRespository;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service("HRManagerService")
@ComponentScan(basePackageClasses = {EmployeeRepository.class})
@ComponentScan(basePackageClasses = {DepartmentRepository.class})
public class HRManagerService {
    
    Logger logger = LoggerFactory.getLogger(HRManagerService.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private LocationRespository locationRespository;

    public void Test() {
        // demonstrate usage of all Repository classes
        //List all employees
        logger.info("\n*****************\nTesting\n*****************");

        Iterable<EmployeesEntity> iterable = employeeRepository.findAll();
        iterable.forEach(emp -> logger.info(emp.getFirstName()));
    }

    public void Question4(){
        logger.info("\n*****************\nQuestion 4\n*****************");

        try {
            List<EmployeesEntity> temp = employeeRepository.findByManagerId(108);
            temp.forEach(emp -> logger.info(emp.toString()));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    public void Question5(){
        logger.info("\n*****************\nQuestion 5\n*****************");

        try {
            List<DepartmentsEntity> temp = departmentRepository.findByLocationId(1700);
            temp.forEach(dept -> logger.info(dept.toString()));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    public void Question6(){
        logger.info("\n*****************\nQuestion 6\n*****************");

        try {
            Iterable<CountriesEntity> temp = countryRepository.findAll();
            StringBuilder sb = new StringBuilder();

            for (CountriesEntity countriesEntity : temp) {
                sb.append("\n ID: "+countriesEntity.getCountryId() + " Count: " + locationRespository.findByCountryId(countriesEntity.getCountryId()).size() + "\n");
            }

            logger.info(sb.toString());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    public void Question7(){
        logger.info("\n*****************\nQuestion 7\n*****************");

        try {
            Iterable<DepartmentsEntity> temp = departmentRepository.findAll();
            StringBuilder sb = new StringBuilder();
            Optional<LocationsEntity> locationsEntity;

            for (DepartmentsEntity departmentsEntity : temp) {
                locationsEntity = locationRespository.findById(departmentsEntity.getLocationId());
                if (locationsEntity.isPresent()) {
                    sb.append("\n ID: "+departmentsEntity.getDepartmentName() + " City: " + locationsEntity.get().getCity() + " State/Province: " + locationsEntity.get().getStateProvince());                    
                }
            }

            logger.info(sb.toString());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}
