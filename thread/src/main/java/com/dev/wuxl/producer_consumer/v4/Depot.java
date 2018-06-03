package com.dev.wuxl.producer_consumer.v4;

import com.dev.wuxl.producer_consumer.common.Product;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/3
 */
public class Depot {

  private final int capacity;
  private LinkedBlockingQueue<Product> products;

  public Depot(int capacity){
    this.capacity = capacity;
    this.products = new LinkedBlockingQueue<Product>(capacity);
  }

  public void produce(String producer){
    System.out.print("Producer " + producer + " put a product:  ");
    Random random = new Random();
    Product product = new Product(System.currentTimeMillis()+"",
      Product.names[random.nextInt(Product.names.length)]);
    System.out.println(product);
    if(products.size()==capacity){
      System.out.println("the depot has been full... ");
    }
    try {
      products.put(product);
      Thread.sleep(new Random().nextInt(1000)+500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void consume(String consumer){
    long s = System.currentTimeMillis();
    if(products.isEmpty()){
      System.out.println("the depot has been empty... ");
    }

    Product product = null;
    try {
      product = products.take();
      System.out.println("consume wait time: " + (System.currentTimeMillis() - s));
      System.out.print("Consumer " + consumer + " get a product:  ");
      System.out.println(product);
      Thread.sleep(new Random().nextInt(1000)+1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

}
