package com.dev.wuxl.leetcode.string;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/9
 *  寻找字符串不包含重复字符的最长子字符串
 *
 */
public class Solution7 {

  public static void main(String[] args) {
    char[] input = "abcdbcbb".toCharArray();
    System.out.println(getSubString(input));
  }

  private static String getSubString(char[] input){
    int len = input.length;
    if(len==0 || len==1){
      return new String(input);
    }
    int maxi = 0, maxj = 0;
    int i=0, j=1;
    while(j<len){
      int temp = i;
      for(int k = i; k<j; k++){
        if(input[j]==input[k]){
          temp=k+1;
          break;
        }
      }
      if(j-i>maxj-maxi){
        maxi = i;
        maxj = j;
      }
      i=temp;
      j++;
    }
    StringBuilder s = new StringBuilder();
    for(int k=maxi; k<maxj; k++){
      s.append(input[k]);
    }
    return s.toString();
  }


  private static void printSubArray(char[] input, int maxi, int maxj, String split) {
    for(int i=maxi; i<=maxj; i++){
      System.out.print(input[i] + split);
    }
    System.out.println("");
  }



}
