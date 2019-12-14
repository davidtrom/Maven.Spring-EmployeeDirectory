package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeService {

    private EmployeeRepository empRepo;

    @Autowired
    public EmployeeService(EmployeeRepository empRepo) {
        this.empRepo = empRepo;
    }

    public Iterable<Employee> findAllEmps() {
        return empRepo.findAll();
    }

    public Employee findEmpById(Long id) {
            return seeIfPresent(id);
    }

    public Employee createEmp(Employee emp) {
        return empRepo.save(emp);
    }

    public Employee updateEmp(Long id, Employee empNewData) {
        Employee emp = seeIfPresent(id);
        emp.setFirstName(empNewData.getFirstName());
        emp.setLastName(empNewData.getLastName());
        emp.setTitle(empNewData.getTitle());
        emp.setPhoneNum(empNewData.getPhoneNum());
        emp.setEmail(empNewData.getEmail());
        emp.setDateOfHire(empNewData.getDateOfHire());
        emp.setManager(empNewData.getManager());
        emp.setDeptNum(empNewData.getDeptNum());
        return empRepo.save(emp);
    }

    public Iterable<Employee> findAllUnassignedEmps () {
        return empRepo.findAllByManagerIsNull();
    }

    public Iterable<Employee> findAllEmpsByManager (Long managerId) {
        return empRepo.findAllByManager(managerId);
    }

    public Boolean deleteMultipleEmps (Iterable<Long> empIds) {
        empRepo.deleteAllByEmployeeNum(empIds);
        return true;
    }

    public Boolean delete(Long empId) {
        empRepo.deleteById(empId);
        return true;
    }

    public Boolean removeEmpsByManager (Long managerId){
        Iterable<Employee> nonNull = empRepo.findAllByManagerNotNull(managerId);
        return false;
    }

    public Employee seeIfPresent(Long id) {
        if (empRepo.findById(id).isPresent()) {
            return empRepo.findById(id).get();
        }
        return null;
    }

}


