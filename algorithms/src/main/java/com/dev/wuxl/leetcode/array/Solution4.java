package com.dev.wuxl.leetcode.array;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/2
 *
 * 找出数组中仅出现一次的数（其他数均出现两次）
 *  一个整数 与自己异或是0，与0异或是自己
 *
 */
public class Solution4 {

  public int singleNumber(int[] nums) {
    if(nums==null || nums.length==0){
      return -1;
    }

    int result = 0;
    for(int i=0; i<nums.length; i++){
      result ^= nums[i];
    }
    return result;
  }



}
