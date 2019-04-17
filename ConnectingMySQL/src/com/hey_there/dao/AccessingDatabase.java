package com.hey_there.dao;

import com.hey_there.model.StudentInfo;

import java.sql.*;
import java.util.Scanner;

public class AccessingDatabase {
    private static final String DBUrl = "jdbc:mysql://localhost:3306/student_info?serverTimezone=UTC&useSSL=false";
    private static final String user = "root";
    private static final String password = "960812";

    //获得数据库连接
    private Connection getDBConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//加载数据库驱动
            connection = DriverManager.getConnection(DBUrl, user, password);//建立数据库连接
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;//返回连接对象
    }

    //断开与数据库的连接
    private void disconnectDB(ResultSet results, Statement statement, Connection connection) {
        try {
            if (null != results) {
                results.close();
            }
            if (null != statement) {
                statement.close();
            }
            if (null != connection) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //添加一条学生信息记录
    public void addStuInfo(StudentInfo studentInfo) {
        Connection DBCon = getDBConnection();
        Statement statement = null;
        ResultSet results = null;

        try {
            statement = DBCon.createStatement();

            //构建SQL语句字符串
            StringBuilder SQLCommand = new StringBuilder();
            SQLCommand.append("insert into info values(")
                    .append(getLargestNum() + 1).append(",")//获取表中最大的num值，加一作为下一行的num值
                    .append(studentInfo.getId()).append(",")
                    .append("\'").append(studentInfo.getName()).append("\'").append(",")
                    .append(studentInfo.getGender()).append(",")
                    .append(studentInfo.getAge()).append(",")
                    .append("\'").append(studentInfo.getBirthday()).append("\'").append(",")
                    .append("\'").append(studentInfo.getEmail()).append("\'").append(",")
                    .append("\'").append(studentInfo.getPhone()).append("\'").append(")");
            statement.executeUpdate(SQLCommand.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnectDB(results, statement, DBCon);
    }

    //删除一条学生信息
    public void deleteStuInfo(int stuNum) {
        Connection DBCon = getDBConnection();
        Statement statement = null;
        ResultSet results = null;

        try {
            statement = DBCon.createStatement();
            statement.executeUpdate("delete from info where num=" + stuNum);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnectDB(results, statement, DBCon);
    }

    //更新学生信息
    public void updateStuInfo(int stuNum) {
        //获取要修改的列名
        System.out.println("输入要修改的列名称（id，name，gender，age，birthday，email，phone）：");
        Scanner input = new Scanner(System.in);
        String columnName = input.nextLine();

        //获取待修改列的新值并构建SQL语句字符串
        StringBuilder SQLCommand = new StringBuilder();
        SQLCommand.append("update info set ").append(columnName).append("=");

        int newIntValue;
        String newStrValue = null;
        switch (columnName) {
            case "id":
            case "gender":
            case "age":
                System.out.println("输入待修改列的新值：");
                newIntValue = input.nextInt();
                SQLCommand.append(newIntValue).append(" where num=").append(stuNum);
                break;
            case "name":
            case "birthday":
            case "email":
            case "phone":
                System.out.println("输入待修改列的新值：");
                newStrValue = input.nextLine();
                SQLCommand.append("\'").append(newStrValue).append("\'")
                        .append(" where num=").append(stuNum);
                break;
            default:
                System.out.println("输入的列名有误！退出修改");
                return;
        }

        Connection DBCon = getDBConnection();
        Statement statement = null;
        ResultSet results = null;

        try {
            statement = DBCon.createStatement();
            statement.executeUpdate(SQLCommand.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnectDB(results, statement, DBCon);
    }

    //查询学生简略信息
    public void selectBriefStuInfo() {
        Connection DBCon = getDBConnection();
        Statement statement = null;
        ResultSet results = null;

        try {
            statement = DBCon.createStatement();
            results = statement.executeQuery("select num,id,name from info");

            System.out.println("编号" + "  " + "学号" + "     " + "姓名");
            while (results.next()) {
                System.out.println(results.getString("num") + "     " +
                        results.getString("id") + "     " +
                        results.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnectDB(results, statement, DBCon);
    }

    //查询指定学生详细信息
    public void selectDetailedStuInfo(int stuNum) {
        Connection DBCon = getDBConnection();
        Statement statement = null;
        ResultSet results = null;

        try {
            statement = DBCon.createStatement();
            results = statement.executeQuery("select * from info where num=" + stuNum);

            //获取学生性别
            String stuGender = null;
            if (results.next()) {
                int stuGenderCode = results.getInt("gender");
                if (0 == stuGenderCode) {
                    stuGender = "女";
                } else {
                    stuGender = "男";
                }
            }
            System.out.println("编号" + "  " + "学号" + "    " + "姓名" + "   "
                    + "性别" + "   " + "年龄" + "   " + "生日" + "   " + "邮箱" + "   " + "电话");

            //遍历结果集
            ResultSetMetaData rsmd = results.getMetaData();
            int columnIndex = 1;
            int columnCount = rsmd.getColumnCount();
            while (columnIndex <= columnCount) {
                if (4 == columnIndex) {
                    System.out.print(stuGender + "    ");
                    columnIndex++;
                    continue;
                }

                System.out.print(results.getString(columnIndex) + "    ");
                columnIndex++;
            }
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnectDB(results, statement, DBCon);
    }

    //获取表中最大的num值
    public int getLargestNum() {
        Connection DBCon = getDBConnection();
        Statement statement = null;
        ResultSet results = null;

        int largestNum = 0;
        try {
            statement = DBCon.createStatement();
            results = statement.executeQuery("select * from info order by num");

            results.last();
            if (results.isLast()) {
                largestNum = results.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return largestNum;
    }
}
