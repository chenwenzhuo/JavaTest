package com.heythere;

import com.heythere.collection.CourseToSelect;
import com.heythere.collection.Student;
import com.heythere.map.AllStudents;

public class Main {

    public static void main(String[] args) {
       /* CourseToSelect courseToSelect = new CourseToSelect();
        courseToSelect.addCourse();
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
        courseToSelect.removeCoursesInList();*/

        /*Student student = new Student("201822080812", "HeyThere");
        student.selectCourses(courseToSelect.getCourses());
        student.seeAllSelectedCourses();*/

        AllStudents allStudents = new AllStudents();
        allStudents.addStudents();
        allStudents.seeAllStudents();
    }
}
