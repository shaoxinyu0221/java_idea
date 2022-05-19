package com.bbs.service;

import com.bbs.dao.ModuleDao;
import com.bbs.dao.UserDao;
import com.bbs.entity.Module;
import com.bbs.entity.User;
import com.bbs.util.MyBatisUtil;

import java.util.List;

public class ModuleService {

    public void addMaster(User user, List<Module> modules){
        UserDao userDao = MyBatisUtil.getSqlSession().getMapper(UserDao.class);
        ModuleDao moduleDao = MyBatisUtil.getSqlSession().getMapper(ModuleDao.class);

        try {
            //设置user的属性
            user.setTopicnums(400);
            user.setReplaynums(1000);
            user.setRole(User.MASTER);
            //向表中添加数据
            userDao.insert(user);
            //为板块设置版主
            for (Module module : modules) {
                module.setMaster(user.getId());
                //向表中添加数据
                moduleDao.addModule(module);
            }
            //提交
            MyBatisUtil.getSqlSession().commit();
            System.out.println("设置成功");
        } catch (Exception e) {
            e.printStackTrace();
            MyBatisUtil.getSqlSession().rollback();
            System.out.println("设置失败");
        }finally {
            MyBatisUtil.close(MyBatisUtil.getSqlSession());
        }

    }


}
