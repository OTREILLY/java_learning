package com.dev.wuxl.leetcode.array.search;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/7
 */
public class LineSerach {

  public static int search(int[] array, int k){
    if(array==null || array.length==0){
      return -1;
    }
    for(int i=0; i<array.length; i++){
      if(array[i] == k){
        return i;
      }
    }
    return -1;
  }



}
