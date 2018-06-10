package com.dev.wuxl.leetcode.text;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/9
 */
public class WordCount3 {

  public static void main(String[] args) {
    String[] files = {
      //todo list files path
    };
    Map<String, Integer> countMap = wordCount(files);
    String[] top10Words = getTop(countMap);
    for(String word: top10Words){
      System.out.println(word + ": " + countMap.get(word));
    }
  }

  /**
   *  建立小树堆
   */
  private static String[] getTop(Map<String,Integer> countMap) {
    String[] top10 = new String[11];
    int i = 0;
    for(Map.Entry<String, Integer> entry: countMap.entrySet()){
      String key = entry.getKey();
      int value = entry.getValue();
      if(i<10){
        top10[i] = key;
        updateTop10(top10, i, countMap);
      }else if(value<countMap.get(top10[0])){
        continue;
      }
      top10[0] = key;
      updateTop10(top10, 9, countMap);
      i++;
    }
    return top10;
  }

  /**
   *  调整小树堆
   * @param top10
   * @param end
   * @param countMap
   */
  private static void updateTop10(String[] top10, int end, Map<String, Integer> countMap) {
    if(end==0){
      return;
    }
    int p = (end-1)/2;
    while(p>=0){
      int left = p*2+1;
      int right = left+1;
      if(left<=end && countMap.get(top10[p]) > countMap.get(top10[left])){
        swap(top10, p, left);
      }
      if(right<=end && countMap.get(top10[p]) > countMap.get(top10[right])){
        swap(top10, p, right);
      }
      p--;
    }
  }

  private static void swap(String[] top10, int i, int j){
    String temp = top10[i];
    top10[i] = top10[j];
    top10[j] = temp;
  }

  private static Map<String,Integer> wordCount(String[] files) {
    Map<String, Integer> resMap = new HashMap<String, Integer>();
    ExecutorService service = Executors.newFixedThreadPool(5);
    List<Future<Map<String, Integer>>> futures = new CopyOnWriteArrayList<Future<Map<String, Integer>>>();
    for(final String file: files){
      Future<Map<String, Integer>> future = service.submit(new Callable<Map<String, Integer>>() {
        @Override
        public Map<String, Integer> call() throws Exception {
          return readFile(file);
        }
      });
      futures.add(future);
    }

    while(true){
      for(Future<Map<String, Integer>> future: futures){
        if(!future.isDone()){
          continue;
        }
        try {
          Map<String, Integer> subCount = future.get();
          //todo Merge
        } catch (InterruptedException e) {
          e.printStackTrace();
        } catch (ExecutionException e) {
          e.printStackTrace();
        }
        futures.remove(future);
      }
      if(futures.isEmpty()){
        break;
      }
    }
    return resMap;
  }

  private static Map<String, Integer> readFile(String file){

    Map<String, Integer> resMap = new HashMap<String, Integer>();
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new FileReader(file));
      String line = null;
      while((line=reader.readLine())!=null){
        //todo



      }
    } catch (FileNotFoundException e) {
      //todo
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return resMap;
  }





}
