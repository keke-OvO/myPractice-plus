package com.ks.ysfh;
/**
 * @author 柯神_
 * @date 2020-12-25 19:53:49
 * @Description 约瑟夫环
 */

import java.util.ArrayList;

public class YSFH {
  public static void main(String[] args) {
    sF(10, 10);
  }


  public static void sF(int total, int count) {
    ArrayList<Integer> list = new ArrayList();
    int rmIndex = 0;

    //1.添加到集合
    for (int i = 0; i < total; i++) {
      list.add(i);
    }

    while (list.size() > 3) {
      rmIndex = rmIndex + count - 1;

      if (rmIndex > list.size() - 1) {
        rmIndex = rmIndex % (list.size());   //当前索引超过了数组的最大索引时，对集合大小求余得到需要删除的新索引
      }

      System.out.println(list.get(rmIndex));
      int c = list.remove(rmIndex);
      System.out.println(list);

      //也可以通过if语句来得到最后一次删除的数据
      if (list.size() == 3) {
        System.out.println("最后一次删除的数据:" + c);
        return;
      }
    }
  }
}
