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
public class Test {
    public static void main(String[] args) throws Exception {
        Stack<String> stack = new Stack<>();
            System.out.println(stack.isEmpty());
            
            stack.push("HOLA");
            stack.push("HOLA1");
            stack.push("HOLA2");
            stack.push("HOLA3");
            stack.push("HOLA4");
            
            System.out.println(stack.peek());
            System.out.println(stack.pop());
            System.out.println(stack.peek());
    }
}
