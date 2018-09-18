package com.heythere.collection;

import java.util.Objects;

public class Course {
    private String courseId;
    private String courseName;

    public Course() {
        this.courseId = "";
        this.courseName = "";
    }

    public Course(String id, String name) {
        this.courseId = id;
        this.courseName = name;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * 重写equals方法，
     * 通过比较课程名称，
     * 判断参数课程是否与当前课程相同
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {//两者指向同一对象实例，相等
            return true;
        }
        if (null == obj) {//参数为null，不等
            return false;
        }
        if (!(obj instanceof Course)) {//参数不是Course实例，不等
            return false;
        }

        /*
        通过了上方测试，参数不等于null且是Course对象实例，
        则可继续比较参数中courseName是否等于当前实例的courseName
         */
        Course courseToJudge = (Course) obj;
        if (null == this.courseName) {
            return null == courseToJudge.getCourseName();
        } else {
            return this.courseName.equals(courseToJudge.getCourseName());
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName);
    }
}
