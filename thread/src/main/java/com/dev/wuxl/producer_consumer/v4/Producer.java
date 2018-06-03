package com.dev.wuxl.producer_consumer.v4;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/3
 */
public class Producer {

  private Depot depot;
  private AtomicInteger ids;

  public Producer(Depot depot, AtomicInteger ids){
    this.depot = depot;
    this.ids = ids;
  }

  public void produce(){
    new Thread(new Runnable() {
      @Override public void run() {
        depot.produce(ids.incrementAndGet()+"");
      }
    }).start();
  }

}
