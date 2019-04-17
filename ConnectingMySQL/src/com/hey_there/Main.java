package com.hey_there;

import com.hey_there.dao.AccessingDatabase;
import com.hey_there.model.StudentInfo;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        AccessingDatabase accDB = new AccessingDatabase();
        /*accDB.selectBriefStuInfo();
        accDB.selectDetailedStuInfo(2);

        StudentInfo stu = new StudentInfo(1234, 20, "刘二丫",
                0, "19990621", "lierya@126.com", "15512349876");
        accDB.addStuInfo(stu);
        accDB.deleteStuInfo(4);
        accDB.updateStuInfo(4);*/
    }
}
