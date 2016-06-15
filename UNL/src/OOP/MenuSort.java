/*
 * Copyright (C) 2016 Stelliox.com
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
 * @author Carlos Sanamrtin
 */
public class MenuSort 
{    
    private static Scanner sc;
    private static InputStream in = System.in;
    
    private int op;
    private boolean flag = true;
    
    private static final String BLUE = "\u001B[34m";
    private static final String BLACK = "\u001B[30m";
    private int lim;
    private int[] vector;
    private int[] vectorSort;
    
    public MenuSort()
    {
        sc = new Scanner(in, "ISO-8859-1");
        op = 0;
    }
    
    public static  void viewVector(int[] v)
    {
        for (int w : v) 
        {
            System.out.print("["+BLUE+w+BLACK+"] ");
        }
        System.out.println("");
    }
    
    public int getIntScannerIn()
    {
        while(true)
        {
            try 
            {
                op = sc.nextInt();
                break;
            } catch (Exception e) 
            {
                System.out.println("## DATO ERRONEO ###");
            }
        }
        
        return op;
    }
      
    public void setVector()
    {
        System.out.print("Limite > : ");
        lim = getIntScannerIn();
        vector = new int[lim];

        for (int i = 0; i < vector.length; i++) 
        {
            System.out.print("["+i+"] > ");
            vector[i] = getIntScannerIn();
        }        
    }
    
    public void sortVectorLow()
    {
        int buffer;
        vectorSort = vector;
            for (int i = 0; i < vectorSort.length-1; i++) 
                for (int j = 0; j < vectorSort.length-1; j++) 
                    if(vectorSort[j] > vectorSort[j+1])
                    {
                        buffer = vectorSort[j+1];
                        vectorSort[j+1] = vectorSort[j];
                        vectorSort[j] = buffer;
                    }
            viewVector(vectorSort);
    }
    
    public void sortVectorHigh()
    {
        int buffer;
        vectorSort = vector;
            for (int i = 0; i < vectorSort.length-1; i++) 
                for (int j = 0; j < vectorSort.length-1; j++) 
                    if(vectorSort[j] < vectorSort[j+1])
                    {
                        buffer = vectorSort[j+1];
                        vectorSort[j+1] = vectorSort[j];
                        vectorSort[j] = buffer;                        
                    }       
            viewVector(vectorSort);
    }
    
    public void init()
    {
        while (flag) 
        {            
            System.out.println("Ingresa una de las siguientes opciones");
            System.out.println("1. Ingresar Vector");
            System.out.println("2. Ordenar de Mayor a Menor");
            System.out.println("3. Ordenar de Menor a Mayor");
            System.out.println("3. Ver vector Original");
            System.out.println("5. Salir");
            
            System.out.print("Opción: ");
            
            getIntScannerIn();
            
            switch(op)
            {
                case 1:
                        setVector();
                    break;
                case 2:
                        sortVectorHigh();
                    break;
                case 3:
                        sortVectorLow();
                    break;
                case 4:
                        viewVector(vector);
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
        MenuSort menu = new MenuSort();
        menu.init();
    } 
}
