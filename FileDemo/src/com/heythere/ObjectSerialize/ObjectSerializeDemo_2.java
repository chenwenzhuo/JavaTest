package com.heythere.ObjectSerialize;

import java.io.*;

public class ObjectSerializeDemo_2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("objSerial_1.dat"));
        Foo_2 foo_2 = new Foo_2();
        oos.writeObject(foo_2);
        oos.flush();
        oos.close();

        //反序列化是否递归调用父类的构造函数?
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("objSerial_1.dat"));
        Foo_2 readFoo_2 = (Foo_2) ois.readObject();
        System.out.println(readFoo_2);
        ois.close();*/

        /*ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("objSerial_1.dat"));
        Bar2 bar2 = new Bar2();
        oos.writeObject(bar2);
        oos.flush();
        oos.close();*/

        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("objSerial_1.dat"));
        Bar2 readBar2 = (Bar2) ois.readObject();
        System.out.println(readBar2);
        ois.close();
    }
}

/**
 * 一个类实现了Serializable接口
 * 则其子类都可进行序列化
 */
class Foo implements Serializable {
    public Foo() {
        System.out.println("It's Foo");
    }
}

class Foo_1 extends Foo {
    public Foo_1() {
        System.out.println("It's Foo_1");
    }
}

class Foo_2 extends Foo_1 {
    public Foo_2() {
        System.out.println("It's Foo_2");
    }
}

/**
 * 对子类对象进行反序列化操作时，
 * 若其某父类未实现Serializable接口，则此父类的构造函数会被显式调用
 */
class Bar {
    public Bar() {
        System.out.println("Bar");
    }
}

class Bar1 extends Bar implements Serializable {
    public Bar1() {
        System.out.println("Bar1");
    }
}

class Bar2 extends Bar1 {
    public Bar2() {
        System.out.println("Bar2");
    }
}