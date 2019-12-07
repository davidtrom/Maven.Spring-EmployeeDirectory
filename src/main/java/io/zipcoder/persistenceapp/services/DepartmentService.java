package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.models.Department;
import io.zipcoder.persistenceapp.repos.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private DepartmentRepository deptRepo;

    public DepartmentService(DepartmentRepository deptRepo) {
        this.deptRepo = deptRepo;
    }

    public Iterable<Department> findAllDepts () {
        return deptRepo.findAll();
    }

    public Department changeDeptName (Department deptToUpdate) {
        if (deptRepo.findById(deptToUpdate.getDeptNum()).isPresent()) {
            Department origDept = deptRepo.findById(deptToUpdate.getDeptNum()).get();
            origDept.setDeptName(deptToUpdate.getDeptName());
            return deptRepo.save(origDept);
        }
        return null;
    }

    public Department setNewMgr (Department deptToUpdate) {
        if (deptRepo.findById(deptToUpdate.getDeptNum()).isPresent()) {
            Department origDept = deptRepo.findById(deptToUpdate.getDeptNum()).get();
            origDept.setDeptMgr(deptToUpdate.getDeptMgr());
            return deptRepo.save(origDept);
        }
        return null;
    }

    public Department findDeptById(Integer id) {
        if(deptRepo.findById(id).isPresent()) {
            return deptRepo.findById(id).get();
        }
        return null;
    }

    public Department createDept (Department dept) {
        return deptRepo.save(dept);
    }

    public Department updateDept (Integer id, Department dept) {
//        Baker originalBaker = repository.findById(id).get();
//        originalBaker.setName(newBakerData.getName());
//        originalBaker.setEmployeeId(newBakerData.getEmployeeId());
//        originalBaker.setSpecialty(newBakerData.getSpecialty());
        return deptRepo.save(dept);
    }

    public Boolean delete(Integer id) {
        deptRepo.deleteById(id);
        return true;
    }

}
