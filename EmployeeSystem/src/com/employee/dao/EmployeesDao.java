package com.employee.dao;

import com.employee.entity.Employees;

public interface EmployeesDao {

    Employees qyerryByDepid(Integer did);


    Integer insertEmp(Employees emp);
}
