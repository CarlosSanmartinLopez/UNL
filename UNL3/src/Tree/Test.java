package Tree;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author terceroa
 */
public class Test {
    public static void main(String[] args) {
        Tree tree = new Tree(8);
            tree.add(3);
            tree.add(10);
            tree.add(1);
            tree.add(6);
            tree.add(14);
            tree.add(4);
            tree.add(7);
            tree.add(13);
            
//        System.out.println(tree.getRoot().getValue());
//        System.out.println("");
//        
//        System.out.println(tree.getRoot().getLeftChild().getValue());
//        System.out.println(tree.getRoot().getRightChild().getValue());
//        System.out.println("");
//        
//        System.out.println(tree.getRoot().getLeftChild().getLeftChild().getValue());
//        System.out.println(tree.getRoot().getLeftChild().getRightChild().getValue());
//        System.out.println("");
//        
//        System.out.println(tree.getRoot().getRightChild().getRightChild().getValue());
//        System.out.println("");
//        
//        System.out.println(tree.getRoot().getLeftChild().getRightChild().getLeftChild().getValue());
//        System.out.println(tree.getRoot().getLeftChild().getRightChild().getRightChild().getValue());
//        System.out.println("");
//        
//        System.out.println(tree.getRoot().getRightChild().getRightChild().getLeftChild().getValue());
//        System.out.println("");
            
//            tree.inOrder(tree.getRoot());
//                System.out.println("-----------");
//            tree.inOrder();
//                System.out.println("-----------");
//            
//            tree.preOrder(tree.getRoot());
//                System.out.println("-----------");    
//            tree.preOrder();
//                System.out.println("-----------");
//            
//            tree.postOrder(tree.getRoot());
//                System.out.println("-----------");
//            tree.postOrder();
//                System.out.println("-----------");
           
//            Node node = tree.findNode(10);
//            if(node != null)
//                System.out.println(node.getValue());
//            else
//                System.out.println(node);
            tree.inOrder(tree.getRoot());
            System.out.println(tree.deleteNode(6));
            tree.inOrder(tree.getRoot());
    }
}
