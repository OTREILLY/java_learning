package com.dev.wuxl.leetcode.tree;

/**
 * @author <a href="mailto:wu.xuanle@immomo.com">wu.xuanle</a>
 * @create 18/6/10
 */
public class TreeUtils {


  public static Tree createTree(int[] array){
    if(array==null || array.length==0){
      return null;
    }
    Tree tree = new Tree();
    for(int i=0; i<array.length; i++){
      insertToTree(tree, array[i]);
    }
    return tree;
  }


  /**
   *
   * @param tree
   * @param value
   */
  public static void insertToTree(Tree tree, int value){
    if(tree==null){
      return;
    }
    Node node = new Node(value);
    Node tNode = tree.getRoot();
    Node pNode = null;
    while(tNode!=null){
      pNode = tNode;
      if(tNode.getKey()>value){
        tNode = tNode.getLeft();
      }else{
        tNode = tNode.getRight();
      }
    }
    if (pNode == null) {
      tree.setRoot(node);
    }else if(pNode.getKey()>value){
      pNode.setLeft(node);
    }else{
      pNode.setRight(node);
    }
    tree.setSize(tree.getSize()+1);
  }


  /**
   *  先序遍历
   * @param tree
   */
  public static void printTree(Tree tree, int type){
    if(tree==null){
      return;
    }
    if(type==0) {
      printPreOrder(tree.getRoot());
    }else if(type==1){
      printInOrder(tree.getRoot());
    }else if(type==3){
      printPostOrder(tree.getRoot());
    }else{
      System.out.println("error type");
    }
  }

  private static void printPreOrder(Node node){
    if(node==null){
      return;
    }
    System.out.print(node.getKey());
    printPreOrder(node.getLeft());
    printPreOrder(node.getRight());
  }

  private static void printInOrder(Node node){
    if(node==null){
      return;
    }
    printPreOrder(node.getLeft());
    System.out.print(node.getKey());
    printPreOrder(node.getRight());
  }

  private static void printPostOrder(Node node){
    if(node==null){
      return;
    }
    printPreOrder(node.getLeft());
    printPreOrder(node.getRight());
    System.out.print(node.getKey());
  }

}
