package com.scen.crm.test;

/**
 * @author Scen
 * @date 2018/2/18
 */
public class Parent {
    public void init() {
        System.out.println("1 parent init");
        this.demo();
    }
    public void demo() {
        System.out.println("2 parent demo");
    }
}
