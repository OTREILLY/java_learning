package com.dev.wuxl.producer_consumer.v1;

import com.dev.wuxl.producer_consumer.common.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/3
 */
public class Consumer {

  private Depot depot;
  public Consumer(Depot depot){
    this.depot = depot;
  }

  public List<Product> consume(final int size){
    final List<Product> resList = new ArrayList<Product>();
    new Thread(new Runnable() {
      @Override public void run() {
        try {
          resList.addAll(depot.consumer(size));
          for(Product product: resList){
            System.out.println(product);
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();
    return resList;
  }

}
