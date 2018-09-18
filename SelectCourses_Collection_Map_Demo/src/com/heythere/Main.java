package com.heythere;

import com.heythere.collection.CoursesToSelect;
import com.heythere.collection.Student;
import com.heythere.map.AllStudents;

public class Main {

    public static void main(String[] args) {
        /*CoursesToSelect courseToSelect = new CoursesToSelect();
        courseToSelect.addCourse();
        courseToSelect.containsCourse();
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

        AllStudents allStudents = new AllStudents();
        allStudents.addStudents();
        allStudents.seeAllStudents();
//        allStudents.removeStudent();
        /*allStudents.modifyStudent();
        allStudents.seeAllStuByEntry();*/

        String key = "1002";
        String name = "Tom";
        System.out.println("key exist?  " + allStudents.checkExistByKey(key));
        System.out.println("name exist?  " + allStudents.checkExistByName(name));
    }
}
