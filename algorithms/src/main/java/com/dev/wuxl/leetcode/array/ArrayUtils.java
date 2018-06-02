package com.dev.wuxl.leetcode.array;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/2
 */
public class ArrayUtils {

  public static void swap(int[] nums, int i, int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void printArray(String message, int[] nums){
    System.out.print(message);
    for(int i=0; i<nums.length; i++){
      System.out.print(nums[i] + " ");
    }
    System.out.println("");
  }

}
