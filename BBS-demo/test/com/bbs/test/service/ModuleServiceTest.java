package com.bbs.test.service;

import com.bbs.entity.Module;
import com.bbs.entity.User;
import com.bbs.service.ModuleService;
import com.bbs.util.BBSUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ModuleServiceTest {

    @Test
    public void addMaster(){
        //创建user对象模拟 形参
        User user = new User();
        user.setAccount("1004");
        user.setPassword("123456");
        user.setNickname("企鹅男孩");
        user.setEmail("1004@user.com");
        user.setScore(100);
        user.setAvatar("img/avatar_05");
        user.setRegtime("2000-01-01 00:00:00");

        System.out.println(user);
        //创建板块对象
        Module module01 = new Module();
        module01.setName("猫猫猫猫猫猫");
        module01.setDescription("六只猫");

        Module module02 = new Module();
        module02.setName("狗狗狗狗狗狗");
        module02.setDescription("六只狗");

        List<Module> modules = Arrays.asList(module01, module02);

        //创建业务类对象
        ModuleService moduleService = new ModuleService();
        moduleService.addMaster(user,modules);
    }


}
