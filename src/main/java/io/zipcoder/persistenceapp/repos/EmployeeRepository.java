package io.zipcoder.persistenceapp.repos;

import io.zipcoder.persistenceapp.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository <Employee, Long> {

    //verb subject predicate
    //public void deleteEmployeeBy

    Iterable<Employee> findAllByManagerIsNull ();

    Iterable<Employee> findAllByManager(Long managerId);

   void deleteEmployeesByManagerAndManager (Long managerId);

   Boolean deleteAllByEmployeeNum(Iterable<Long> empIds);

   Iterable<Employee> findAllByManagerNotNull (Long managerId);


}
