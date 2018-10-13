package com.heythere.ObjectSerialize;

import java.io.*;

public class ObjectSerializeDemo_1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "objSerial.dat";

        //对象序列化
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(fileName));
        Student stu_1 = new Student("1001", "Jack", 20);
        oos.writeObject(stu_1);
        oos.flush();
        oos.close();

        //对象反序列化
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(fileName));
        Student aStu = (Student) ois.readObject();
        System.out.println(aStu);
        ois.close();
    }
}
