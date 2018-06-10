package com.dev.wuxl.leetcode.array;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/9
 *  最大连续子序列和
 *
 */
public class Solution10 {

  public static void main(String[] args) {

  }

  private static int cal1(int[] array) throws Exception {
    if(array==null){
      throw new Exception("");
    }
    if(array.length==0){
      return 0;
    }
    int maxSum = 0;
    int len = array.length;
    for(int i=0; i<len; i++){
      for(int j = i; j<len; j++){
        int sum = 0;
        for(int k=i; k<=j; k++){
          sum += array[k];
        }
        if(sum>maxSum){
          maxSum = sum;
        }
      }
    }
    return maxSum;
  }

  private static int cal2(int[] array)throws Exception {
    if(array==null){
      throw new Exception("");
    }
    if(array.length==0){
      return 0;
    }
    int len = array.length;
    int maxSum = 0;
    for(int i=0; i<len; i++){
      int sum = 0;
      for(int j=i; j<len; j++){
        sum+=array[j];
        if(sum>maxSum){
          maxSum = sum;
        }
      }
    }
    return maxSum;
  }

  /**
   *

   */
  private static int cal3(int[] array){
    return 0;



  }

  private static int cal4(int[] array) throws Exception {
    if(array==null){
      throw new Exception("");
    }
    if(array.length==0){
      return 0;
    }
    int maxSum = 0, sum=0;
    for(int i=0; i<array.length; i++){
      sum+=array[i];
      if(sum>maxSum){
        maxSum = sum;
      }else if(sum<0){
        sum=0;
      }
    }
    return maxSum;
  }



}
