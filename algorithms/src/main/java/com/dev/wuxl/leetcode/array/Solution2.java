package com.dev.wuxl.leetcode.array;

import static com.dev.wuxl.leetcode.array.ArrayUtils.swap;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/2
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 *
 *
 */
public class Solution2 {

  public static void main(String[] args) {

  }

  public int removeDuplicates(int[] nums) {
    int start = 0;
    for(int i=1; i<nums.length && start<nums.length; i++){
      if(nums[i]>nums[start]){
        swap(nums, i, start+1);
        start++;
      }
    }
    return start+1;
  }

}
