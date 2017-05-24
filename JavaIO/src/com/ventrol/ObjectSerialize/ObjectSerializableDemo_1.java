package com.ventrol.ObjectSerialize;

import java.io.*;

/**
 * Created by --C-W-Z-- on 2017/3/4 0004.
 */
public class ObjectSerializableDemo_1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("obj_1.dat"));
        Foo_2 foo_2 = new Foo_2();
        Bar_2 bar_2 = new Bar_2();
        oos.writeObject(foo_2);
        oos.flush();
        oos.writeObject(bar_2);
        oos.flush();
        oos.close();*/

        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("obj_1.dat"));
        Foo_2 foo_2FromFile = (Foo_2) ois.readObject();
        Bar_2 bar_2FromFile = (Bar_2) ois.readObject();
        System.out.println(foo_2FromFile);
        System.out.println(bar_2FromFile);
    }
}

class Foo implements Serializable {
    public Foo() {
        System.out.println("Foo...");
    }
}

class Foo_1 extends Foo {
    public Foo_1() {
        System.out.println("Foo_1...");
    }
}

class Foo_2 extends Foo_1 {
    public Foo_2() {
        System.out.println("Foo_2...");
    }
}

class Bar {
    public Bar() {
        System.out.println("Bar...");
    }
}

class Bar_1 extends Bar {
    public Bar_1() {
        System.out.println("Bar_1...");
    }
}

class Bar_2 extends Bar_1 implements Serializable {
    public Bar_2() {
        System.out.println("Bar_2...");
    }
}