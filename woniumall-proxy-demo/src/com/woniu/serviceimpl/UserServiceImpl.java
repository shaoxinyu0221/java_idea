package com.woniu.serviceimpl;

import com.woniu.dao.UserDao;
import com.woniu.entity.User;
import com.woniu.exception.AccountIsExist;
import com.woniu.exception.UserNoActive;
import com.woniu.exception.UserWasBanned;
import com.woniu.exception.UsernameOrPasswordEorrException;
import com.woniu.service.UserService;
import com.woniu.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService {

    @Override
    public void login(String account, String password) {
            UserDao userDao = MyBatisUtil.getDao(UserDao.class);
            User user = userDao.queryUserToLogin(account, password);
            if (user==null){
                throw new UsernameOrPasswordEorrException("账号或密码输入错误");
            }else if(user.getStatus().equals(User.UNABLE)){
                throw new UserWasBanned("该账号已被封禁");
            }else if(user.getStatus().equals(User.UNACTIVE)){
                throw new UserNoActive("该账号还未激活,请及时通过邮件激活");
            }else{
                System.out.println("登录成功");
            }
    }

    @Override
    public void register(User user) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            User user1 = userDao.queryUserByAccount(user.getAccount());
            if (user1 != null){
                throw new AccountIsExist("账号已存在,请重新输入");
            }else {
                userDao.insertUserToReg(user);
                System.out.println("注册成功");
            }

    }
}
