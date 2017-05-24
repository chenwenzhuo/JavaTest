package com.company;
import java.text.DateFormatSymbols;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        //构造对象d作为当前日期
        GregorianCalendar d=new GregorianCalendar();

        int today=d.get(Calendar.DAY_OF_MONTH);
        int month=d.get(Calendar.MONTH);
        //把d设置为当前月的第一天
        d.set(Calendar.DAY_OF_MONTH,1);

        int weekday=d.get(Calendar.DAY_OF_WEEK);
        //获取一周的第一天
        int firstDayOfWeek=d.getFirstDayOfWeek();
        //计算第一行的缩进
        int indent=0;
        while(weekday!=firstDayOfWeek){
            indent++;
            d.add(Calendar.DAY_OF_MONTH,-1);
            weekday=d.get(Calendar.DAY_OF_WEEK);
        }

        //第一行输出一周每一天的缩写
        String[] weekdayNames=new DateFormatSymbols().getShortWeekdays();
        do{
            System.out.printf("%4s",weekdayNames[weekday]);
            d.add(Calendar.DAY_OF_MONTH,1);
            weekday=d.get(Calendar.DAY_OF_WEEK);
        }while(weekday!=firstDayOfWeek);
        System.out.println();

        for(int i=0;i<indent;i++)
            System.out.print("    ");
        d.set(Calendar.DAY_OF_MONTH,1);
        do{
            int day=d.get(Calendar.DAY_OF_MONTH);
            System.out.printf("%3d",day);
            if(day==today)
                System.out.print("*");
            else
                System.out.print(" ");
            d.add(Calendar.DAY_OF_MONTH,1);
            weekday=d.get(Calendar.DAY_OF_WEEK);

            if(weekday==firstDayOfWeek)
                System.out.println();
        }while(d.get(Calendar.MONTH)==month);

        if(weekday!=firstDayOfWeek)
            System.out.println();
    }
}