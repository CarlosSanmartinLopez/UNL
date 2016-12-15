package Tree;


import java.util.LinkedList;
import java.util.Queue;
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
    private int[] values;
    private int weight = 0;
    private int height = 0;
    
    public Tree(int value) {
        root = new Node(value);
        weight++;
        height++;
    }
    
    public Tree() {
        root = null;
    }
        
    private boolean addNode(Node node) {
        int auxHeight = 0;
        if(root == null)
            root = node;
        else {
            Node auxRoot = root;
            auxHeight++;
            do {                
                if(node.getValue() < auxRoot.getValue()) 
                    if (auxRoot.getLeftChild() == null) {
                        auxRoot.setLeftChild(node); 
                        break;
                    }
                    else {
                        auxHeight++;
                        auxRoot = auxRoot.getLeftChild();
                    }
                else
                    if(node.getValue() > auxRoot.getValue())
                        if (auxRoot.getRightChild() == null) {
                            auxRoot.setRightChild(node);
                            break;
                        } 
                        else {
                            auxHeight++;
                            auxRoot = auxRoot.getRightChild();
                        }
                    else
                        return false;
            } while (true);            
        }
        
        weight++;
        auxHeight++;
        
        if(auxHeight > height)
            height = auxHeight;
        
        return true;
    }
    
    private int findHeight(Node node) {
        if(node == null)
            return 0;
        
        int height = 0;
        Node auxNode = node;
        
        Queue<Node> queue = new LinkedList();
        queue.add(auxNode);
        
        while (true) {            
            int count = queue.size();
            if(count > 0) {
                height++;
                
                while (count > 0) {                    
                    Node nd = queue.peek();
                    queue.remove();
                    if(nd.getLeftChild() != null) 
                        queue.add(nd.getLeftChild());
                    if(nd.getRightChild() != null) 
                        queue.add(nd.getRightChild());
                    count--;
                }
            } else
                return height;
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
        boolean flag = false;
        
        if(n == root.getValue()) {
            flag = true;
            if(auxNode.getLeftChild() != null) {
                auxNode = auxNode.getLeftChild();
                while(auxNode.getRightChild() != null)
                    auxNode = auxNode.getRightChild();
            }
            else 
                if(auxNode.getRightChild() != null) {
                    auxNode = auxNode.getRightChild();
                    while(auxNode.getLeftChild() != null) 
                        auxNode = auxNode.getLeftChild(); 
                } else {
                    root = null;
                    weight--;
                    height = findHeight(root);
                    return true;
                }
            
            n = auxNode.getValue();
            auxNode = root;
        }
        
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
        
        if(flag)
            root.setValue(n);
        
        weight--;
        height = findHeight(root);
        return true;
    }
    
    public boolean add(int value) {
        return addNode(new Node(value));
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
        values = new int[weight];
        int i = 0;
        Node auxNode = root;
        Stack<Node> stack = new Stack<Node>();
        
        while (auxNode != null) {            
            stack.push(auxNode);
            auxNode = auxNode.getLeftChild();
        }
        
        while(stack.size() > 0) {
            auxNode = stack.pop();
            values[i] = auxNode.getValue();
            i++;
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
    
    public void lavelOrder() {
        Node auxNode = root;
        
        Queue<Node> queue = new LinkedList();
        queue.add(auxNode);
        
        while (queue.size() > 0) {            
            auxNode = queue.remove();
            System.out.println(auxNode.getValue());
            
            if(auxNode.getLeftChild() != null)
                queue.add(auxNode.getLeftChild());
            
            if(auxNode.getRightChild() != null)
                queue.add(auxNode.getRightChild());
        }
    }
    
    public int getWeight() {
        return weight;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getHeightLeft() {
        if(root != null)
            return findHeight(root.getLeftChild());
        return 0;
    }
    
    public int getHeightRight() {
        if(root != null)
            return findHeight(root.getRightChild());
        return 0;
    }
    
    public int getBalanceFactor() {
        return getHeightLeft()-getHeightRight();
    }
    
    public void balancedByMy() {
        inOrder();
        System.out.println("***");
        int lenghLeft;
        int lenghRight;
        int valuesLeft[];
        int valuesRight[];
        Queue<Integer> queue = new LinkedList<>();
        
        if(values.length % 2 == 0) {
            int l = values.length/2;
            valuesLeft = new int[l-1];
            valuesRight = new int[l];
            queue.add(values[l-1]);
            
            System.arraycopy(values, 0, valuesLeft, 0, valuesLeft.length);
            
            for (int i = 0; i < valuesRight.length; i++) {
                valuesRight[i] = values[l];
                l++;
            }
        } else {
            int l = values.length/2;
            valuesLeft = new int[l];
            valuesRight = new int[l];
            queue.add(values[l]);
            
            System.arraycopy(values, 0, valuesLeft, 0, valuesLeft.length);
            l++;
            for (int i = 0; i < valuesRight.length; i++) {
                valuesRight[i] = values[l];
                l++;
            }
        }
        
        while(valuesLeft.length > 2 || valuesRight.length > 2) {
            int l;
            for (int c : valuesLeft) {
                System.out.print(c+" - ");
            }
            System.out.print(" | ");
            for (int c : valuesRight) {
                System.out.print(c+" - ");
            }
            System.out.println("");
            if(valuesLeft.length > 2) {
                l = valuesLeft.length /2;
//                if(valuesLeft.length % 2 != 0 && valuesLeft.length > 3)
//                    l++;
                queue.add(valuesLeft[l]);
                
                int[] auxValuesLeft = new int[valuesLeft.length-1];
                
                int j = 0;
                for (int i = 0; i < valuesLeft.length; i++) {
                    if(i != (l)) {
                        auxValuesLeft[j] = valuesLeft[i];
                        j++;
                    }
                }
                valuesLeft = auxValuesLeft;
            }
            
            if(valuesRight.length > 2) {
                l = valuesRight.length /2;
//                if(valuesRight.length % 2 != 0 && valuesRight.length > 3)
//                    l++;
                queue.add(valuesRight[l]);
                
                int[] auxValuesRight = new int[valuesRight.length-1];
                
                int j = 0;
                for (int i = 0; i < valuesRight.length; i++) {
                    if(i != (l)) {
                        auxValuesRight[j] = valuesRight[i];
                        j++;
                    }
                }
                valuesRight = auxValuesRight;
            }
        }
        for (int c : valuesLeft) {
            System.out.print(c+" - ");
        }
        System.out.print(" | ");
        for (int c : valuesRight) {
            System.out.print(c+" - ");
        }
        System.out.println("");
        
        root = null;
        for (Integer queue1 : queue) {
            addNode(new Node(queue1));
            System.out.println(queue1);
        }
        
        for (int v : valuesLeft)
            addNode(new Node(v));
        for (int v : valuesRight)
            addNode(new Node(v));
    }
}
