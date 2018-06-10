package com.dev.wuxl.leetcode.text;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/9
 */
public class WordCount2 {

  public static void main(String[] args) {

    Map<String, AtomicInteger> resMap = new ConcurrentHashMap<String, AtomicInteger>(10000);
    final CountDownLatch latch = new CountDownLatch(5);
    String[] files = {};
    try {
      wordCount(files, latch, resMap);
      latch.await();
      getTop(resMap);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private static void getTop(Map<String,AtomicInteger> resMap) {



  }

  private static void wordCount(String[] files,final CountDownLatch latch, Map<String, AtomicInteger> resMap){
    final int len = files.length;
    int lap = len/5;
    for(int i=0; i<5; i++){
      final int s = lap*i, e = s+lap;
      wordCount(files, s, e, latch, resMap);
    }

  }

  private static void wordCount(final String[] files, final int s, final int e,
    final CountDownLatch latch, Map<String, AtomicInteger> resMap){
    final int len = files.length;
    new Thread(new Runnable() {
      @Override
      public void run() {
        for(int j=s; j<len && j<e; j++){
          String file = files[j];
          BufferedReader reader = null;
          try {
            reader = new BufferedReader(new FileReader(file));
            String line = null;
            while((line=reader.readLine())!=null){

            }
          } catch (FileNotFoundException e1) {
            e1.printStackTrace();
          } catch (IOException e1) {
            e1.printStackTrace();
          } finally {
            if(reader!=null) {
              try {
                reader.close();
              } catch (IOException e1) {
                e1.printStackTrace();
              }
            }
          }
        }
        latch.countDown();
      }
    });
  }







}
