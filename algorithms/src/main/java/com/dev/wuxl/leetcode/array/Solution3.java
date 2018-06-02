package com.dev.wuxl.leetcode.array;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/2
 */
public class Solution3 {



  public boolean containsDuplicate1(int[] nums) {
    if(nums==null || nums.length<2){
      return false;
    }
    int n = nums.length;
    for(int i=0; i<n-2; i++){
      for(int j=i+1; j<n-1; j++){
        if(nums[i]==nums[j]){
          return true;
        }
      }
    }
    return false;
  }

  public boolean containsDuplicate2(int[] nums) {
    if(nums==null || nums.length<2){
      return false;
    }
    //TODO sort nums
    int n = nums.length;
    for(int i=0; i<n-2; i++){
      if(nums[i]==nums[i+1]){
        return true;
      }
    }
    return false;
  }


}
