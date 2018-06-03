package com.dev.wuxl.producer_consumer.common;

import java.io.Serializable;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/3
 */
public class Product implements Serializable {

  private static final long serialVersionUID = 2764492701916837589L;

  public static final String[] names = {"apple", "oringe", "banana"};

  private String productId;
  private String productName;

  public Product(String productId, String productName){
    this.productId = productId;
    this.productName = productName;
  }

  public Product(){}

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  @Override
  public int hashCode() {
    int result = 31;
    result += ((productId!=null) ? productId.hashCode() * 31 : 0);
    result += ((productName!=null) ? productName.hashCode() * 31 : 0);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if(this == obj){
      return true;
    }
    if(obj==null || this.getClass() != obj.getClass()){
      return false;
    }
    Product o = (Product) obj;
    if(productId!=null ? !productId.equals(o.productId) : o.productId!=null){
      return false;
    }
    if(productName!=null ? !productName.equals(o.productName) : o.productName!=null){
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    res.append("Product:{productId: ");
    res.append(productId);
    res.append(",productName: ");
    res.append(productName);
    res.append("}");
    return res.toString();
  }
}
