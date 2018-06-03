package com.dev.wuxl.leetcode.array;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/2
 */
public class Solution8 {

  public static void main(String[] args) {
    int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
    ArrayUtils.printArray("", matrix[0]);
    ArrayUtils.printArray("", matrix[1]);
    ArrayUtils.printArray("", matrix[2]);
    System.out.println("");
    new Solution8().rotate(matrix);
    ArrayUtils.printArray("", matrix[0]);
    ArrayUtils.printArray("", matrix[1]);
    ArrayUtils.printArray("", matrix[2]);



  }


  public void rotate(int[][] matrix) {

    int n = matrix.length;
    if(n==1){
      return;
    }
    if(n==2){
      int temp = matrix[0][0];
      matrix[0][0] = matrix[1][0];
      matrix[1][0] = matrix[1][1];
      matrix[1][1] = matrix[0][1];
      matrix[0][1] = temp;
      return;
    }
    int end = n-1;
    for(int i=0; i<n-2; i++){
      if(i==n-3){
        int temp = matrix[i][i];
        matrix[i][i] = matrix[i+1][i];
        matrix[i+1][i] = matrix[i+1][i+1];
        matrix[i+1][i+1] = matrix[i][i+1];
        matrix[i][i+1] = temp;
        break;
      }
      for(int j=i; j<end; j++){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[end-j][i];
        matrix[end-j][i] = matrix[end-i][end-j];
        matrix[end-i][end-j] = matrix[j][end-i];
        matrix[j][end-i] = temp;
      }
    }
  }

}
