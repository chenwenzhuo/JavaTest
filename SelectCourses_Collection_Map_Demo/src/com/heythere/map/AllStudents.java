package com.heythere.map;

import com.heythere.collection.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AllStudents {
    private Map<String, Student> studentsMap;

    public AllStudents() {
        studentsMap = new HashMap<>();
    }

    public void addStudents() {
        //使用Scanner从控制台读入数据
        Scanner consoleInput = new Scanner(System.in);

        System.out.print("共有几个学生要添加：");
        int stuAmount = consoleInput.nextInt();

        int i = 0;
        while (i < stuAmount) {
            System.out.print("输入学生ID：");
            String idInput = consoleInput.next();

            if (null == studentsMap.get(idInput)) {
                System.out.println("当前未添加此学生，输入姓名以添加：");
                String nameInput = consoleInput.next();
                studentsMap.put(idInput, new Student(idInput, nameInput));
                i++;
            }else {
                System.out.println("此学生已被添加！");
            }
        }
    }

    public void seeAllStudents(){
        //获得已经被添加的学生的id集合
        Set<String> stuIDSet = studentsMap.keySet();

        System.out.println("以下学生已被添加：");
        for (String id : stuIDSet) {
            Student stu = studentsMap.get(id);
            System.out.println(stu.getStuId() + "：" + stu.getStuName());
        }
    }
}
