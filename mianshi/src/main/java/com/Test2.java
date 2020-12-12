package com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (true) {
            String myTime = s.nextLine();
            getTime(myTime);
        }
    }

    public static void getTime(String diyTime) {
        SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = null;
        try {
            time = sFormat.parse(diyTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);


        //上午
        if (calendar.get(Calendar.HOUR_OF_DAY) >= 0 && calendar.get(Calendar.HOUR_OF_DAY) < 8) {
            calendar.set(Calendar.HOUR_OF_DAY, 11);
            calendar.set(Calendar.MINUTE, 00);
            calendar.set(Calendar.SECOND, 00);

        }else if (calendar.get(Calendar.HOUR_OF_DAY) >= 8 && calendar.get(Calendar.HOUR_OF_DAY) < 9) {
            calendar.add(Calendar.HOUR_OF_DAY, 3);

        }else if (calendar.get(Calendar.HOUR_OF_DAY) == 9) {
            if (calendar.get(Calendar.SECOND) > 0) {
                calendar.add(Calendar.HOUR_OF_DAY, 5);
                System.out.println(sFormat.format(calendar.getTime()));
                return;

            } else calendar.add(Calendar.HOUR_OF_DAY,3);

        }else if (calendar.get(Calendar.HOUR_OF_DAY) > 9 && calendar.get(Calendar.HOUR_OF_DAY) <= 12) {
            if (calendar.get(Calendar.SECOND) > 0) {
                calendar.add(Calendar.HOUR_OF_DAY, 5);

            }
            else calendar.add(Calendar.HOUR_OF_DAY,3);

        }else if (calendar.get(Calendar.HOUR_OF_DAY) >12 && calendar.get(Calendar.HOUR_OF_DAY) < 14) {
            calendar.set(Calendar.HOUR_OF_DAY, 17);
            calendar.set(Calendar.MINUTE, 00);
            calendar.set(Calendar.SECOND, 00);
        }


        //下午,18:00:00下班
        if (calendar.get(Calendar.HOUR_OF_DAY) >= 14 && calendar.get(Calendar.HOUR_OF_DAY) < 15) {
            calendar.add(Calendar.HOUR_OF_DAY,3);

        }else if (calendar.get(Calendar.HOUR_OF_DAY) >= 15 && calendar.get(Calendar.HOUR_OF_DAY) < 18) {
            calendar.set(Calendar.HOUR_OF_DAY, 18);
            calendar.set(Calendar.MINUTE, 00);
            calendar.set(Calendar.SECOND, 00);

        }else if (calendar.get(Calendar.HOUR_OF_DAY) >= 18 && calendar.get(Calendar.HOUR_OF_DAY) < 24) {
            System.out.println("今天已经是18：00：00后，没有工作了");
            return;
        }
        System.out.println(sFormat.format(calendar.getTime()));
        return;
    }

}
