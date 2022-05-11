package com.shaoxinyu.lesson01;

import com.shaoxinyu.dao.BookJdbc;
import com.shaoxinyu.entity.User;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        BookJdbc bookJdbc = new BookJdbc();
        int add = bookJdbc.add();
        System.out.println("增加了"+add+"行");
        int delete = bookJdbc.delete();
        System.out.println("删除了"+delete+"行");
        int update = bookJdbc.update();
        System.out.println("修改了"+update+"行");

        List<User> query = bookJdbc.query();
        for (User user : query){
            System.out.println(user.getUsername());
        }

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }
}
