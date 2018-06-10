package com.dev.wuxl.leetcode.string;

import java.util.List;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/9
 *
 * 输出字符串的全排列
 */
public class Solution4 {

  public static void main(String[] args) {

    char[] input = "123".toCharArray();
    int len = input.length;
    int deep = 0;
    permutationStr(input, deep, len);
  }


  private static void permutationStr(char[] input, int deep, int len){
    if(deep==len){
      printArray(input);
      return;
    }
    for(int i=deep; i<len; i++){
      swap(input, i, deep);
      permutationStr(input, deep+1, len);
      swap(input, i, deep);
    }
  }

  private static void swap(char[] input, int i, int j) {
    char temp = input[i];
    input[i] = input[j];
    input[j] = temp;
  }

  private static void printArray(char[] input) {
    for(char c: input){
      System.out.print(c + " ");
    }
    System.out.println("");
  }


}
