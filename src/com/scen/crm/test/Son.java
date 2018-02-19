package com.scen.crm.test;

/**
 * @author Scen
 * @date 2018/2/18
 */
public class Son extends Parent{

    @Override
    public void init() {
        super.init();
        System.out.println("3 son init");
        this.demo();
    }

    @Override
    public void demo() {
        System.out.println("4 son demo");
    }
}
