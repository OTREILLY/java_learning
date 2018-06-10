package com.dev.wuxl;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/5
 *
 *  自动装箱与Integer.valueOf()一致，-127~128内的整数，从缓存中取数
 *
 *
 */
public class IntegerDemo {

  public static void main(String[] args) {
    int a = 100;
    Integer b = 100;
    Integer c = Integer.valueOf(100);
    Integer d = new Integer(100);
    System.out.println(a==b);
    System.out.println(a==c);
    System.out.println(a==d);
    System.out.println(b==c);
    System.out.println(b==d);
    System.out.println(c==d);

    System.out.println("------------------");
    int a1 = 100000;
    Integer b1 = 100000;
    Integer c1 = Integer.valueOf(100000);
    Integer d1 = new Integer(100000);
    System.out.println(a1==b1);
    System.out.println(a1==c1);
    System.out.println(a1==d1);
    System.out.println(b1==c1);
    System.out.println(b1==d1);
    System.out.println(c1==d1);



  }


}
