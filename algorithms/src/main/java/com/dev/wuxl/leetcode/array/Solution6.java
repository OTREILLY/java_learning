package com.dev.wuxl.leetcode.array;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/2
 */
public class Solution6 {
  public void moveZeroes(int[] nums) {
    if(nums==null || nums.length<=1){
      return;
    }
    int pos = 0;
    for(int i=0; i<nums.length; i++){
      if(nums[i]!=0){
        nums[pos++] = nums[i];
      }
    }
    for(int i = pos+1; i<nums.length; i++){
      nums[i] = 0;
    }
  }


}
