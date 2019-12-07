package io.zipcoder.persistenceapp.repos;

import io.zipcoder.persistenceapp.models.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository <Department, Integer> {

}
