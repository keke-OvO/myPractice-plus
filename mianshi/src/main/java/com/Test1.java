package com;

public class Test1 {
    public static void main(String[] args) {

        int[] a = {1, 5, 8, 11, 16, 17, 29, 34, 39};
        int[] time_line = {3, 7, 12, 17, 19, 31, 40};

        for (int r = 0; r < time_line.length; r++) {
            getAB(a,time_line,r);
        }
    }

    public static void getAB(int[] a, int[] b, int r){
        for (int i = 0; i < 100; i++) {
            for (int n = 0; n < a.length; n++) {

                if (b[r] + i == a[n]) {
                    System.out.println("[ line" + b[r] + ",time:" + a[n] + " ]");
                    return;
                }
                if (b[r] - i == a[n]){
                    System.out.println("[ line" + b[r] + ",time:" + a[n] + " ]");
                    return;
                }
            }

        }
    }
}

