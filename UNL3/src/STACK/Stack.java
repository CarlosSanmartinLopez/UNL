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
 */
public class Stack<T> {
    LinkedList<T> linkedList = new LinkedList<>();
    
    public void push(T value) {
        linkedList.addLast(value);
    }

    public T pop() throws Exception {
        return linkedList.removeLast();
    }
    
    public T peek() throws Exception {
        return linkedList.getLast();
    }
    
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
