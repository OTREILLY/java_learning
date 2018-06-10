package com.dev.wuxl.leetcode.string;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/9
 */
public class ArrayUtils {

  public static void swap(char[] input, int i, int j) {
    char temp = input[i];
    input[i] = input[j];
    input[j] = temp;
  }

  public static void printArray(char[] input, String split) {
    for(char c: input){
      System.out.print(c + split);
    }
    System.out.println("");
  }

  public static void printArray(int[][] d, String s) {

    for(int i=0; i<d.length; i++){
      for(int j=0; j<d[i].length; j++){
        System.out.print(d[i][j] + s);
      }
      System.out.println("");
    }


  }


}
