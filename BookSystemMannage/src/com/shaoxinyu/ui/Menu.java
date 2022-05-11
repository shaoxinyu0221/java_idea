package com.shaoxinyu.ui;

import com.shaoxinyu.service.BookService;

import java.util.Scanner;

public class Menu {

    Scanner input = new Scanner(System.in);

    BookService bs = new BookService();
    public void firstMenu(){
        System.out.println("===========欢迎使用图书管理系统===========");
        while (true){
            System.out.println("1.登录   2.注册   3.退出");
            String choose = input.next();
            switch(choose){
                case "1":
                    System.out.println("登录");
                    secondMenu();
                    break;
                case "2":
                    System.out.println("注册");
                    break;
                case "3":
                    System.out.println("欢迎下次使用");
                    System.exit(0);
                default:
                    System.out.println("输入有误,重新输入");
                    break;
            }
        }
    }


    public void secondMenu(){
        while (true){
            System.out.println("1.显示书籍列表  2.添加书籍  3.更新书籍  4.删除书籍  5.返回上级菜单");
            String choose = input.next();
            switch(choose){
                case "1":
                    System.out.println("书籍列表");
                    bs.queryAll();
                    break;
                case "2":
                    System.out.println("添加书籍");
                    break;
                case "3":
                    System.out.println("更新书籍");
                    break;
                case "4":
                    System.out.println("删除书籍");
                    break;
                case "5":
                    return;
                default:
                    System.out.println("输入有误,重新输入");
                    break;
            }
        }
    }
}
