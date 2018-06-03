package com.dev.wuxl.producer_consumer.v2;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/3
 */
public class Client {

  public static void main(String[] args) {
    Depot depot = new Depot(20);
    AtomicInteger producerID = new AtomicInteger();
    Producer producer = new Producer(depot, producerID);
    AtomicInteger consumerID = new AtomicInteger();
    Consumer consumer = new Consumer(depot, consumerID);
    Random random = new Random();
    Random random1 = new Random();
    for(int i=0; i<50; i++){
      if(random.nextBoolean()){
        int size = random.nextInt(10)+1;
        producer.produce(size);
      }else{
        int size = random.nextInt(5)+1;
        consumer.consume(size);
      }
    }

  }




}
