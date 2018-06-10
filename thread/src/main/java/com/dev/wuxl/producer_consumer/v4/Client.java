package com.dev.wuxl.producer_consumer.v4;

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
    for (int i = 0; i < 50; i++) {
      int p = random.nextInt(10);
      if (p > 5) {
        producer.produce();
      } else {
        consumer.consume();
      }
    }

    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }


}
