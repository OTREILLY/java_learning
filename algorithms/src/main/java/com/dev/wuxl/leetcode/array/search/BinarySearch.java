package com.dev.wuxl.leetcode.array.search;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/7
 */
public class BinarySearch {

  public static void main(String[] args) {
    int[] array = {1,5,20,45,76,199};
    System.out.println(search(array, 45));



  }

  public static int search(int[] array, int key) {

    if (array == null || array.length == 0) {
      return -1;
    }
    int s = 0, e = array.length-1;
    while (s <= e) {
      int mid = (s + e) / 2;
      if (array[mid] == key) {
        return mid;
      } else if (array[mid] < key) {
        s = mid + 1;
      } else {
        e = mid - 1;
      }
    }
    return -1;
  }


}
