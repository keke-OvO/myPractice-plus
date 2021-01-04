package com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PwdLevel {

    public static void main(String[] args) {
        System.out.println(getSecurityLevel("1@wK22323"));
    }

    public static String getSecurityLevel(String password) {

        int sum = 0;

        //A:长度
        if (password.length() <= 4) {
            sum += 5;
        }
        if (password.length() >= 5 || password.length() <= 7) {
            sum += 10;
        }
        if (password.length() >= 8) {
            sum += 25;
        }


        String child1 = "[a-z]";
        String child11 = "[A-Z]";

        //B:字母
        Pattern pattern = Pattern.compile(child1);
        Matcher m = pattern.matcher(password);
        Pattern pattern1 = Pattern.compile(child11);
        Matcher m1 = pattern1.matcher(password);
        if (m.matches() || m1.matches()) {
            sum += 10;
        }
        if (m.find() && m1.find()) {
            sum += 20;
        }

        //C:数字
        int count = 0;
        String child2 = "[0-9]";
        Pattern pattern2 = Pattern.compile(child2);
        Matcher m2 = pattern2.matcher(password);
        while (m2.find()) {
            count++;
        }
        if (count == 1) sum += 10;
        if (count > 1) sum += 20;

        //D:符号
        int count1 = 0;
        String child3 = "[!@#$%^&*()_+=/.?><]";
        Pattern pattern3 = Pattern.compile(child3);
        Matcher m3 = pattern3.matcher(password);
        while (m3.find()) {
            count1++;
        }
        if (count1 == 1) sum += 10;
        if (count1 > 1) sum += 25;

        //E:奖励
        if (m.matches() || m1.matches() && m2.find()) {
            sum += 2;
        }
        if (m.matches() || m1.matches() && m2.find() && m3.find()) {
            sum += 3;
        }
        if (m.matches() && m1.matches() && m2.find() && m3.find()) {
            sum += 5;
        }

        String level = "";
        if (sum >= 0 && sum < 25) {
            level = "VERY_WEAK";
        }
        if (sum >= 25 && sum < 50) {
            level = "WEAK";
        }
        if (sum >= 50 && sum < 60) {
            level = "AVERAGE";
        }
        if (sum >= 60 && sum < 70) {
            level = "STRONG";
        }
        if (sum >= 70 && sum < 80) {
            level = "VERY_STRONG";
        }
        if (sum >= 80 && sum < 90) {
            level = "SECURE";
        }
        if (sum >= 90) {
            level = "VERY_SECURE";
        }
        System.out.println(sum);
        return level;
    }

}
