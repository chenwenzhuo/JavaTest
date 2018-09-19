package com.heythere;

import com.heythere.collection.Course;
import com.heythere.collection.CoursesToSelect;
import com.heythere.collection.Student;
import com.heythere.map.AllStudents;

import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        CoursesToSelect courseToSelect = new CoursesToSelect();
        courseToSelect.addCourse();
        //对添加的课程根据课程编号进行排序
        System.out.println("--------------按课程编号排序--------------");
        Collections.sort(courseToSelect.getCourses());
        courseToSelect.seeAllCourses();

        //对添加的课程根据课程名进行排序
        System.out.println("--------------按课程名称排序--------------");
        Collections.sort(courseToSelect.getCourses(), new Comparator<Course>() {
            @Override
            public int compare(Course c1, Course c2) {
                return c1.getCourseName().compareTo(c2.getCourseName());
            }
        });
        courseToSelect.seeAllCourses();
        /*courseToSelect.containsCourse();
        courseToSelect.seeAllCourses();
        System.out.println();
        courseToSelect.modifyCourse();
        System.out.println();
        courseToSelect.seeAllCoursesByIterator();
        System.out.println();
        courseToSelect.modifyCourse();
        System.out.println();
        courseToSelect.removeCourse();
        System.out.println();
        courseToSelect.removeCourseByIndex();
        System.out.println();
        courseToSelect.removeCoursesInList();

        Student student = new Student("201822080812", "HeyThere");
        student.selectCourses(courseToSelect.getCourses());
        student.seeAllSelectedCourses();
        student.isCourseSelected();*/

       /* AllStudents allStudents = new AllStudents();
        allStudents.addStudents();
        allStudents.seeAllStudents();
        allStudents.removeStudent();
        allStudents.modifyStudent();
        allStudents.seeAllStuByEntry();

        String key = "1002";
        String name = "Tom";
        System.out.println("key exist?  " + allStudents.checkExistByKey(key));
        System.out.println("name exist?  " + allStudents.checkExistByName(name));*/
    }
}
