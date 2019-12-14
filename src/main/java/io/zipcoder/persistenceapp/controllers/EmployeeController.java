package io.zipcoder.persistenceapp.controllers;

import io.zipcoder.persistenceapp.services.DepartmentService;
import io.zipcoder.persistenceapp.services.EmployeeService;
import io.zipcoder.persistenceapp.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService empService;
    @Autowired
    private DepartmentService deptService;

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> findById (@PathVariable Long id) {
        try {
            return new ResponseEntity<>(empService.findEmpById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee (@PathVariable Long id, @RequestBody Employee emp) {
        try{
            return new ResponseEntity<>(empService.updateEmp(id, emp), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Boolean> deleteEmployee (@PathVariable Long id) {
        return new ResponseEntity<>(empService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/employees/unassigned")
    public ResponseEntity<Iterable<Employee>> findAllUnassignedEmps () {
        return new ResponseEntity<>(empService.findAllUnassignedEmps(), HttpStatus.OK);
    }

    @GetMapping("/employees/manager/{managerId}")
    public ResponseEntity<Iterable<Employee>> findAllEmpsByManager(@PathVariable Long managerId) {
        return new ResponseEntity<>(empService.findAllEmpsByManager(managerId), HttpStatus.OK);
    }

    @GetMapping("/employees/dept/{deptId}")
    public ResponseEntity<Iterable<Employee>> findAllEmpsByDept (@PathVariable Integer deptId) {
        return new ResponseEntity<>(deptService.findAllEmpsByDept(deptId), HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEployee (@RequestBody Employee emp) {
        return new ResponseEntity<>(empService.createEmp(emp), HttpStatus.CREATED);
    }

    @GetMapping("/employees")
    public ResponseEntity<Iterable<Employee>> findAll() {
        return new ResponseEntity<>(empService.findAllEmps(), HttpStatus.OK);
    }

    @DeleteMapping("/employees/")
    public ResponseEntity<Boolean> deleteMultipleEmps (@RequestBody Iterable<Long> empIds) {
        return new ResponseEntity<> (empService.deleteMultipleEmps(empIds), HttpStatus.OK);
    }

}
