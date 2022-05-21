package com.employee.entity;

import java.util.List;

public class Dept {

    private Integer id;
    private String dname;
    List<Employees> employeesList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public List<Employees> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<Employees> employeesList) {
        this.employeesList = employeesList;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", dname='" + dname + '\'' +
                ", employeesList=" + employeesList +
                '}';
    }
}
