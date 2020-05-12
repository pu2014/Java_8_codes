package com.pu.jdk;

/**
 * @DESC  类加载初始化的过程
 *      父类静态代码块
 *      子类静态代码块
 *      父类非静态代码块
 *      父类构造方法
 *      子类非静态代码块
 *      子类构造方法
 *  子类和父类：
 *      普通方法，运用的是动态单分配 （根据new的类型确定对象，从而确定调用的方法）运行时确定
 *      静态方法，运用的是静态多分配 (根据静态类型确定对象，而不是根据new 的类型）编译时确定
 *      编译看左边，运行看右边
 * @CREATE BY @Author pbj on @Date 2020/5/12 10:55
 */
public class InitialOrderOfClasses {
    public static void main(String[] args) {
        InitialOrderOfClassesFather son = new InitialOrderOfClassesSon();
        son.say();
        son.action();

    }
}

class InitialOrderOfClassesFather {
    public InitialOrderOfClassesFather() {
        System.out.println("class Father's constructor ");
    }
    {
        System.out.println("class Father's tectonic block {}");
    }
    static {
        System.out.println("Father static {}");
    }
    public void say(){
        System.out.println("Father say()");
    }
    public static void action(){
        System.out.println("Father bit!");
    }
}
class InitialOrderOfClassesSon extends InitialOrderOfClassesFather{
    public InitialOrderOfClassesSon() {
        System.out.println("class Son's constructor ");
    }
    {
        System.out.println("class Son's tectonic block {}");
    }
    static {
        System.out.println("Son static {}");
    }
    public void say(){
        System.out.println("Son say()");
    }
    public static void action(){
        System.out.println("Son cry!");
    }
}
