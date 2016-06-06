/*
 * Copyright (C) 2016 Carlos Sanmartin
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
package OOP;

import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author Carlos Sanmartin
 */
public class MenuMethod
{
    private static Scanner sc;
    private static InputStream in = System.in;
    
    private int op;
    private boolean flag = true;
    private boolean flagSubMenu = true;
    private boolean flagSubMenuInit = false;
    
    private String strA;
    private int intA;
    
    private static final String BLUE = "\u001B[34m";
    private static final String BLACK = "\u001B[30m";
    private int lim;
    
    public MenuMethod()
    {
        sc = new Scanner(in, "ISO-8859-1");
        op = 0;
    }
    
    public static  void viewContent(int intA)
    {
        System.out.print(BLUE+intA+" "+BLACK);
    }
    
    public int getIntScannerIn()
    {
        try 
        {
            op = sc.nextInt();
        } catch (Exception e) 
        {
            op = -1;
        }
        
        return op;
    }
        
    public void controlSubMenu()
    {
        getIntScannerIn();          
            
        switch(op)
        {
            case 1:
                    flagSubMenuInit = true;
                break;
            case 2:
                    flagSubMenu = false;
                    flagSubMenuInit = false;
                break;
            default:
                    flagSubMenuInit = false;
                    System.out.println("### La opción No existe ###");
                    sc.nextLine();
                break;
        }
    }
    public void fibonacci(int l)
    {
        int a = 0, b = 1, c;
        for (int i = 0; i < l; i++) 
        {
            c = a + b;
            a = b;
            b = c;
            viewContent(c);
        }
    }
    
    public void factorial(int l)
    {
        int fac = 1;
        for (int i = 1; i <= l; i++) 
        {
            fac *= i;
        }
        viewContent(fac);
    }
    
    public void primes(int l)
    {
        int p = (int)Math.pow(2,l)+1;
        viewContent(p);
    }
    
    public void pairs(int l)
    {
        int p = 0;
        for (int i = 0; i < l; i++) 
        {
            p += 2;
            viewContent(p);
        }
    }
    
    public void odd(int l)
    {
        int p = -1;
        for (int i = 0; i < l; i++) 
        {
            p += 2;
            viewContent(p);
        }
    }
    
    public void getSubMenu(int op)
    {
        flagSubMenu = true;
        
        while (flagSubMenu) 
        {
            if(flagSubMenuInit)
            {
                System.out.print("Limite > : ");
                lim = getIntScannerIn();
                switch(op)
                {
                    case 1:                        
                        fibonacci(lim);
                        break;                       
                    case 2:                        
                        factorial(lim);
                        break;                       
                    case 3:                        
                        primes(lim);
                        break;                       
                    case 4:                        
                        pairs(lim);
                        break;                       
                    case 5:                        
                        odd(lim);
                        break;                       
                }
            }
            
            System.out.println("Ingresa una de las siguientes opciones");
            System.out.println("1. Ingresar Limite");
            System.out.println("2. SALIR");
            System.out.print("  Opción: ");
            
            controlSubMenu();
        }        
    }
   
    public void init()
    {
        while (flag) 
        {            
            System.out.println("Ingresa una de las siguientes opciones");
            System.out.println("1. Fibonacci");
            System.out.println("2. Factorial");
            System.out.println("3. Primos");
            System.out.println("4. Pares");
            System.out.println("5. Impares");
            System.out.println("6. Salir");
            
            System.out.print("Opción: ");
            
            getIntScannerIn();
            
            switch(op)
            {
                case 1:
                        getSubMenu(1);
                    break;
                case 2:
                        getSubMenu(2);
                    break;
                case 3:
                        getSubMenu(3);
                    break;
                case 4:
                        getSubMenu(4);
                    break;
                case 5:
                        getSubMenu(5);
                    break;
                case 6:
                        flag = false;
                    break;
               default:
                        System.out.println("### La opción No existe ###");
                    break;
            }
        }
    }
    
    public static void main(String[] args)
    {
        MenuMethod menu = new MenuMethod();
        menu.init();
    } 
}
