package Service;

import Model.*;
import Repository.*;

import java.math.BigDecimal;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service("HRManagerService")
@ComponentScan(basePackageClasses = {EmployeeRepository.class})
@ComponentScan(basePackageClasses = {DepartmentRepository.class})
@ComponentScan(basePackageClasses = {LocationRespository.class})
@ComponentScan(basePackageClasses = {JobRepository.class})
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
    @Autowired
    private JobRepository jobRepository;
    public void Test() {
        // demonstrate usage of all Repository classes
        //List all employees
        logger.info("\n*****************\nTesting\n*****************");

        Iterable<EmployeesEntity> iterable = employeeRepository.findAll();
        iterable.forEach(emp -> logger.info(emp.getFirstName()));
    }

    public void Question1(){
        logger.info("\n*****************\nQuestion 1: Employees with salary ranging $9-17k\n*****************");

        try {
            StringBuilder sb = new StringBuilder();
            List<EmployeesEntity> temp = employeeRepository.findEmployeesEntitiesBySalaryBetween(9000.0, 17000.0);
            temp.forEach(emp -> sb.append("\n Name: "+emp.getFirstName()+" "+emp.getLastName()+"\n"));
            System.out.println(sb.toString());
        } catch (Exception e){
            logger.error(e.getMessage(), e);
        }
    }

    public void Question2(){
        logger.info("\n*****************\nQuestion 2: First Name ending in 'A'\n*****************");

        try {
            StringBuilder sb = new StringBuilder();
            List<EmployeesEntity> temp = employeeRepository.findByFirstNameEndingWith("a");
            temp.forEach(emp -> sb.append("\n Name: "+emp.getFirstName()+" "+emp.getLastName()+"\n"));
            System.out.println(sb.toString());

        } catch (Exception e){
            logger.error(e.getMessage(), e);
        }

    }

    public void Question3(){
        logger.info("\n*****************\nQuestion 3: All Employees in Accounting\n*****************");

        try {
            StringBuilder sb = new StringBuilder();
            List<EmployeesEntity> temp = employeeRepository.findByDepartmentId(11);
            temp.forEach(emp -> sb.append("\n Name: "+emp.getFirstName()+" "+emp.getLastName()+"\n"));
            System.out.println(sb.toString());

        } catch (Exception e){
            logger.error(e.getMessage(), e);
        }

    }

    public void Question4(){
        logger.info("\n*****************\nQuestion 4: Employees with manager Id 108\n*****************");

        try {
            StringBuilder sb = new StringBuilder();
            List<EmployeesEntity> temp = employeeRepository.findByManagerId(108);
            temp.forEach(emp -> sb.append("\n Name: "+emp.getFirstName()+" "+emp.getLastName()+"\n"));
            System.out.println(sb.toString());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    public void Question5(){
        logger.info("\n*****************\nQuestion 5:Departments with Location Id 1700\n*****************");

        try {
            StringBuilder sb = new StringBuilder();
            List<DepartmentsEntity> temp = departmentRepository.findByLocationId(1700);
            temp.forEach(loc -> sb.append("\n Department: "+loc.getDepartmentName()+"\n"));
            System.out.println(sb.toString());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    public void Question6(){
        logger.info("\n*****************\nQuestion 6: Number of cities each country has\n*****************");

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
        logger.info("\n*****************\nQuestion 7 : Department name, city, and state province for each department\n*****************");

        try {
            Iterable<DepartmentsEntity> temp = departmentRepository.findAll();
            StringBuilder sb = new StringBuilder();
            Optional<LocationsEntity> locationsEntity;

            for (DepartmentsEntity departmentsEntity : temp) {
                locationsEntity = locationRespository.findById(departmentsEntity.getLocationId());
                if (locationsEntity.isPresent()) {
                    sb.append("\n Department: "+departmentsEntity.getDepartmentName() + " City: " + locationsEntity.get().getCity() + " State/Province: " + locationsEntity.get().getStateProvince());
                }
            }

            logger.info(sb.toString());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
    public void Question8()
    {
        logger.info("\n*****************\nQuestion 8: Last name, job, department number and department name for all employees who work in ‘Toronto’ city.\n*****************");
        try {
            List<LocationsEntity> temp = locationRespository.findByCity("Toronto");
            StringBuilder sb = new StringBuilder();
            List<DepartmentsEntity> departmentsEntity=new ArrayList<>();
            List<EmployeesEntity> employeesEntities=new ArrayList<>();
            Optional<JobsEntity> jobsEntity;
            Optional<DepartmentsEntity> dept;
            for (LocationsEntity locationsEntity : temp) {
                    departmentsEntity=departmentRepository.findByLocationId(locationsEntity.getLocationId());
            }
            for (DepartmentsEntity a : departmentsEntity) {
                employeesEntities=employeeRepository.findByDepartmentId(a.getDepartmentId());
            }
            for (EmployeesEntity e : employeesEntities) {
                jobsEntity = jobRepository.findById(e.getJobId());
                dept=departmentRepository.findById(e.getDepartmentId());
                sb.append("\n Last Name: "+e.getLastName()+" Job Title: "+jobsEntity.get().getJobTitle()+" Department Number: "+e.getDepartmentId()+" Department Name: "+dept.get().getDepartmentName());
                sb.append("\n ---------------------------");
            }
            logger.info(sb.toString());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
    public void Question9()
    {
        logger.info("\n*****************\nQuestion 9 : Average of sum of the salaries and group the result with the department id. Order the result with department id\n*****************");
        List<Object[]> employeesEntities=employeeRepository.getAverageSalaryByDepartment();
        StringBuilder sb = new StringBuilder();
        for (Object[] row : employeesEntities) {
            sb.append("\n Department Id: "+row[0]+" Average Salary: $"+row[1]);
            sb.append("\n ---------------------------");

        }
        logger.info(sb.toString());
    }
    public void Question10()
    {
        logger.info("\n*****************\nQuestion 10 : Manager name, department id of manager, the count of employees working under that manager as Total_Employees\n*****************");
        List<Object[]> employeesEntities=employeeRepository.getEmployeeUnderManager();
        StringBuilder sb = new StringBuilder();
        for (Object[] row : employeesEntities) {
            sb.append("\n Full Name: "+row[1]+" "+row[2]+" Department Id: "+row[4]+" Total_Employees: "+row[3]);
            sb.append("\n ---------------------------");

        }
        logger.info(sb.toString());
    }


}
