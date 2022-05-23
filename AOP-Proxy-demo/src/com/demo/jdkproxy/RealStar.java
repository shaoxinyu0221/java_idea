package com.demo.jdkproxy;

public class RealStar implements Star {
    @Override
    public String sing() {
        System.out.println("明星本人唱歌");
        return "歌名";
    }

    @Override
    public void ad() {
        System.out.println("明星本人拍广告");
    }
}
