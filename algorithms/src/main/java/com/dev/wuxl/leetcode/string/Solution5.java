package com.dev.wuxl.leetcode.string;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/9
 *
 *  第一个没有重复的字符
 *
 */
public class Solution5 {

  public static void main(String[] args) {

    char[] input = "dasjdasjdade".toCharArray();
    char[] record = new char[255];
    for(char c: input){
      record[c] ++;
    }
    for(char c: input){
      if(record[c]==1){
        System.out.println(c);
        return;
      }
    }

  }





}
