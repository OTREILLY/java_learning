package com.dev.wuxl.producer_consumer.v1;

import com.dev.wuxl.producer_consumer.common.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/3
 */
public class Producer {

  private Depot depot;

  public Producer(Depot depot){
    this.depot = depot;
  }

  public void produce(final int size){
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          List<Product> products = createProducts(size);
          depot.produce(products);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();

  }

  private static final String[] names = {"apple", "oringe", "banana"};

  private List<Product> createProducts(int size) {
    List<Product> resList = new ArrayList<Product>();
    Random random = new Random();
    for (int i = 0; i < size; i++) {
      resList.add(new Product(System.currentTimeMillis() + "", names[random.nextInt(3)]));
      try {
        Thread.sleep(random.nextInt(3)+1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    return resList;
  }

}
