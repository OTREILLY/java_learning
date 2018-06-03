package com.dev.wuxl.producer_consumer.v3;

import com.dev.wuxl.producer_consumer.common.Product;
import com.dev.wuxl.producer_consumer.v2.Consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/3
 */
public class Depot {

  private final int capacity;
  private final Queue<Product> products = new LinkedList<Product>();
  private final ReentrantLock lock = new ReentrantLock();
  private final Condition full = lock.newCondition();
  private final Condition empty = lock.newCondition();

  public Depot(int capacity){
    this.capacity = capacity;
  }

  public void produce(String producer, int size) throws InterruptedException {
    lock.lock();
    while(products.size()+size>=capacity){
      System.out.println("the depot has been full... ");
      full.await();
    }
    System.out.println("Producer " + producer + " put " + size + " products... ");
    Random random = new Random();
    for(int i=0; i<size; i++){
      Product product =
        new Product(System.currentTimeMillis()+"", Product.names[random.nextInt(Product.names.length)]);
      products.offer(product);
      System.out.println("Producer " + producer + ": " + product);
    }
    empty.signalAll();
    full.signalAll();
    lock.unlock();
    Thread.sleep(random.nextInt(1000)+1);
  }

  public void consume(String consumer, int size) throws InterruptedException {
    lock.lock();
    while(products.size()<size){
      System.out.println("the depot has been empty... ");
      empty.await();
    }
    System.out.println("Consumer " + consumer + " get " + size + " products... ");
    for(int i=0; i<size; i++){
      Product product = products.poll();
      System.out.println("Consumer " + consumer + ": " + product);

    }
    full.signalAll();
    empty.signalAll();
    lock.unlock();
    Thread.sleep(new Random().nextInt(1000)+1);
  }




}
