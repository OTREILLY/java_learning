package com.dev.wuxl.producer_consumer.v2;

import com.dev.wuxl.producer_consumer.common.Product;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/3
 */
public class Depot {

  private int capacity;
  private final Queue<Product> products = new LinkedList<Product>();
  public Depot(int capacity){
    this.capacity = capacity;
  }

  private static final String[] names = {"apple", "oringe", "banana"};

  public void produce(String producer, int size) throws InterruptedException {
    synchronized (products){
      while(products.size() + size>=capacity){
        System.out.println("the depot has been full.... ");
        products.wait();
      }
      Random random = new Random();
      System.out.println("Producer " + producer + " produce " + size + " products to the depot");
      for(int i=0; i<size; i++) {
        Product product = new Product(System.currentTimeMillis() + "", names[random.nextInt(3)]);
        System.out.println("Producer " +producer + ":" + product);
        products.offer(product);
      }
      products.notifyAll();
      Thread.sleep(new Random().nextInt(1000)+1);
    }
  }

  public void consume(String consumer, int size) throws InterruptedException {
    synchronized (products){
      while(products.size() < size){
        System.out.println("the depot has been empty... ");
        products.wait();
      }
      System.out.println("Comsumer " + consumer + " consume " + size + " products... ");
      for(int i=0; i<size; i++) {
        Product product = products.poll();
        System.out.println("Comsumer " + consumer + ":" + product);
      }
      products.notifyAll();
      Thread.sleep(new Random().nextInt(1000)+1);
    }
  }






}
