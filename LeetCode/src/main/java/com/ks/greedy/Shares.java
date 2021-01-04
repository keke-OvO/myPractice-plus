package com.ks.greedy;

/**
 * @author 柯神_
 * @date 2021-01-04 18:28:23
 * @Description 贪心算法，经典例子
 */

public class Shares {

    public static void main(String[] args) {
        greedyGiveMoney(251);
    }

    /**
     * 例子1：支付问题
     */
    public static void greedyGiveMoney(int money) {
        System.out.println("支付: " + money + "元");
        int[] moneyLevel = {1, 5, 10, 20, 50, 100};
        int count = 0;
        for (int i = moneyLevel.length - 1; i >= 0; i--) {
            int num = money / moneyLevel[i];
            int mod = money % moneyLevel[i];
            money = mod;
            count += num;
            if (num > 0) {
                System.out.println("需要" + num + "张" + moneyLevel[i] + "块的");
            }
        }
        System.out.println("需要纸币" + count + "张");
    }
}
