package com.dev.wuxl.producer_consumer.v3;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/3
 */
public class Consumer {
  private Depot depot;
  private AtomicInteger id;

  public Consumer(Depot depot, AtomicInteger id){
    this.depot = depot;
    this.id = id;
  }

  public void consume(final int size){
    new Thread(new Runnable() {
      @Override public void run() {
        try {
          depot.consume(id.incrementAndGet()+"", size);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();
  }


}
