package com.bjpowernode.p2p.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class test {
    public static void main(String[] args) {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MMMM-dd-EEEE");
//        Date date = new Date();
//        System.out.println(simpleDateFormat.format(date));
//        Calendar instance = Calendar.getInstance();
//        int year = instance.get(Calendar.YEAR);
//        System.out.println(year);
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DATE);


//һ�ܵ�һ���Ƿ�Ϊ������
        boolean isFirstSunday = (cal.getFirstDayOfWeek() == Calendar.SUNDAY);
//��ȡ�ܼ�
        int weekDay = cal.get(Calendar.DAY_OF_WEEK);
//��һ�ܵ�һ��Ϊ�����죬��-1
        if(isFirstSunday){
            weekDay = weekDay - 1;
            if(weekDay == 0){
                weekDay = 7;
            }
        }
        System.out.println("������"+year+"��"+month+"��"+day+"��"+"����"+weekDay);
//        switch (weekDay){
//            case (1):
//                System.out.println("������"+year+"��"+month+"��"+day+"��"+"����"+weekDay); break;
//            case (2):
//                System.out.println("������"+year+"��"+month+"��"+day+"��"+"����"+weekDay); break;
//            case (3) :
//                System.out.println("������"+year+"��"+month+"��"+day+"��"+"����"+weekDay); break;
//            case (4) :
//                System.out.println("������"+year+"��"+month+"��"+day+"��"+"����"+weekDay); break;
//            case (5) :
//                System.out.println("������"+year+"��"+month+"��"+day+"��"+"����"+weekDay); break;
//            case (6) :
//                System.out.println("������"+year+"��"+month+"��"+day+"��"+"����"+weekDay); break;
//
//        }
//��ӡ�ܼ�
//        System.out.println(weekDay);
    }
}
