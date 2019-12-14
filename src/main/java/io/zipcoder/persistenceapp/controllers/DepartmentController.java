package io.zipcoder.persistenceapp.controllers;

import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.services.DepartmentService;
import io.zipcoder.persistenceapp.models.Department;
import io.zipcoder.persistenceapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService deptService;


    @GetMapping("/departments")
    public ResponseEntity<Iterable<Department>> findAll() {
        return new ResponseEntity<>(deptService.findAllDepts(), HttpStatus.OK);
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> findById (@PathVariable Integer id) {
        return new ResponseEntity<>(deptService.findDeptById(id), HttpStatus.OK);
    }

//    @PutMapping("/departments/{id}")
//    public ResponseEntity<Department> changeDeptName (@PathVariable Integer id, @RequestBody Department dept){
//        return new ResponseEntity<>(deptService.updateDept(id, dept), HttpStatus.ACCEPTED);
//    }

//    @GetMapping("/departments/{id}/employees")
//    public ResponseEntity<Iterable<Employee>> findAllEmpolyeesByDept() {
//        return new ResponseEntity<>(deptService.findAllDepts(), HttpStatus.OK);
//    }


//    @PutMapping("/departments/{id}")
//    public ResponseEntity<Department> updateMgr (@RequestBody Department dept) {
//        return new ResponseEntity<>(deptService.setNewMgr(dept), HttpStatus.ACCEPTED);
//    }

    @PostMapping("/departments")
    public ResponseEntity<Department> createEployee (@RequestBody Department dept) {
        return new ResponseEntity<>(deptService.createDept(dept), HttpStatus.CREATED);
    }

    @PutMapping("/departments/{id}")
    public ResponseEntity<Department> updateEmployee (@PathVariable Integer id, @RequestBody Department dept) {
        return new ResponseEntity<>(deptService.updateDept(id, dept), HttpStatus.OK);
    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity<Boolean> deleteEmployee (@PathVariable Integer id) {
        return new ResponseEntity<>(deptService.delete(id), HttpStatus.OK);
    }

    @PutMapping("/departments/{id}")
    public ResponseEntity<Boolean> removeEmpsFromDept (@PathVariable Integer deptId){
        return new ResponseEntity<>(deptService.removeAllEmpsByDept(deptId), HttpStatus.OK);
    }

    @PutMapping("/departments/merge{A}to{B}")
    public ResponseEntity<Boolean> mergeDepts (@PathVariable Department deptA, @PathVariable Department deptB){
        return new ResponseEntity<>(deptService.mergeDepts(deptA, deptB), HttpStatus.OK);
    }




}
