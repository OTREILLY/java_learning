package com.dev.wuxl.leetcode.array;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/2
 */
public class Solution5 {


  public int[] intersect(int[] nums1, int[] nums2) {

    int len1 = nums1.length;
    int len2 = nums2.length;
    if(len1==0 || len2==0){
      return new int[0];
    }
    int len = len1<len2 ? len1 : len2;
    int k = 0;
    int[] res = new int[len];
    for(int i=0; i<len1; i++){
      for(int j=0; j<len2; j++){
        if(nums1[i] == nums2[j]){
          res[k++] = nums1[i];
        }
      }
    }
    return res;
  }

}
