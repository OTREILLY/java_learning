package com.dev.wuxl.leetcode.string;

import static com.dev.wuxl.leetcode.string.ArrayUtils.printArray;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/9
 *  计算字符串之间的最短距离
 *
 */
public class Solution6 {

  public static void main(String[] args) {
    String A = "skjed";
    String B = "skjad";
    System.out.println(calculateMinDistance(A.toCharArray(), B.toCharArray()));
  }

  private static int calculateMinDistance(char[] a, char[] b) {
    int lenA = a.length;
    int lenB = b.length;
    if(lenA==0){
      return lenB;
    }
    if(lenB==0){
      return lenA;
    }
    int[][] d = new int[lenA][lenB];
    for(int i=0; i<lenA; i++){
      for(int j=0; j<lenB; j++){
        if(i==0) {
          d[i][j] = j;
        }else if(j==0){
          d[i][j] = i;
        }else{
          int d1 = d[i-1][j-1] + (a[i]==b[j] ? 0 : 1);
          int d2 = d[i-1][j] + 1;
          int d3 = d[i][j-1] + 1;
          d[i][j] = Math.min(Math.min(d1, d2), d3);
        }
      }
    }
    printArray(d," ");
    return d[lenA-1][lenB-1];
  }



}
