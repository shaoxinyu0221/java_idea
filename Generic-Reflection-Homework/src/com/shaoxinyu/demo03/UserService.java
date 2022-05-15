package com.shaoxinyu.demo03;

public class UserService {

    public static void main(String[] args) {
        UserDao<User> userDao = new UserDao<>();

        User user01 = new User(1,18,"赵日天");
        User user02 = new User(2,19,"李杀神");
        User user03 = new User(3,20,"王诛魔");
        User user04 = new User(4,21,"刘斩仙");
        User user05 = new User(5,21,"章鱼哥");

        //调方法
        //存数据
        userDao.save("1",user01);
        userDao.save("2",user02);
        userDao.save("3",user03);
        userDao.save("4",user04);

        //遍历集合
        userDao.getUserList();

        //根据id查数据
        User user = userDao.getUser("1");
        System.out.println(user);

        //删除数据
        userDao.delete("1");
        userDao.getUserList();


        //更新
        userDao.update("4",user05);
        User user5 = userDao.getUser("4");
        System.out.println(user5);

    }

}
