package com.dev.wuxl.producer_consumer.v1;

import com.dev.wuxl.producer_consumer.common.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/3
 */
public class Client {

  public static void main(String[] args) {
    Depot depot = new Depot(10);
    Producer producer = new Producer(depot);
    Consumer consumer = new Consumer(depot);
    Random random = new Random();
    for(int i=0; i<20; i++){
      int size = random.nextInt(20)+5;
      System.out.print("第" + i + "次操作： ");
      if(random.nextBoolean()){
        System.out.println("生产" + size + "个Product... ");
        producer.produce(size);
      }else{
        System.out.println("消费" + size + "个Product... ");
        List<Product> products = consumer.consume(size);
        for(Product product: products){
          System.out.println(product);
        }
      }
    }
//    try {
//      Thread.sleep(10);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
  }








}

