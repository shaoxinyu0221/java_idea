package com.demo.cglib;

import com.demo.jdkproxy.Star;

public class RealStar{

    public String sing() {
        System.out.println("明星本人唱歌");
        return "歌名";
    }


    public void ad() {
        System.out.println("明星本人拍广告");
    }
}
