package com.dev.wuxl.leetcode.array.search;

import java.util.Arrays;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/7
 */
public class FibonacciSearch {

  public static void main(String[] args) {
    int[] array = {1,2,5,16,20,35,65,80};
    System.out.println(search(array, 1));
  }


  private static final int MAX_SIZE = 100;

  public static int search(int[] array, int key){
    if (array == null || array.length == 0) {
      return -1;
    }
    int fibonacciK[] = getFibonacciK(MAX_SIZE);
    int k = 0;
    while(fibonacciK[k]-1<array.length){
      k++;
    }
    int[] temp = Arrays.copyOf(array, fibonacciK[k]-1);

    for(int i=array.length; i<fibonacciK[k]-1; i++){
      temp[i] = temp[array.length-1];
    }
    int s = 0, e = array.length-1;
    while (s<=e){
      int mid = s + fibonacciK[k-1] - 1;
      if(key<temp[mid]){
        e = mid-1;
        k--;
      }else if(key>temp[mid]){
        s = mid+1;
        k++;
      }else{
        if(mid<=e){
          return mid;
        }else{
          return e;
        }
      }
    }
    return -1;
  }

  private static int[] getFibonacciK(int length) {
    int[] array = null;
    if(length>2){
      array = new int[length];
      array[0] = 1;
      array[1] = 1;
      for(int i=2; i<length; i++){
        array[i] = array[i-2] + array[i-1];
      }
    }
    return array;
  }



}
