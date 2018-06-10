package com.dev.wuxl.leetcode.string;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/2
 *
 *  回文字符串
 */
public class Solution {

  public static void main(String[] args) {

    System.out.println(judge("aabbccccbbaa"));
    System.out.println(judge(123321));

  }


  private static boolean judge(String s){
    for(int i=0; i<s.length()-i-1; i++){
      if(s.charAt(i)!=s.charAt(s.length()-i-1)){
        return false;
      }
    }
    return true;
  }

  private static boolean judge(int s){
    int temp = s;
    int j = 0;
    while(temp>0){
      j = j*10 + temp%10;
      temp /= 10;
    }
    System.out.println(j);
    return s==j;
  }





}
