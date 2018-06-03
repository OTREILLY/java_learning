package com.dev.wuxl.producer_consumer.v3;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/3
 */
public class Producer {
  private Depot depot;
  private AtomicInteger id;

  public Producer(Depot depot, AtomicInteger id){
    this.depot = depot;
    this.id = id;
  }

  public void produce(final int size){
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          depot.produce(id.incrementAndGet()+"", size);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();
  }




}
