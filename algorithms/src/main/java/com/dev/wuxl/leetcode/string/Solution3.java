package com.dev.wuxl.leetcode.string;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/9
 *
 *  替换字符串中的空格
 *
 */
public class Solution3 {

  public static void main(String[] args) {

    char[] input = "i am a student".toCharArray();
    char[] target = "$%^".toCharArray();
    int i=0;
    for(char c: input){
      if(c==' '){
        i++;
      }
    }
    int len = input.length + (i-1)*target.length;
    char[] res = new char[len];
    int k = len-1;
    for(int j=input.length-1; j>=0; j--){
      if(input[j]==' '){
        for(int m = target.length-1; m>=0; m--){
          res[k--] = target[m];
        }
      }else{
        res[k--] = input[j];
      }
    }
    System.out.println(new String(res));
  }




}
