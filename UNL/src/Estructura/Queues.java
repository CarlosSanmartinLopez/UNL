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
public class Queues {
    int[] V;
    int inicio, indice;
    
    public Queues(int limite) {
        V = new int[limite];
        inicio = 0 ;
       indice = -1;
    }
    public void ver(){
        for (int i : V) {
            
            System.out.print(i+ " - ");
        }System.out.println("");
        System.out.println("INDICE > "+indice);
        System.out.println("INICIO > "+inicio);
    }
    
    public void push(int valor) {
       
        if(indice < (V.length-1) || (indice == (V.length-1))) {
            if((indice == (V.length-1))) {
                indice = -1;
                push(valor);
            }
            else {                
                indice++;
                if(V[indice] == 0)
                    V[indice] = valor; 
            }
        }
        else 
            System.out.println("La Cola esta llena");
        ver();
    }
    public int pop() {
        if(V[inicio] != 0){
            int aux = V[inicio];
            V[inicio] = 0;
            inicio++;
            ver();
            return aux;
        }
        
        ver();
        return 0;
    }
    public int peek() {
        if(inicio >= 0) {
            return V[inicio]; // retorna el valor, pero no elimina
        }
        return 0;
    }
    
    public boolean empty() {
        if(indice > -1)
            if (V[indice] != 0 )
                return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        
        Queues cola = new Queues(5); // le envias el limite del vector
        
        while(flag) {
            System.out.println("1. Ingresar (push)"); // ingresa un elemento en la Pila
            System.out.println("2. Sacar (pop)"); //retorna el ultimo elemento ingresado y lo borra
            System.out.println("3. Ver primer valor (peek)"); //retorna el ultimo elemento ingresado , pero no lo borra
            System.out.println("4. Comprobar si esta vacia (empty)"); //comprueba si la Pila esta vacia
            System.out.println("5. SALIR");
            
            System.out.print(" >");
            switch(sc.nextInt()) {
                case 1:
                    System.out.print(" Ingresa el valor >");
                    cola.push2(sc.nextInt());
                    break;
                case 2:
                    System.out.println(">> "+ cola.pop2());
                    break;
                case 3:
                    System.out.println(">> "+ cola.peek2()); // aun me falta hacerlo
                    break;
                case 4:
                    if (cola.empty2())
                        System.out.println("La COLA esta vacia");
                    else
                        System.out.println("La COLA no esta vacia");
                    break;
                case 5:
                    flag = false;
                    break;
            }
        }
    }
public void push2(int valor) {
        for (int i = 0; i < V.length; i++) {
            if( V[i] == 0 ){
                V[i] =  valor;
                break;
            }
        }
        ver();
    }  
 public int pop2() {
       int aux = V[inicio];
        for (int i = 1; i < V.length; i++) {
            V[i-1] = V[i];
        }
        
        ver();
        return aux;
    }
  public int peek2() {
        return V[0];
    }
   public boolean empty2() {
        
        if (V[indice] == 0)
            return true;
        else
            return false;
    }
}
