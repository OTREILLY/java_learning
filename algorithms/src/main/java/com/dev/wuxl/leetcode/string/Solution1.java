package com.dev.wuxl.leetcode.string;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/9
 *
 *  最长回文子串
 */
public class Solution1 {

  public static void main(String[] args) {
    System.out.println(getLongestSubStr("abcba"));
  }

  private static String getLongestSubStr(String s){
    if(s==null || s.length()<2){
      return s;
    }
    String sub = "";
    for(int i=0; i<s.length(); i++){
      String _sub = getLongestSubStr(s, i, i);
      if(_sub.length()>sub.length()){
        sub = _sub;
      }
      _sub = getLongestSubStr(s, i, i+1);
      if(_sub.length()>sub.length()){
        sub = _sub;
      }
    }
    return sub;
  }

  private static String getLongestSubStr(String s, int i, int j){

    String sub = "";
    while(i>=0 && j<s.length()){
      if(s.charAt(i)!=s.charAt(j)){
        break;
      }
      if(j-i>0){
        sub = s.substring(i, j+1);
      }
      i--;
      j++;
    }
    return sub;
  }





}
