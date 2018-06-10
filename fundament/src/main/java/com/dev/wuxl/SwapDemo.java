package com.dev.wuxl;

import java.lang.reflect.Field;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/5
 */
public class SwapDemo {

  public static void main(String[] args) {
    Integer a = 1, b = 2;
    System.out.println(""  + a + " " + b);
//    swap1(a, b);
//    swap2(a, b);
    swap3(a, b);
//    swap4(a, b);
    System.out.println(""  + a + " " + b);

  }

  public static void swap1(Integer a, Integer b){
    int t = a;
    a = b;
    b = t;
  }

  public static void swap2(Integer a, Integer b){
    Integer t = a;
    a = b;
    b = t;
  }

  public static void swap3(Integer a, Integer b){
    Integer t = a + 128;
    a = b;
    b = t-128;
  }

  public static void swap4(Integer a, Integer b){
    Field filed = null;
    Integer tmp = new Integer(a);
    try {
      filed = Integer.class.getDeclaredField("value");
      filed.setAccessible(true);
      filed.set(a, new Integer(b));
      filed.set(b, tmp);
    } catch (NoSuchFieldException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }


  }






}
