package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private EmployeeRepository empRepo;

    @Autowired
    public EmployeeService (EmployeeRepository empRepo) {
        this.empRepo = empRepo;
    }

    public Iterable<Employee> findAllEmps () {
        return empRepo.findAll();
    }

    public Employee findEmpById(Long id) {
        return empRepo.findById(id).get();
    }

        public Employee createEmp (Employee emp) {
        return empRepo.save(emp);
    }

    public Employee updateEmp (Long id, Employee emp) {
//        Baker originalBaker = repository.findById(id).get();
//        originalBaker.setName(newBakerData.getName());
//        originalBaker.setEmployeeId(newBakerData.getEmployeeId());
//        originalBaker.setSpecialty(newBakerData.getSpecialty());
        return empRepo.save(emp);
    }

    public Boolean delete(Long id) {
        empRepo.deleteById(id);
        return true;
    }

    public Employee setManager (Long id, String manager){
        Employee originalEmp = seeIfPresent(id);
        originalEmp.setManager(manager);
        //Integer newDept = manager.
        return null;
    }

    public Employee seeIfPresent (Long id) {
        if (empRepo.findById(id).isPresent()){
            return empRepo.findById(id).get();
        }
        return null;
    }


}


