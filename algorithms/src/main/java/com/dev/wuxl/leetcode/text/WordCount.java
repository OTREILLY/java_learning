package com.dev.wuxl.leetcode.text;

import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/9
 */
public class WordCount {

  static ExecutorService service = Executors.newFixedThreadPool(5);
  public static void main(String[] args) throws InterruptedException {
    String[] files = {};
    Map<String, AtomicInteger> resMap = new ConcurrentHashMap<String, AtomicInteger>();
    wordCount(resMap, files);
    service.shutdown();
    service.awaitTermination(1, TimeUnit.HOURS);
    top10(resMap);
  }

  private static void top10(Map<String,AtomicInteger> resMap) {




  }

  private static void wordCount(final Map<String,AtomicInteger> resMap, String[] files) {

    for(final String file: files){
      service.execute(new Runnable() {
        @Override
        public void run() {
          BufferedReader reader = null;
          try {
            reader = new BufferedReader(new FileReader(file));
            String line = null;
            while((line=reader.readLine())!=null){
              String[] words = line.split(" ");
              for(String word: words){
                AtomicInteger count = resMap.get(word);
                if(count==null){
                  count = new AtomicInteger(1);
                  resMap.put(word, count);
                }else{
                  count.incrementAndGet();
                }
              }
            }
          } catch (FileNotFoundException e) {
            e.printStackTrace();
          } catch (IOException e) {
            e.printStackTrace();
          } finally {
            if(reader!=null){
              try {
                reader.close();
              } catch (IOException e) {
                e.printStackTrace();
              }
            }
          }
        }
      });
    }
  }



}
