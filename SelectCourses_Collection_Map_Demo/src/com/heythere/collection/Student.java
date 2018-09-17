package com.heythere.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Student {
    private String stuId;
    private String stuName;
    private Set<Course> coursesOfStu;

    public Student() {
        this.stuId = "";
        this.stuName = "";
    }

    public Student(String id, String name) {
        this.stuId = id;
        this.stuName = name;
        this.coursesOfStu = new HashSet<>();
    }

    public void selectCourses(List<Course> courses) {
        int totalCoursesAmount = courses.size();//可选课程数目
        System.out.println("现有" + totalCoursesAmount + "门课程可选");
        System.out.print("你想要选择几门课程：");

        int wantedCoursesAmount;//想要选多少门课
        Scanner consoleInput = new Scanner(System.in);
        //处理非法输入
        while (true) {
            wantedCoursesAmount = consoleInput.nextInt();
            if (wantedCoursesAmount >= 1 && wantedCoursesAmount <= totalCoursesAmount) {
                break;
            } else {
                System.out.println("输入有误！请重新输入：");
            }
        }

        String wantedCourseId;//要选的课的编号
        for (int i=0; i < wantedCoursesAmount; i++) {
            System.out.print("请输入课程编号：");
            wantedCourseId = consoleInput.next();

            for (Course c : courses) {
                if (c.getCourseId().equals(wantedCourseId)) {
                    coursesOfStu.add(c);
                }
            }
        }
    }

    public void seeAllSelectedCourses() {
        System.out.println(this.stuId + "：" + this.stuName + "已选择如下课程：");
        for (Course c : coursesOfStu) {
            System.out.println(c.getCourseId() + "：" + c.getCourseName());
        }
    }

    public String getStuId() {
        return stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public Set getCoursesOfStu() {
        return coursesOfStu;
    }
}
