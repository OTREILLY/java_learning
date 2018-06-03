package com.dev.wuxl.producer_consumer.v1;

import com.dev.wuxl.producer_consumer.common.Product;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/3
 *
 *  生产者消费者模型中的仓库
 *
 */
public class Depot {

  private int capacity;
  private LinkedList<Product> products = new LinkedList<Product>();

  public Depot(int capacity){
    this.capacity = capacity;
  }

  public synchronized void produce(List<Product> newProducts) throws InterruptedException {
    if(products==null){
      //todo
      return ;
    }
    try {
      int pos = 0;
      int newSize = newProducts.size();
      while(pos<newSize){
        int size = products.size();
        while(size>capacity) {
          wait();
        }
        size = products.size();
        int left = capacity-size;
        for(int i=0; i<left; i++){
          products.push(newProducts.get(pos + i));
          pos++;
        }
        notifyAll();
      }
    }catch (Exception e){

    }
  }

  public synchronized List<Product> consumer(int size) throws InterruptedException {
    if(size<=0){
      return new ArrayList<Product>();
    }

    List<Product> resList = new ArrayList<Product>();

    while(resList.size()<size){
      while(products.size()<=0) {
        wait();
      }
      int realSize = products.size();
      int left = size-resList.size();
      if(left<=0){
        break;
      }
      int getSize = left > realSize ? realSize : left;
      for(int i=0; i<getSize; i++){
        resList.add(products.pop());
      }
      notifyAll();
    }
    return resList;
  }

}
