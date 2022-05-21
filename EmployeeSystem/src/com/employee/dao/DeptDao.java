package com.employee.dao;

import com.employee.entity.Dept;

public interface DeptDao {

    Dept queryAllEmployees(Integer id);

    Integer addDeptAndEmp(Dept dept);

}
