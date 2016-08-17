/*
 * Copyright (C) 2016 2do A Programacion
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */


/**
 *
 * @author 2do A Programacion
 */
package Estructura;
import java.util.Scanner;

/**
 *
 * @author JONAS
 */
public class Stack {
    int[] V;
    int tope;
    
    public Stack(int limite) {
        V = new int[limite];
        tope = -1 ;
    }
    public void ver(){
        for (int i : V) {
            
            System.out.print(i+ " - ");
        }System.out.println("");
    }
    
    public void push(int valor) {
       
        if(tope < (V.length-1) ) {
            tope++;
            V[tope] = valor;  
            
        }
        else 
            System.out.println("La Pila esta llena");
        ver();
    }
    
    public int pop() {
        if(tope >= 0) {
            int aux = V[tope];
            V[tope] = 0; //  aqui en java al ser un Objeto Int no se puede asignar null, entonces le ingresas -1 y decrementas el tope;
            tope--;
            ver();
            return aux;
        }
        ver();
        return 0;
    }
    
    public int peek() {
        if(tope >= 0) {
            return V[tope]; // retorna el valor, pero no elimina
        }
        return 0;
    }
    
    public boolean empty() {
        
        if (V[0] == 0)
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        
        Stack pila = new Stack(5); // le envias el limite del vector
        
        while(flag) {
            System.out.println("1. Ingresar (push)"); // ingresa un elemento en la Pila
            System.out.println("2. Sacar (pop)"); //retorna el ultimo elemento ingresado y lo borra
            System.out.println("3. Ver Ultimo (peek)"); //retorna el ultimo elemento ingresado , pero no lo borra
            System.out.println("4. Comprobar si esta vacia (empty)"); //comprueba si la Pila esta vacia
            System.out.println("5. SALIR");
            
            System.out.print(" >");
            switch(sc.nextInt()) {
                case 1:
                    System.out.print(" Ingresa el valor >");
                    pila.push(sc.nextInt());
                    break;
                case 2:
                    System.out.println(">> "+ pila.pop());
                    break;
                case 3:
                    System.out.println(">> "+ pila.peek()); // aun me falta hacerlo
                    break;
                case 4:
                    if (pila.empty())
                        System.out.println("La PILA esta vacia");
                    else
                        System.out.println("La PILA no esta vacia");
                    break;
                case 5:
                    flag = false;
                    break;
            }
        }
    }    
}
