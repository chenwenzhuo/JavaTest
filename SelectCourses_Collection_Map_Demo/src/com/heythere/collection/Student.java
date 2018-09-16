package com.heythere.collection;

import java.util.HashSet;
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
