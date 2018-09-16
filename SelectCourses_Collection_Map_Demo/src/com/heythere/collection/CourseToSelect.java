package com.heythere.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CourseToSelect {
    //用于存放备选课程的List
    private List<Course> courses;

    public CourseToSelect() {
        this.courses = new ArrayList<>();
    }

    public void addCourse() {
        //向课程列表中添加一门课程
        Course course1 = new Course("1", "高等数学");
        courses.add(course1);
        Course cTemp1 = courses.get(0);
        System.out.println("添加了一门课程：" + cTemp1.getCourseId() + "，" + cTemp1.getCourseName() + "\n");

        //向课程列表指定位置添加课程
        Course course2 = new Course("2", "大学英语");
        courses.add(0, course2);
        Course cTemp2 = courses.get(0);
        System.out.println("添加了一门课程：" + cTemp2.getCourseId() + "，" + cTemp2.getCourseName() + "\n");

        //向指定位置（超出列表长度）添加课程
        Course course3 = new Course("3", "数据结构");
        //将会引发异常，对异常进行捕捉并处理
        try {
            courses.add(5, course3);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("所指定位置超出列表长度！已将其添加到列表尾部。");
            int len = courses.size();
            courses.add(len, course3);
            System.out.println("添加了一门课程：" + course3.getCourseId() + "，" + course3.getCourseName() + "\n");
        }

        //同时向列表中添加两门课程
        Course[] twoCourses = {new Course("4", "计算机网络"),
                new Course("5", "数据库")};
        courses.addAll(Arrays.asList(twoCourses));
        Course cTemp3 = courses.get(3);
        Course cTemp4 = courses.get(4);
        System.out.println("添加了两门课程：" + cTemp3.getCourseId() + "，" + cTemp3.getCourseName() + "；"
                + cTemp4.getCourseId() + "，" + cTemp4.getCourseName() + "\n");

        //向列表中指定位置同时添加三门课程
        Course[] threeCourses = {new Course("6", "离散数学"),
                new Course("7", "操作系统"),
                new Course("8", "编译原理")};
        courses.addAll(3, Arrays.asList(threeCourses));
        Course cTemp5 = courses.get(3);
        Course cTemp6 = courses.get(4);
        Course cTemp7 = courses.get(5);
        System.out.println("添加了三门课程：" + cTemp5.getCourseId() + "，" + cTemp5.getCourseName() + "；"
                + cTemp6.getCourseId() + "，" + cTemp6.getCourseName() + "；"
                + cTemp7.getCourseId() + "，" + cTemp7.getCourseName() + "\n");

        //List支持重复添加元素
        courses.add(course3);
    }

    public void seeAllCourses() {
        System.out.println("列表中有如下课程：");
        for (Course c : courses) {
            System.out.println(c.getCourseId() + "，" + c.getCourseName());
        }
    }

    public void seeAllCoursesByIterator() {
        //获得迭代器实例
        Iterator iterator = courses.iterator();

        System.out.println("列表中有如下课程（通过迭代器访问）：");
        while (iterator.hasNext()) {
            Course course = (Course) iterator.next();
            System.out.println(course.getCourseId() + "，" + course.getCourseName());
        }
    }

    //修改之前重复添加的课程
    public void modifyCourse() {
        Course modifiedCourse = new Course("9", "算法分析");
        courses.set(8, modifiedCourse);
        System.out.println("课程已修改！");
        seeAllCourses();
    }

    //删除一门课程（通过传入课程实例）
    public void removeCourse() {
        Course courseToRemove = courses.get(4);
        System.out.println("课程：" +
                courseToRemove.getCourseId() + "，" + courseToRemove.getCourseName() +
                "将被删除！");
        courses.remove(courseToRemove);
        System.out.println("已删除一门课程！");
        seeAllCourses();
    }

    //删除一门课程（删除特定位置）
    public void removeCourseByIndex() {
        System.out.println("2位置上的课程将被删除！");
        courses.remove(2);
        System.out.println("已删除一门课程！");
        seeAllCourses();
    }

    //删除包含在另一集合中的所有课程
    public void removeCoursesInList() {
        Course[] coursesToRemove = {courses.get(1), courses.get(2)};
        System.out.println("课程：" +
                coursesToRemove[0].getCourseId() + "，" + coursesToRemove[0].getCourseName() +
                "和" + coursesToRemove[1].getCourseId() + "，" + coursesToRemove[1].getCourseName() +
                "将被删除！");
        courses.removeAll(Arrays.asList(coursesToRemove));
        System.out.println("已删除" + coursesToRemove.length + "门课程！");
        seeAllCourses();
    }
}
