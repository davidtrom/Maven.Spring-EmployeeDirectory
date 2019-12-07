package io.zipcoder.persistenceapp.controllers;

import io.zipcoder.persistenceapp.services.EmployeeService;
import io.zipcoder.persistenceapp.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    private EmployeeService empService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.empService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<Iterable<Employee>> findAll() {
        return new ResponseEntity<>(empService.findAllEmps(), HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> findById (@PathVariable Integer id) {
        return new ResponseEntity<>(empService.findEmpById(id), HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEployee (@RequestBody Employee emp) {
        return new ResponseEntity<>(empService.createEmp(emp), HttpStatus.CREATED);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee (@PathVariable Integer id, @RequestBody Employee emp) {
        return new ResponseEntity<>(empService.updateEmp(id, emp), HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Boolean> deleteEmployee (@PathVariable Integer id) {
        return new ResponseEntity<>(empService.delete(id), HttpStatus.OK);
    }
}
