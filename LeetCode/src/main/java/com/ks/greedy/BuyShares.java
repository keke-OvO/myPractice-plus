package com.ks.greedy;

/**
 * @author 柯神_
 * @date 2021-01-04 22:30:09
 * @Description 贪心算法：买股票的最佳时期
 */
public class BuyShares {

  public static void main(String[] args) {
    int[] x = {7, 1, 5, 3, 6, 4};
    System.out.println(buyShares(x));
    int[] y = {1, 2, 3, 4, 5};
    System.out.println(buyShares(y));
    int[] z = {7, 6, 4, 3, 1};
    System.out.println(buyShares(z));
  }


  public static int buyShares(int[] price) {
    int n = price.length;

    if (n < 2) return 0;

    int res = 0;
    for (int i = 1; i < n; i++) {
      res += Math.max(price[i] - price[i - 1], 0);
    }
    return res;
  }
}
