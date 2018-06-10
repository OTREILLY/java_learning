package com.dev.wuxl.leetcode.array;

import static com.dev.wuxl.leetcode.array.ArrayUtils.swap;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/2
 *
 * 排序算法
 *  简单选择排序， 堆排序
 *  直接插入排序，希尔排序
 *  冒泡排序，快速排序
 *  归并排序
 *  基数排序
 *
 *
 */
public class SortedArray {

  /**
   *  简单选择排序
   * @param arr
   */
  public static void selectedSort(int[] arr) {
    if (arr == null) {
      //todo
      return;
    }

    int len = arr.length;
    if (len <= 1) {
      return;
    }
    for (int i = 0; i < len; i++) {
      int minI = i;
      for (int j = i + 1; j < len; j++) {
        if (arr[j] < arr[minI]) {
          minI = j;
        }
      }
      if (minI != i) {
        swap(arr, minI, i);
      }
    }
  }

  /**
   *  选择排序改进版
   * @param arr
   */
  public static void selectedSort2(int[] arr) {
    if (arr == null) {
      //todo
      return;
    }

    int len = arr.length;
    if (len <= 1) {
      return;
    }
    for (int i = 0; i < len/2; i++) {
      int minI = i;
      int end = len-i-1;
      int maxI = end;
      for (int j = i; j <= end; j++) {
        if (arr[j] < arr[minI]) {
          minI = j;
        }
        if(arr[j] > arr[maxI]){
          maxI = j;
        }
      }
      if (minI != i) {
        swap(arr, minI, i);
      }
      if(maxI!=end){
        swap(arr, maxI, end);
      }
    }
  }

  /**
   *  堆排序
   * @param arr
   */
  public static void heapSort(int[] arr){
    if(arr==null){
      //todo
      return ;
    }
    int len = arr.length;
    if(len<=1){
      return;
    }
    for(int i=len-1; i>=0; i--){
      int p = i/2-2;
      while(p>=0){
        int left = p*2+1;
        int right = left+2;
        if(arr[left]>arr[p]) {
          swap(arr, p, left);
        }
        if(right<len && arr[right]>arr[p]){
          swap(arr, p, right);
        }
        p--;
      }
      swap(arr, 0, i);
    }
  }

  /**
   *  冒泡排序
   * @param arr
   */
  public static void bubbleSort(int[] arr){
    if(arr==null){
      //
      return;
    }
    int len = arr.length;
    for(int i=len-1; i>=1; i--){
      for(int j=0; j<i; j++){
        if(arr[j]>arr[j+1]){
          swap(arr, j, j+1);
        }
      }
    }
  }

  /**
   *  快速排序
   * @param arr
   */
  public static void quickSort(int[] arr){

    quickSort(arr, 0, arr.length-1);

  }

  private static void quickSort(int[] arr, int start, int end){
    int partition = getPartition(arr, start, end);
    quickSort(arr, start, partition-1);
    quickSort(arr, partition+1, end);

  }

  private static int getPartition(int[] arr, int start, int end) {

    if(start>=end){
      return start;
    }
    int temp = arr[start];
    while(start<end) {
      while (start < end && temp < arr[end]) {
        end--;
      }
      if (start < end) {
        arr[start] = arr[end];
      }
      while (start < end && temp > arr[start]) {
        start++;
      }
      if (start < end) {
        arr[end] = arr[start];
      }
    }
    arr[start] = temp;
    return start;
  }


  /**
   *  直接查询排序
   * @param arr
   */
  public static void insertSort(int[] arr){

    if(arr==null){
      //
      return;
    }
    int len = arr.length;
    if(len<=1){
      return;
    }
    for(int i=1; i<len; i++){
      int temp = arr[i];
      int j=i-1;
      while(j>=0 && temp<arr[j]){
        swap(arr, j, j+1);
        j--;
      }
      arr[j+1] = temp;
    }
  }

  public static void binaryInsertSort(int[] arr){
    if(arr==null){
      //
      return;
    }
    int len = arr.length;
    if(len<=1){
      return;
    }
    for(int i=1; i<len; i++){

      int start = 0, end = i-1;
      while(start<end){
        int mid = (start+end)/2;
        if(arr[i]<arr[mid]){
          end = mid-1;
        }else{
          start = mid+1;
        }
      }

      int temp = arr[i];
      int j = i-1;
      while(j>start){
        swap(arr, j, j+1);
        j--;
      }
      arr[start] = temp;
    }
  }





}
