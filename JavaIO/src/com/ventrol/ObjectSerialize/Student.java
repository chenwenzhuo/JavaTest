package com.ventrol.ObjectSerialize;

import java.io.Serializable;

/**
 * Created by --C-W-Z-- on 2017/3/4 0004.
 */
public class Student implements Serializable {
    private String stuNo;
    private String stuName;
    //该元素不进行jvm默认的序列化
    private transient int stuAge;

    public Student() {

    }

    public Student(String stuNo, String stuName, int stuAge) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuAge = stuAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNo='" + stuNo + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuAge=" + stuAge +
                '}';
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuNo() {

        return stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public int getStuAge() {
        return stuAge;
    }
}
