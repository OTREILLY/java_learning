package com.dev.wuxl.join;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/3
 */
public class Demo {

  public static void main(String[] args) throws InterruptedException {
    Thread thread1 = new Thread(new Runnable() {
      @Override public void run() {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
      }
    }, "thread1");
    Thread thread2 = new Thread(new Runnable() {
      @Override public void run() {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
      }
    }, "thread2");
    Thread thread3 = new Thread(new Runnable() {
      @Override public void run() {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
      }
    }, "thread3");


    thread1.start();
    thread1.join();
    thread2.start();
    thread2.join();
    thread3.start();
    thread3.join();

  }





}
