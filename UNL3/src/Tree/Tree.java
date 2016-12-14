package Tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author terceroa
 */
public class Tree {
    private Node root;
    
    public Tree(int value) {
        root = new Node(value);
    }
    
    public Tree() {
        root = null;
    }
        
    public void addNode(Node node) {
        if(root == null)
            root = node;
        else {
            Node auxRoot = root;
            do {                
                if(node.getValue() <= auxRoot.getValue()) 
                    if (auxRoot.getLeftChild() == null) {
                        auxRoot.setLeftChild(node); 
                        break;
                    }
                    else
                        auxRoot = auxRoot.getLeftChild();
                else
                    if (auxRoot.getRightChild() == null) {
                        auxRoot.setRightChild(node);
                        break;
                    }
                    else
                        auxRoot = auxRoot.getRightChild();
            } while (true);
            
        }
    }
    
    public Node findNode(int n) {
        Node auxNode = root;
           
        while(auxNode.getValue() != n) {
            if(n <= auxNode.getValue())
                auxNode = auxNode.getLeftChild();
            else
                auxNode = auxNode.getRightChild();
            
            if(auxNode == null)
                break;
        } 
        
        return auxNode;
    }
    
    public boolean deleteNode(int n) {
        Node auxNode = root;
        Node parent = root;
        
        while(auxNode.getValue() != n) {
            parent = auxNode;
            if(n <= auxNode.getValue())
                auxNode = auxNode.getLeftChild();
            else
                auxNode = auxNode.getRightChild();
            
            if(auxNode == null)
               return false;
        } 
        
        if(auxNode.getLeftChild() == null && auxNode.getRightChild() == null ) {
            if(auxNode.getValue() <= parent.getValue())
                parent.setLeftChild(null);
            else
                parent.setRightChild(null);
        } else {
            if(auxNode.getLeftChild() == null) {
                if(auxNode.getValue() <= parent.getValue())
                    parent.setLeftChild(auxNode.getRightChild());
                else
                    parent.setRightChild(auxNode.getRightChild());
            } else {
                if(auxNode.getRightChild() == null) {
                    if(auxNode.getValue() <= parent.getValue())
                        parent.setLeftChild(auxNode.getLeftChild());
                    else
                        parent.setRightChild(auxNode.getLeftChild());
                } else {
                    
                    Node sc = null;
                    Node scP = null;
                    Node current = auxNode.getRightChild();
                    
                    while(current != null) {
                        scP = sc;
                        sc = current;
                        current = current.getLeftChild();
                    }
                    
                    if(sc.getValue() != auxNode.getRightChild().getValue()) {
                        scP.setLeftChild(sc.getRightChild());
                        sc.setRightChild(auxNode.getRightChild());
                    }
                                        
                    sc.setLeftChild(auxNode.getLeftChild());
                    
                    if(auxNode.getValue() <= parent.getValue())
                        parent.setLeftChild(sc);
                    else
                        parent.setRightChild(sc);
                    
                }
            } 
        }
        
        return true;
    }
    
    public void add(int value) {
        addNode(new Node(value));
    }

    public Node getRoot() {
        return root;
    }
    
    public void inOrder(Node node) {
        if(node != null) {
            inOrder(node.getLeftChild());
            System.out.println(node.getValue());
            inOrder(node.getRightChild());
        }
    }
            
    public void inOrder() {
        Node auxNode = root;
        Stack<Node> stack = new Stack<Node>();
        
        while (auxNode != null) {            
            stack.push(auxNode);
            auxNode = auxNode.getLeftChild();
        }
        
        while(stack.size() > 0) {
            auxNode = stack.pop();
            System.out.println(auxNode.getValue());
            
            if(auxNode.getRightChild() != null) {
                auxNode = auxNode.getRightChild();
                
                while(auxNode != null) {
                    stack.push(auxNode);
                    auxNode = auxNode.getLeftChild();
                }
            }
        }
    }
    
    public void preOrder(Node node) {
        if(node != null) {
            System.out.println(node.getValue());
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
    }
    
    public void preOrder() {     
        Node auxNode = root;
        Stack<Node> stack = new Stack<Node>();
        
        stack.push(auxNode);
        
        while(stack.size() > 0) {
            auxNode = stack.pop();
            System.out.println(auxNode.getValue());
            
            if(auxNode.getRightChild() != null)
                stack.push(auxNode.getRightChild());
            
            if(auxNode.getLeftChild() != null)
                stack.push(auxNode.getLeftChild());
            
        }
    }
    
    public void postOrder(Node node) {
        if(node != null) {
            postOrder(node.getLeftChild());
            postOrder(node.getRightChild());
            System.out.println(node.getValue());
        }
    }
    
    public void postOrder() {
        Node auxNode = root;
        Node auxNodepeek;
        Node lastNodeView = null;
        Stack<Node> stack = new Stack<Node>();
        
        while(auxNode != null || !stack.isEmpty()) {
            if(auxNode != null) {
                stack.push(auxNode);
                auxNode = auxNode.getLeftChild();
            } else {
                auxNodepeek = stack.peek();
                if(auxNodepeek.getRightChild() != null &&
                   auxNodepeek.getRightChild() != lastNodeView)
                    auxNode = auxNodepeek.getRightChild();
                else {
                    System.out.println(auxNodepeek.getValue());
                    lastNodeView = stack.pop();
                }
            }
        }
    }
    
    public void balanceo() {
        Node auxNode = root;
        Stack<Node> stack = new Stack<Node>();
        List<Integer> list = new ArrayList<>();
        
        while (auxNode != null) {            
            stack.push(auxNode);
            auxNode = auxNode.getLeftChild();
        }
        
        while(stack.size() > 0) {
            auxNode = stack.pop();
            list.add(auxNode.getValue());
            
            if(auxNode.getRightChild() != null) {
                auxNode = auxNode.getRightChild();
                
                while(auxNode != null) {
                    stack.push(auxNode);
                    auxNode = auxNode.getLeftChild();
                }
            }
        }
    }
}
