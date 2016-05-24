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
public class Menu2 
{
    private static Scanner sc;
    private static InputStream in = System.in;
    
    private static int op;
    private static boolean flag = true;
    private static boolean flagSubMenu = true;
    private static boolean flagSubMenuInit = false;
    
    private static String strA;
    
    private static final String BLUE = "\u001B[34m";
    private static final String BLACK = "\u001B[30m";
    
    public Menu2()
    {
        sc = new Scanner(in, "ISO-8859-1");
        op = 0;
    }
    
    public static  void viewString()
    {
        System.out.println(BLUE+strA+BLACK);
    }
        
    public static void viewString(String[] str)
    {
        for (String str1 : str)
            System.out.println(BLUE+str1+BLACK);
    }
    
    public static int getIntScannerIn()
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
    
    public static void controlSubMenu()
    {
        getIntScannerIn();          
            
        switch(op)
        {
            case 1:
            case 2:
                    flagSubMenuInit = true;
                break;
            case 3:
                    flagSubMenu = false;
                    flagSubMenuInit = false;
                break;
            default:
                    flagSubMenuInit = false;
                    System.out.println("### La opción No existe ###");
                break;
        }
    }
            
    public static void getMenuSetString()
    {
        flagSubMenu = true;
        
        while (flagSubMenu) 
        {
            if(flagSubMenuInit)
            {
                sc.nextLine();
                System.out.print("Ingresa la Cadena: ");
                strA = sc.nextLine();
                viewString();
            }
            
            System.out.println("Ingresa una de las siguientes opciones");
            System.out.println("1. Ingresar Palabra o Frase");
            System.out.println("3. SALIR");
            System.out.print("  Opción: ");
            
            controlSubMenu();
        }
        
    }
    public static void getMenuReplaceString()
    {
        flagSubMenu = true;
        
        while (flagSubMenu) 
        {   
            if(flagSubMenuInit)
            {
                String a, b;
                
                sc.nextLine();
                
                System.out.print("Buscar: ");
                    a = sc.nextLine();
                            
                System.out.print("Reemplazo: ");
                    b = sc.nextLine();
                    
                switch(op)
                {
                    case 1:
                            strA = strA.replaceAll(a, b);
                        break;
                    case 2:
                            if(a.length()> 1 || b.length() >1)
                            {
                                System.out.println("Ingresa SOLO un caracter");
                            }
                            else
                            {
                                strA = strA.replace(a.charAt(0), b.charAt(0));
                            }
                        break;
                }
                viewString();
            }
            
            System.out.println("Ingresa una de las siguientes opciones");
            System.out.println("1. Reemplazar Cadena");
            System.out.println("2. Reemplazar Caracter");
            System.out.println("3. SALIR");
            System.out.print("  Opción: ");
            
            controlSubMenu();
        }        
    }
    
    public static void getMenuSeparateString()
    {
        flagSubMenu = true;
        
        while (flagSubMenu) 
        {   
            if(flagSubMenuInit)
            {
                viewString(strA.split(" "));
            }
            
            System.out.println("Ingresa una de las siguientes opciones");
            System.out.println("1. Dividir Cadena");
            System.out.println("3. SALIR");
            System.out.print("  Opción: ");
            
            controlSubMenu();
        }
    }
    
    public static void getMenuConvertString()
    {
        flagSubMenu = true;
        
        while (flagSubMenu) 
        {   
            if(flagSubMenuInit)
            {
                char[] chrStr = strA.toCharArray();
                String strB = "";
                for (int i = chrStr.length-1; i >= 0; i--) 
                {
                    strB += chrStr[i];
                }
                strA = strB;
                viewString();
            }
            
            System.out.println("Ingresa una de las siguientes opciones");
            System.out.println("1. Darle la vuelta a la cadena");
            System.out.println("3. SALIR");
            System.out.print("  Opción: ");
            
            controlSubMenu();            
        }
    }
    
    public static void init()
    {
        while (flag) 
        {            
            System.out.println("Ingresa una de las siguientes opciones");
            System.out.println("1. Ingresar Cadena");
            System.out.println("2. Reemplazar Cadena");
            System.out.println("3. Dividir Cadena");
            System.out.println("4. Convertir Cadena");
            System.out.println("5. Salir");
            
            System.out.print("Opción: ");
            
            getIntScannerIn();
            
            switch(op)
            {
                case 1:
                        getMenuSetString();
                    break;
                case 2:
                        getMenuReplaceString();
                    break;
                case 3:
                        getMenuSeparateString();
                    break;
                case 4:
                        getMenuConvertString();
                    break;
                case 5:
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
        Menu2 menu = new Menu2();
        menu.init();
    } 
}
