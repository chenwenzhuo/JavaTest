package com.heythere.map;

import com.heythere.collection.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AllStudents {
    private Map<String, Student> studentsMap;
    //使用Scanner从控制台读入数据
    private Scanner consoleInput;

    public AllStudents() {
        this.studentsMap = new HashMap<>();
        this.consoleInput = new Scanner(System.in);
    }

    public void addStudents() {
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
            } else {
                System.out.println("此学生已被添加！");
            }
        }
    }

    public void seeAllStudents() {
        //获得已经被添加的学生的id集合
        Set<String> stuIDSet = studentsMap.keySet();

        System.out.println("以下学生已被添加：");
        for (String id : stuIDSet) {
            Student stu = studentsMap.get(id);
            System.out.println(stu.getStuId() + "：" + stu.getStuName());
        }
    }

    public void seeAllStuByEntry() {
        //获得Entry集合
        Set<Map.Entry<String, Student>> entries = studentsMap.entrySet();

        for (Map.Entry<String, Student> e : entries) {
            System.out.println("键为：" + e.getKey());
            System.out.println("对应的值为：" + e.getValue().getStuName());
        }
    }

    public void removeStudent() {
        String stuIDToRemove;
        Student stuToRemove;
        System.out.print("输入要删除的学生ID：");
        while (true) {
            stuIDToRemove = consoleInput.next();
            stuToRemove = studentsMap.get(stuIDToRemove);

            //处理错误输入
            if (null == stuToRemove) {
                System.out.print("没有对应此ID的学生！\n重新输入要删除的学生ID：");
                continue;
            }
            studentsMap.remove(stuIDToRemove);
            System.out.println("ID为" + stuIDToRemove + "的学生已删除！");
            break;
        }
    }

    public void modifyStudent() {
        String stuIDToModify;
        Student stuToModify;
        System.out.print("输入要修改的学生ID：");
        while (true) {
            stuIDToModify = consoleInput.next();
            stuToModify = studentsMap.get(stuIDToModify);

            //处理错误输入
            if (null == stuToModify) {
                System.out.print("没有对应此ID的学生！\n重新输入要删除的学生ID：");
                continue;
            }
            System.out.println("此学生的姓名为：" + stuToModify.getStuName());

            System.out.print("输入新的学生姓名：");
            String newStuName = consoleInput.next();
            studentsMap.put(stuIDToModify, new Student(stuIDToModify, newStuName));
            break;
        }
    }

    public boolean checkExistByKey(String key) {
        return studentsMap.containsKey(key);
    }

    public boolean checkExistByName(String name) {
        Student stuToCheck = new Student(null, name);
        return studentsMap.containsValue(stuToCheck);
    }
}
