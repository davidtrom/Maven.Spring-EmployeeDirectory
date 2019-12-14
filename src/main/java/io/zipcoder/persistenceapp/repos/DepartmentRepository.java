package io.zipcoder.persistenceapp.repos;

import io.zipcoder.persistenceapp.models.Department;
import io.zipcoder.persistenceapp.models.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository <Department, Integer> {

    Iterable<Employee> findAllByDeptNum(Integer deptId);

    //Iterable<Employee> findAllByDeptName(String name);

    //@Query


}
