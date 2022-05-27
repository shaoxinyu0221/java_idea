package com.demo.staticproxy;

public class RealStar implements Star{
    @Override
    public void sing() {
        System.out.println("明星本人唱歌");
    }
}
