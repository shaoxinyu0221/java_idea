package com.employee.test.dao;

import com.employee.dao.DeptDao;
import com.employee.entity.Dept;
import com.employee.entity.Employees;
import com.employee.service.DeptService;
import com.employee.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DeptDaoTest {

    SqlSession sqlSession = null;
    DeptDao deptDao = null;

    @Before
    public void getUp(){
        sqlSession = MyBatisUtil.getSqlSession();
        deptDao = sqlSession.getMapper(DeptDao.class);
    }

    @After
    public void tearDown(){
        //sqlSession.commit();
        MyBatisUtil.close(sqlSession);
    }


    @Test
    public void testQueryDept(){
        Dept dept = deptDao.queryAllEmployees(1);
        System.out.println("=====部门信息=====");
        System.out.println("部门编号\t部门名称");
        String dname = dept.getDname();
        System.out.println(dept.getId()+"\t"+dname);
        System.out.println("====="+dname+"员工信息如下=====");
        System.out.println("员工编号\t姓名\t年龄\t性别");
        for (Employees employee : dept.getEmployeesList()) {
            System.out.println(employee.getId()+"\t"+employee.getUsername()+"\t"+
                    employee.getAge()+"\t"+employee.getSex());
        }

    }


    @Test
    public void testAddDept(){
        Dept dept = new Dept();
        dept.setDname("交通部");

        Employees employee01 = new Employees();
        employee01.setUsername("梦比优斯");
        employee01.setAge(23);
        employee01.setSex("男");

        Employees employee02 = new Employees();
        employee02.setUsername("赛罗");
        employee02.setAge(22);
        employee02.setSex("女");

        List<Employees> employees = Arrays.asList(employee01, employee02);
        dept.setEmployeesList(employees);


        DeptService deptService = new DeptService();
        deptService.addDeptAndEmp(dept);
    }



}
