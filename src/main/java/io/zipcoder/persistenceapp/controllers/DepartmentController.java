package io.zipcoder.persistenceapp.controllers;

import io.zipcoder.persistenceapp.services.DepartmentService;
import io.zipcoder.persistenceapp.models.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DepartmentController {

        private DepartmentService deptService;

        @Autowired
        public DepartmentController(DepartmentService deptService) {
            this.deptService = deptService;
        }

        @GetMapping("/departments")
        public ResponseEntity<Iterable<Department>> findAll() {
            return new ResponseEntity<>(deptService.findAllDepts(), HttpStatus.OK);
        }

        @GetMapping("/departments")
        public ResponseEntity<Department> changeDeptName (@RequestBody Department dept){
            return new ResponseEntity<>(deptService.changeDeptName(dept), HttpStatus.ACCEPTED);
        }

        @GetMapping("/departments/{id}")
        public ResponseEntity<Department> findById (@PathVariable Integer id) {
            return new ResponseEntity<>(deptService.findDeptById(id), HttpStatus.OK);
        }

        @GetMapping("/departments")
        public ResponseEntity<Department> updateMgr (@RequestBody Department dept) {
            return new ResponseEntity<>(deptService.setNewMgr(dept), HttpStatus.ACCEPTED);
        }

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
}
