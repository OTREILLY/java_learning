package com.dev.wuxl.leetcode.array;

import static com.dev.wuxl.leetcode.array.ArrayUtils.swap;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/7
 *
 * 排序算法
 *  *  简单选择排序， 堆排序
 *  *  直接插入排序，希尔排序
 *  *  冒泡排序，快速排序
 *  *  归并排序
 *  *  基数排序
 *
 *
 */
public class SortArray {


  public static void main(String[] args) {

    int[] a = {25,4,9,15,23,2,11,3,1};
//    int[] a = {2,3,4,5,9,11,15,23,25};
    try {
      sort3(a);
      ArrayUtils.printArray("", a);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  /**
   *  简单选择排序
   */
  private static void sort1(int[] array) throws Exception {
    if(array==null){
      throw new Exception("illegal array");
    }
    int len = array.length;
    if(len==1){
      return;
    }
    for(int i=0; i<len; i++){
      int minIndex = i;
      for(int j=i+1; j<len; j++){
        if(array[j]<minIndex){
          minIndex = j;
        }
      }
      if(i!=minIndex) {
        swap(array, i, minIndex);
      }
    }
  }

  /**
   *  简单选择排序  改进版
   */
  private static void sort2(int[] array) throws Exception {
    if(array==null){
      throw new Exception("illegal array");
    }
    int len = array.length;
    if(len==1){
      return;
    }
    for(int i=0; i<len-i; i++){
      int minIndex = i, maxIndex = len-i-1;
      for(int j=i; j<len-i; j++){
        if(array[j]<array[minIndex]){
          minIndex = j;
        }
        if(array[j]>array[maxIndex]){
          maxIndex = j;
        }
      }
      if(minIndex!=i){
        swap(array, minIndex, i);
      }
      if(maxIndex!=i && maxIndex!=len-i-1){
        swap(array, maxIndex, len-i-1);
      }
    }
  }

  /**
   * 堆排序
   */
  public static void sort3(int[] array) throws Exception {
    if(array==null){
      throw new Exception("illegal array");
    }
    int len = array.length;
    if(len==1){
      return;
    }
    for(int i=len-1; i>=0; i--){
      int p = i/2-1;
      while(p>=0){
        int left = p*2+1;
        int right = left+1;
        if(array[p]<array[left]){
          swap(array, p, left);
        }
        if(array[p]<array[right]){
          swap(array, p, right);
        }
        p--;
      }
      swap(array, 0, i);
    }
  }


  /**
   *  冒泡排序
   */
  public static void sort4(int[] array){
    //...
  }


  /**
   *  快速排序
   */
  public static void sort5(int[] array) throws Exception {
    if(array==null){
      throw new Exception("illegal array");
    }
    int len = array.length;
    if(len==1){
      return;
    }
    quickSort(array, 0, len-1);
  }

  private static void quickSort(int[] array, int s, int e) {
    if(s>=e){
      return;
    }
    int partition = getPartition(array, s, e);
    quickSort(array, s, partition-1);
    quickSort(array, partition + 1, e);
  }

  private static int getPartition(int[] array, int s, int e) {
    int temp = array[s];
    while(s<e){
      while(s<e && array[e]>temp) e--;
      if(s<e){
        array[s] = array[e];
        s++;
      }
      while(s<e && array[s]<temp) s++;
      if(s<e){
        array[e] = array[s];
        e--;
      }
    }
    array[s] = temp;
    return s;
  }

  /**
   *  直接插入排序
   */
  public static void sort6(int[] array) throws Exception {
    if(array==null){
      throw new Exception("illegal array");
    }
    int len = array.length;
    if(len==1){
      return;
    }
    for(int i=1; i<len; i++){
      for(int j=i; j>0; j--){
        if(array[j]<array[j-1]){
          swap(array, j, j-1);
        }
      }
    }
  }

  /**
   *  二分插入排序
   */
  public static void sort7(int[] array) throws Exception {
    if(array==null){
      throw new Exception("illegal array");
    }
    int len = array.length;
    if(len==1){
      return;
    }
    for(int i=1; i<len; i++){
      int start = 0, end = i-1;
      while(start<=end){
        int mid = (start+end)/2;
        if(array[i]<array[mid]){
          end = mid-1;
        }else{
          start = mid+1;
        }
      }
      int j=i;
      int temp = array[i];
      while(j>start){
        swap(array, j, j-1);
        j--;
      }
      array[j] = temp;
    }
  }

  /**
   *  希尔排序
   */
  public static void sort8(int[] array) throws Exception {
    if(array==null){
      throw new Exception("illegal array");
    }
    int len = array.length;
    if(len==1){
      return;
    }
    int d = len/2;
    while(d>=1){
      for(int i=d; i<len; i++){
        for(int j=i; j>=d; j-=d){
          if(array[j]>=array[j-d]){
            break;
          }
          swap(array, j, j-d);

        }
      }
      d/=2;
    }
  }


  /**
   *  归并排序
   */
  public static void sort9(int[] array) throws Exception{
    if(array==null){
      throw new Exception("illegal array");
    }
    int len = array.length;
    if(len==1){
      return;
    }
    mergeSort(array, 0, len-1);
  }

  private static void mergeSort(int[] array, int s, int e) {
    if(s>=e){
      return;
    }
    int mid = (s+e)/2;
    mergeSort(array, s, mid);
    mergeSort(array, mid+1, e);
    merge(array, s, mid, e);
  }

  private static void merge(int[] array, int s, int mid, int e) {
    for(int i=mid+1; i<=e; i++){
      int temp = array[i];
      int j = i;
      while(j>s && array[j]<array[j-1]){
        swap(array, j, j-1);
        j--;
      }
      array[j] = temp;
    }
  }

}
