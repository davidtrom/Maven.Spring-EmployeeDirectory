package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.models.Department;
import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.repos.DepartmentRepository;
import io.zipcoder.persistenceapp.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private DepartmentRepository deptRepo;
    private EmployeeRepository empRepo;

    public DepartmentService(DepartmentRepository deptRepo, EmployeeRepository empRepo) {
        this.deptRepo = deptRepo;
    }

    public Iterable<Department> findAllDepts () {
        return deptRepo.findAll();
    }

//    public Department changeDeptName (Integer id, Department deptToUpdate) {
//        Department origDept = findDeptById(id);
//        origDept.setDeptName(deptToUpdate.getDeptName());
//        return deptRepo.save(origDept);
//    }

//    public Department setNewMgr (Department deptToUpdate) {
//        if (deptRepo.findById(deptToUpdate.getDeptNum()).isPresent()) {
//            Department origDept = deptRepo.findById(deptToUpdate.getDeptNum()).get();
//            origDept.setDeptMgr(deptToUpdate.getDeptMgr());
//            return deptRepo.save(origDept);
//        }
//        return null;
//    }

    public Department findDeptById(Integer deptId) {
        if(deptRepo.findById(deptId).isPresent()) {
            return deptRepo.findById(deptId).get();
        }
        return null;
    }

    public Department createDept (Department dept) {
        return deptRepo.save(dept);
    }

    public Department updateDept (Integer deptId, Department newDeptInfo) {
        Department dept = findDeptById(deptId);
        dept.setDeptNum(newDeptInfo.getDeptNum());
        dept.setDeptMgr(newDeptInfo.getDeptMgr());
        dept.setDeptName(newDeptInfo.getDeptName());
        return deptRepo.save(dept);
    }

    public Boolean delete(Integer id) {
        deptRepo.deleteById(id);
        return true;
    }

    public Iterable<Employee> findAllEmpsByDept (Integer deptId) {
        return deptRepo.findAllByDeptNum(deptId);
    }

    public Boolean removeAllEmpsByDept (Integer deptId) {
        Iterable<Employee> allEmpsInDept = findAllEmpsByDept(deptId);
        for(Employee employee : allEmpsInDept) {
            employee.setDeptNum(null);
            empRepo.save(employee);
        }
        return true;
    }

    public Boolean mergeDepts (Department deptA, Department deptB) {
        Iterable<Employee> allBEmps = findAllEmpsByDept(deptB.getDeptNum());
        for (Employee deptBEmps : allBEmps ){
            deptBEmps.setDeptNum(deptA.getDeptNum());
            deptBEmps.setManager(deptA.getDeptMgr());
        }
        return true;
    }



}
