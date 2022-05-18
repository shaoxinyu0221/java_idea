package com.bbs.test.dao;

import com.bbs.dao.ModuleDao;
import com.bbs.entity.Module;
import com.bbs.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ModuleDaoTest {

    SqlSession sqlSession = null;

    ModuleDao moduleDao = null;

    @Before
    public void getUp(){
        sqlSession = MyBatisUtil.getSqlSession();
        moduleDao = sqlSession.getMapper(ModuleDao.class);
    }
    @After
    public void tearDown(){
        sqlSession.commit();
        MyBatisUtil.close(sqlSession);
    }

    @Test
    public void queryModuleById(){
        Module module = moduleDao.queryModuleById(1);
        System.out.println(module);
    }

    @Test
    public void queryModuleMainById(){
        Module module = moduleDao.queryModuleMainById(1);
        System.out.println(module);
    }

}
