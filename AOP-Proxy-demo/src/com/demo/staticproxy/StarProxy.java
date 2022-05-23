package com.demo.staticproxy;

public class StarProxy implements Star{
    /**
     * 代理对象将目标对象作为自己的一个私有化属性,不让他人随意访问
     */
    private RealStar realStar;

    /**
     * 通过构造方法,
     * @param realStar
     */
    public StarProxy(RealStar realStar) {
        this.realStar = realStar;
    }


    @Override
    public void sing() {
        /**
         * 通过私有方法,调用目标对象的方法来完成自己实现的接口中的方法
         */
        System.out.println("开始前的谈判");
        realStar.sing();
        System.out.println("结束后的收尾");
    }
}
