package com.employee.service;

import com.employee.dao.DeptDao;
import com.employee.dao.EmployeesDao;
import com.employee.entity.Dept;
import com.employee.entity.Employees;
import com.employee.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DeptService {

    public void addDeptAndEmp(Dept dept){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
        EmployeesDao employeesDao = sqlSession.getMapper(EmployeesDao.class);

        try {
            //获取employeesList
            List<Employees> employeesList = dept.getEmployeesList();
            //向部门表中添加数据
            deptDao.addDeptAndEmp(dept);
            //迭代
            for (Employees employees : employeesList) {
                //添加dept,获取主键
                employees.setDepid(dept.getId());
                //向员工表中添加信息
                employeesDao.insertEmp(employees);
            }
            System.out.println("添加成功");
            //提交
            sqlSession.commit();
        } catch (Exception e) {
            //回滚
            sqlSession.rollback();
            System.out.println("添加失败");
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
}
