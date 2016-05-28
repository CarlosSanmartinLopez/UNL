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
public class Menu3
{
    private static Scanner sc;
    private static InputStream in = System.in;
    
    private static int op;
    private static boolean flag = true;
    private static boolean flagSubMenu = true;
    private static boolean flagSubMenuInit = false;
    
    private static String strA;
    private static int intA;
    
    private static final String BLUE = "\u001B[34m";
    private static final String BLACK = "\u001B[30m";
    
    public Menu3()
    {
        sc = new Scanner(in, "ISO-8859-1");
        op = 0;
    }
    
    public static  void viewContent(String strA)
    {
        System.out.println(BLUE+strA+BLACK);
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
    
    public static String getStrScannerIn()
    {
        sc.nextLine();
        
        return sc.nextLine();
    }
    
    public static void controlSubMenu(int lim)
    {
        getIntScannerIn();          
            
        switch(op)
        {
            case 1:
            case 2:
            case 3:
            case 4:
                    if(op>lim)
                        System.out.println("### La opción No existe ###");
                    else
                        flagSubMenuInit = true;
                break;
            case 5:
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
            
    public static void getMenuSetData()
    {
        flagSubMenu = true;
        
        while (flagSubMenu) 
        {
            if(flagSubMenuInit)
            {
                switch(op)
                {
                    case 1:
                        System.out.print("Ingresa la Cadena: ");
                        strA = getStrScannerIn();
                        break;
                    case 2:
                        System.out.print("Ingresa el Número: ");
                        intA = getIntScannerIn();
                        break;
                    case 3:
                        viewContent(strA);
                        break;
                    case 4:
                        viewContent(String.valueOf(intA));
                        break;                        
                }
            }
            
            System.out.println("Ingresa una de las siguientes opciones");
            System.out.println("1. Ingresar Cadena");
            System.out.println("2. Ingresar Número");
            System.out.println("3. Mostrar Cadena");
            System.out.println("4. Mostrar Número");
            System.out.println("5. SALIR");
            System.out.print("  Opción: ");
            
            controlSubMenu(4);
        }        
    }
    
    public static int getLengthString(String str)
    {
        return str.length();
    }
    
    public static String getWord()
    {
        int i = 0;
        
        for (String str : strA.split(" ")) 
        {
            viewContent(i+". "+str);
            i++;
        }
        
        System.out.print("Opción: ");
        
        return strA.split(" ")[getIntScannerIn()];
    }
    
    public static void countWords(String strA)
    {
        for (String str : strA.split(" ")) 
        {
            viewContent(str+" : "+getLengthString(str));
        }
    }
    
    public static void countWords(String strA, int intA)
    {
        for (String str : strA.split(" ")) 
        {
            viewContent(str+" : "+getLengthString(str)+" > "+getLengthString(str)+" + "+intA+" = "+(getLengthString(str)+intA));
        }
    }
    
    public static void countWordsPhrase(String strA)
    {
        int count = 0;
        for (String str : strA.split(" ")) 
            count += str.length();
        
        viewContent(strA+" : "+count);
    }
    
    public static void countWordsPhrase(String strA, int intA)
    {
        int count = 0;
        for (String str : strA.split(" ")) 
            count += str.length();
        
        viewContent(strA+" : "+count+" > "+count+" + "+intA+" = "+(count+intA));
    }
    
    public static void getMenuOperationsString()
    {
        flagSubMenu = true;
        
        while (flagSubMenu) 
        {   
            if(flagSubMenuInit)
            {
                String word;
                switch(op)
                {
                    case 1:
                        countWords(strA);
                        break;
                    case 2:
                        countWords(getWord());
                        break;
                    case 3:
                        word = getStrScannerIn();
                        
                        if (strA.contains(word))
                            countWordsPhrase(word);
                        else
                            viewContent("No existe la frase en la cadena");
                        
                        break;
                }
            }
            
            System.out.println("Ingresa una de las siguientes opciones");
            System.out.println("1. Contar número de letras de cada palabra");
            System.out.println("2. Contar número de letras de una palabra determinada");
            System.out.println("3. Contar número de letras de una frase");
            System.out.println("5. SALIR");
            System.out.print("  Opción: ");
            
            controlSubMenu(3);
        }        
    }
    
    public static void getMenuOperationsNumber()
    {
        flagSubMenu = true;
        
        while (flagSubMenu) 
        {   
            if(flagSubMenuInit)
            {
                switch(op)
                {
                    case 1:
                        countWords(strA, intA);
                        break;
                    case 2:
                        countWords(getWord(), intA);
                        break;
                    case 3:
                        String word = getStrScannerIn();
                        
                        if (strA.contains(word))
                            countWordsPhrase(word,intA);
                        else
                            viewContent("No existe la frase en la cadena");
                        break;
                }
            }
            
            System.out.println("Ingresa una de las siguientes opciones");
            System.out.println("1. Sumar el número con el número de letras de cada palabra");
            System.out.println("2. Sumar el número con el número de letras de una palabra específica");
            System.out.println("3. Sumar el número con el número de letras de una frase");
            System.out.println("5. SALIR");
            System.out.print("  Opción: ");
            
            controlSubMenu(3);
        }
    }
    
    public static void init()
    {
        while (flag) 
        {            
            System.out.println("Ingresa una de las siguientes opciones");
            System.out.println("1. Ingresar Datos");
            System.out.println("2. Operaciones con Cadena");
            System.out.println("3. Operaciones con Números");
            System.out.println("5. Salir");
            
            System.out.print("Opción: ");
            
            getIntScannerIn();
            
            switch(op)
            {
                case 1:
                        getMenuSetData();
                    break;
                case 2:
                        getMenuOperationsString();
                    break;
                case 3:
                        getMenuOperationsNumber();
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
        Menu3 menu = new Menu3();
        menu.init();
    } 
}
