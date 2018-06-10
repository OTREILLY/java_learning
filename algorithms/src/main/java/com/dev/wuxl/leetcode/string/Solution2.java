package com.dev.wuxl.leetcode.string;

import static com.dev.wuxl.leetcode.string.ArrayUtils.printArray;
import static com.dev.wuxl.leetcode.string.ArrayUtils.swap;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/9
 *
 *  翻转句子
 *
 *
 */
public class Solution2 {

  public static void main(String[] args) {

    char[] input = "I am a original string".toCharArray();
    reverse(input, 0, input.length-1);
    printArray(input, "");
    int s = 0, e;
    for(int i=0; i<input.length; i++){
      if(input[i]==' '){
        e = i-1;
        reverse(input, s, e);
        s = i+1;
      }else if(i==input.length-1){
        reverse(input, s, input.length-1);
      }
    }
    printArray(input, "");


  }

  private static void reverse(char[] input, int s, int e){
    while(s<e){
      swap(input, s++, e--);
    }
  }







}
