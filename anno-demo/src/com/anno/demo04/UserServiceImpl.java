package com.anno.demo04;

import com.anno.util.MyBatisUtil;
@Transactional
public class UserServiceImpl implements UserService{
    @Override
    public Integer addUser(User user) {
        UserDao userDao = MyBatisUtil.getDao(UserDao.class);
        Integer integer = userDao.add(user);
        return integer;
    }
}
