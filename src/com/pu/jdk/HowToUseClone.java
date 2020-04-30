package com.pu.jdk;

/**
 * clone 浅拷贝，对象必须实现cloneable接口。拷贝后对象的地址不一样，但是属性的拷贝是对象的引用
 *      alibaba规范
 *      说明： 对象的 clone 方法默认是浅拷贝，若想实现深拷贝需要重写 clone 方法实现属性对象的拷贝。
 * 如果需要深拷贝，必须完全实现属性也重写clone()方法 ，至于彻底深拷贝，几乎是不可能实现的
 */
public class HowToUseClone  {
    public static void main(String[] args) throws CloneNotSupportedException {
        MyCloneObject obj = new MyCloneObject("pu", 23, new Object());
        MyCloneObject newObj = (MyCloneObject)obj.clone();
        System.out.println(obj);
        System.out.println(newObj);
        System.out.println(obj.equals(newObj));
        System.out.println(obj == newObj);
        System.out.println(obj.getSmallObj().hashCode()); //21685669
        System.out.println(newObj.getSmallObj().hashCode()); //21685669
    }
}
class MyCloneObject implements Cloneable {
    private String name;
    private Integer age;
    private Object smallObj;


    public MyCloneObject(String name, Integer age, Object smallObj) {
        this.name = name;
        this.age = age;
        this.smallObj = smallObj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Object getSmallObj() {
        return smallObj;
    }

    public void setSmallObj(Object smallObj) {
        this.smallObj = smallObj;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
