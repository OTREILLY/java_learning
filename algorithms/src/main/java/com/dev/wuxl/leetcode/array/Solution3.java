package com.dev.wuxl.leetcode.array;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/2
 */
public class Solution3 {


  public static void main(String[] args) {
    Solution3 solution = new Solution3();
    int[] arr = {1,4,3,2,0};
    System.out.println(solution.containsDuplicate3(arr));
  }

  public boolean containsDuplicate1(int[] nums) {
    if(nums==null || nums.length<2){
      return false;
    }
    int n = nums.length;
    for(int i=0; i<n-1; i++){
      for(int j=i+1; j<n; j++){
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
    SortedArray.selectedSort(nums);
    int n = nums.length;
    for(int i=0; i<n-2; i++){
      if(nums[i]==nums[i+1]){
        return true;
      }
    }
    return false;
  }

  /**
   *  局部排序
   * @param nums
   * @return
   */
  public boolean containsDuplicate3(int[] nums) {

    for (int i = 1; i < nums.length; i++){
      int  j = i - 1;
      int  t = nums[j+1];
      while (j >= 0 && nums[j] > t ){
        nums[j+1] = nums[j];
        j--;
      }
      nums[j+1] = t;
      if (j >= 0 && nums[j] == nums[j+1]){
        return true;
      }
    }
    return false;
  }



}
