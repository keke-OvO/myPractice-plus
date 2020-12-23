package com.ks.binarysearch;

/**
 * @author 柯神_
 * @date 2020-12-23 17:00:02
 * @Description 二分查找，又名折半查找
 */

public class BinarySearch {
    private final static int error = -1;

    public static void main(String[] args) {
        /**
         * 1.测试while循环
         */
        int[] a = {1, 2, 4, 9};
        System.out.println("===while循环实现=============");
        System.out.println("key:1,在数组中的位置" + bSearch(a, 1));
        System.out.println("key:2,在数组中的位置" + bSearch(a, 2));
        System.out.println("key:4,在数组中的位置" + bSearch(a, 4));
        System.out.println("key:9,在数组中的位置" + bSearch(a, 9));

        /**
         * 2.测试递归
         */
        System.out.println("===递归实现=============");
        System.out.println("key:1,在数组中的位置" + recursionSearch(a, 1, 0, a.length - 1));
        System.out.println("key:2,在数组中的位置" + recursionSearch(a, 2, 0, a.length - 1));
        System.out.println("key:4,在数组中的位置" + recursionSearch(a, 4, 0, a.length - 1));
        System.out.println("key:9,在数组中的位置" + recursionSearch(a, 9, 0, a.length - 1));
    }


    /**
     * 1.非递归方式
     */
    public static int bSearch(int[] arr, int key) {
        int low = 0;
        int hgt = arr.length - 1;
        int mid = 0;

        //优化查询条件
        if (key < arr[0] || key > arr[hgt]) {
            return error;
        }

        while (low <= hgt) {
            mid = (low + hgt) / 2;
            if (key < arr[mid]) {
                hgt = mid - 1;  //向左查找
            }
            if (key > arr[mid]) {
                low = mid + 1;  //向右查找
            }
            if (key == arr[mid]) {
                return mid;     //找到返回
            }
        }
        return error;           //找不到返回
    }


    /**
     * 2.递归
     */
    public static int recursionSearch(int[] arr, int key, int low, int hgt) {

        int mid = (low + hgt) / 2;

        //优化查询条件
        if (key < arr[low] || key > arr[hgt] || low > hgt) {
            return error;
        }

        if (key < arr[mid]) {
            return recursionSearch(arr, key, low, mid - 1);    //向左查找
        }
        if (key > arr[mid]) {
            return recursionSearch(arr, key, mid + 1, hgt);    //向右查找
        }
        if (key == arr[mid]) {
            return mid;                    //找到返回
        }
        return error;                      //找不到返回
    }
}
