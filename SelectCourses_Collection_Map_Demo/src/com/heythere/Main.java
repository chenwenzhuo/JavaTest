package com.heythere;

import com.heythere.collection.CourseToSelect;

public class Main {

    public static void main(String[] args) {
        CourseToSelect courseToSelect = new CourseToSelect();
        courseToSelect.addCourse();
        courseToSelect.seeAllCourses();
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
    }
}
