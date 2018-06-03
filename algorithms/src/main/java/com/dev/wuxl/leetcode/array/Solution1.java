package com.dev.wuxl.leetcode.array;

import static com.dev.wuxl.leetcode.array.ArrayUtils.printArray;
import static com.dev.wuxl.leetcode.array.ArrayUtils.swap;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/2
 *
 *
 *
 */
public class Solution1 {

  public static void main(String[] args) {
//    test1();
    test2();
  }


  public static void test1(){
    Solution1 solution = new Solution1();
    for(int i=0; i<10; i++){
      System.out.println(i + "+++++++++++++++++++++++");
      for(int k=0; k<i+2; k++){
        int [] array = new int[i];
        for(int j=0; j<i; j++){
          array[j] = j+1;
        }
        System.out.println("  " + k + "-----------------------");
        printArray("    ", array);
        //        solution.rotate(array, k);
        solution.rotate2(array, k);
        //        solution.rotate3(array, k);
        printArray("    ", array);

      }
    }
  }

  public static void test2(){
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    printArray("", array);
    new Solution1().rotate3(array, 3);
    printArray("", array);


  }

  /**
   *
   */
  public void rotate(int[] nums, int k) {
    if(checkParams(nums, k)<=0){
      return;
    }
    int n = nums.length;
    k = k%n;
    while(k>0){
      int temp = nums[n-1];
      int i = n-1;
      while(i>0){
        swap(nums, i, i-1);
        i--;
      }
      nums[0] = temp;
      k--;
    }
  }

  public void rotate2(int[] nums, int k){
    if(checkParams(nums, k)<=0){
      return;
    }
    int n = nums.length;
    k = k%n;
    reverse(nums, 0, n-k-1);
    reverse(nums, n-k, n-1);
    reverse(nums, 0, n-1);
  }

  private void reverse(int[] nums, int start, int end){
    while (start<end){
      swap(nums, start, end);
      start++;
      end--;
    }
  }

  public void rotate3(int[] nums, int k){
    if(checkParams(nums, k)<=0){
      return;
    }
    int n = nums.length;
    k = k%n;
    int index = 0;
    int temp = nums[index];
    for(int i=0; i<n; i++) {
      int nextIndex = (index + k) % n;
      int nextTmp = nums[nextIndex];
      nums[nextIndex] = temp;
      index = nextIndex;
      temp = nextTmp;
    }
  }

  private int checkParams(int[] nums, int k){
    if(nums==null || k<0){
      return -1;
    }
    int n = nums.length;
    if(n<2){
      return 0;
    }
    k = k%n;
    if(k==0){
      return 0;
    }
    return 1;
  }

}
