package com.pu.jdk;

/**
 * @DESC Comparison of abstract classes and interfaces
 *
 *  variable:
 *      abstract: every attributes
 *      interface: public static final
 *  method:
 *      abstract: private ..non abstract
 *      interface: public abstract
 * @CREATE BY @Author pbj on @Date 2020/5/11 10:25
 */
public class AbstractAndImpl extends myAbs implements MyImpl{
    public static void main(String[] args) {
        myAbs abs = new myAbs() {
            @Override
            void print() {

            }
        };  //抽象类不能被直接实现 即new
        MyImpl mi = new MyImpl() {
            @Override
            public void incre() {
                System.out.println();
            }
        }; //也不能直接new
    }


    @Override
    void print() {

    }
}
abstract class myAbs{
    int id;
    String name;
    public myAbs(){
        super();
    }
    public myAbs(int id, String name) {
        this.id = id;
        this.name = name;
    }
    static void method(){ //有静态方法，可以被初始化
        System.out.println("static method");
    }
    abstract void print();

    void incre(int num){
        this.id += num;
    }
}
interface MyImpl {
    int id = 10;
    String name = "pubj";
    //不能有静态方法，不能被初始化

    default void incre(){
        System.out.println(id + "  " + name);
    }
}
