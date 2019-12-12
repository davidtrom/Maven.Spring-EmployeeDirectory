package io.zipcoder.persistenceapp.repos;

import io.zipcoder.persistenceapp.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository <Employee, Long> {

    //verb subject predicate
    // p
    //public void deleteEmployeeBy
}
