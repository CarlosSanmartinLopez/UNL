/*
 * Copyright (C) 2016 Stelliox.com
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package STACK;

/**
 *
 * @author Stelliox.com
 * @param <T>
 */
public final class LinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size = 0;
    
    public LinkedList() {
        clear();
    }
    
    public void clear() {
        first = null;
        last = null;
    }
    
    public void addFirst(T t) {
        Node<T> node = new Node<T>(null, t, first);
        if(first != null)
            first.setPrev(node);
        
        first = node;
        
        if(last == null)
            last = node;
        
        size++;
    }
    
    public T getFirst() throws Exception {
        if(first != null)
            return first.getValue();
        throw new Exception();
    }
    
    public T removeFirst() throws Exception {
        if(!isEmpty()) {
            T t = first.getValue();

            first = first.getNext();
            first.setPrev(null);
            size--;

            return t;
        } else
            throw new Exception();
    }
    
    public void addLast(T t) {
        Node<T> node = new Node<T>(last, t, null);
        if(last != null)
            last.setNext(node);
        
        last = node;
        
        if(first == null)
            first = node;
        
        size++;
    }
    
    public T getLast() throws Exception {
        if(last != null)
            return last.getValue();
        throw new Exception();
    }
    
    public T removeLast() throws Exception {
        if(!isEmpty()) {
            T t = last.getValue();

            last = last.getPrev();
            last.setNext(null);
            size--;

            return t;
        } else
            throw new Exception();
    }
    
    public void iterateForward() {
        Node node = first;
        while (node != null) {            
            System.out.println(node.getValue().toString());
            node = node.getNext();
        }
    }
    
    public void iterateBackward() {
        Node node = last;
        while (node != null) {            
            System.out.println(node.getValue().toString());
            node = node.getPrev();
        }
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
}
