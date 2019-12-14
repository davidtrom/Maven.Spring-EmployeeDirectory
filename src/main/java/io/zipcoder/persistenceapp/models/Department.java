package io.zipcoder.persistenceapp.models;

import javax.persistence.*;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer deptNum;
    String deptName;
    @ManyToOne
    Employee deptMgr;

    public Department () {}

    public Department(Integer deptNum, String deptName, Employee deptMgr) {
        this.deptNum = deptNum;
        this.deptName = deptName;
        this.deptMgr = deptMgr;
    }

    public Department(String deptName, Employee deptMgr) {
        this.deptName = deptName;
        this.deptMgr = deptMgr;
    }

    public Integer getDeptNum() {
        return deptNum;
    }

    public void setDeptNum(Integer deptNum) {
        this.deptNum = deptNum;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Employee getDeptMgr() {
        return deptMgr;
    }

    public void setDeptMgr(Employee deptMgr) {
        this.deptMgr = deptMgr;
    }


}
