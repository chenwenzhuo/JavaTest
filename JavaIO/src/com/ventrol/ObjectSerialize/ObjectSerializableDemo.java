package com.ventrol.ObjectSerialize;

import java.io.*;

/**
 * Created by --C-W-Z-- on 2017/3/4 0004.
 */
public class ObjectSerializableDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student stu = new Student("1001", "ÕÅÈý", 20);

        File file = new File("obj.dat");
        serialize(file, stu);
        deserialize(file);
    }

    private static void deserialize(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(file));
        Student stuFromFile = (Student) ois.readObject();
        System.out.println(stuFromFile);
        ois.close();
    }

    private static void serialize(File file, Student stu) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(file));
        oos.writeObject(stu);
        oos.flush();
        oos.close();
    }
}
