/*
 * Copyright (C) 2016 Carlos Sanamrtin
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
    private boolean flagSubMenu = true;
    private boolean flagSubMenuInit = false;
    
    private static final String BLUE = "\u001B[34m";
    private static final String BLACK = "\u001B[30m";
    private int lim, limC;
    private int[] vector;
    private int[][] matrix;
    private int buffer;
    private int rOc;
    
    public enum Array 
    {
        Vector, Matrix 
    }
    
    public enum Sort 
    {
        Low, High 
    }
    
    private Sort sort;
    
    public MenuSort()
    {
        sc = new Scanner(in, "ISO-8859-1");
        op = 0;
        
        vector = new int[]{7,3,1,9,0,5,8,2,6,4};
        matrix = new int[][]{
            {7,3,1,9},
            {8,2,4,6},
            {5,0,10,15}
        };
        rOc = 1;
    }
    
    public static  void viewVector(int[] v)
    {
        for (int w : v) 
        {
            System.out.print("["+BLUE+w+BLACK+"] ");
        }
        System.out.println("");
    }
    
    public static  void viewMatrix(int[][] m)
    {
        for (int[] w : m) 
        {
            for (int h : w) 
            {
                 System.out.print("["+BLUE+h+BLACK+"] ");
            }
           System.out.println("");
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
    
    public void controlSubMenu(int lim)
    {
        getIntScannerIn();          
            
        switch(op)
        {
            case 5:
                    flagSubMenu = false;
                    flagSubMenuInit = false;
                break;
            default:
                    if(op>lim)
                    {
                        flagSubMenuInit = false;
                        System.out.println("### La opción No existe ###");
                        sc.nextLine();
                    }
                    else
                        flagSubMenuInit = true;
                break;
        }
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
    
    public void setMatrix()
    {
        System.out.print("Limite FILAS> : ");
        lim = getIntScannerIn();
        
        System.out.print("Limite COLUMNAS> : ");
        limC = getIntScannerIn();
        
        matrix = new int[lim][limC];

        for (int i = 0; i < matrix.length; i++) 
        {
            for (int j = 0; j < matrix[i].length; j++) 
            {
                System.out.print("["+i+"]["+j+"] > ");
                matrix[i][j] = getIntScannerIn();
            }
        }        
    }
       
    public void setArray(Array type)
    {
        if(type == Array.Vector)
            setVector();
        else
            setMatrix();
    }
    
    public void exchange(Array type)
    {
        
        if(type == Array.Vector)
        {
            int[] vectorSort = vector.clone();
            for (int i = 0; i < vectorSort.length-1; i++) 
                for (int j = 0; j < vectorSort.length-1; j++)
                {
                    if(vectorSort[j] > vectorSort[j+1] && sort == Sort.Low)
                    {
                        buffer = vectorSort[j+1];
                        vectorSort[j+1] = vectorSort[j];
                        vectorSort[j] = buffer;
                        viewVector(vectorSort);
                    }
                    else
                        if(vectorSort[j] < vectorSort[j+1] && sort == Sort.High)
                        {
                            buffer = vectorSort[j+1];
                            vectorSort[j+1] = vectorSort[j];
                            vectorSort[j] = buffer;
                            viewVector(vectorSort);
                        }
                    
                }
        }
        else
        {
            int[][] matrixSort = matrix.clone();
            for (int x = 0; x < matrixSort.length; x++) 
            {
                int[] vectorSort = matrixSort[x].clone();
                for (int i = 0; i < vectorSort.length-1; i++) 
                    for (int j = 0; j < vectorSort.length-1; j++)
                    {
                        if(vectorSort[j] > vectorSort[j+1] && sort == Sort.Low)
                        {
                            buffer = vectorSort[j+1];
                            vectorSort[j+1] = vectorSort[j];
                            vectorSort[j] = buffer;
                            
                            matrixSort[x] = vectorSort;
                            viewMatrix(matrixSort);
                        }
                        else
                            if(vectorSort[j] < vectorSort[j+1] && sort == Sort.High)
                            {
                                buffer = vectorSort[j+1];
                                vectorSort[j+1] = vectorSort[j];
                                vectorSort[j] = buffer;
                                
                                matrixSort[x] = vectorSort;
                                viewMatrix(matrixSort);
                            }

                    }
            }
        }
    }
    
    public void insertion(Array type)
    {
        
        int j;
        if(type == Array.Vector)
        {
            int[] vectorSort = vector.clone();
            for (int i = 1; i < vectorSort.length; i++) 
            {
                int a = vectorSort[i];
                j = i - 1;
                
                while (j >= 0 && vectorSort[j] > a && sort == Sort.Low) 
                {                    
                    vectorSort[j+1] = vectorSort[j];
                    j--;
                }
                
                while (j >= 0 && vectorSort[j] < a && sort == Sort.High) 
                {                    
                    vectorSort[j+1] = vectorSort[j];
                    j--;
                }
                
                vectorSort[j+1] = a;
                viewVector(vectorSort);
            }
        }
        else
        {
            int[][] matrixSort = matrix.clone();
            for (int x = 0; x < matrixSort.length; x++) 
            {
               int[] vectorSort = matrixSort[x].clone();
               for (int i = 1; i < vectorSort.length; i++) 
               {
                   int a = vectorSort[i];
                   j = i - 1;

                   while (j >= 0 && vectorSort[j] > a && sort == Sort.Low) 
                   {                    
                       vectorSort[j+1] = vectorSort[j];
                       j--;
                   }

                   while (j >= 0 && vectorSort[j] < a && sort == Sort.High) 
                   {                    
                       vectorSort[j+1] = vectorSort[j];
                       j--;
                   }

                   vectorSort[j+1] = a;
                   matrixSort[x] = vectorSort;
                   
                   viewMatrix(matrixSort);
               }
               
            }
        }
    }
    
    public void selection(Array type)
    {
        
        int i, menor, pos, tmp;
        if(type == Array.Vector)
        {
            int[] vectorSort = vector.clone();
            for (i = 0; i < vectorSort.length-1; i++) 
            {
                menor = vectorSort[i];
                pos = i;
                
                for (int j = i+1; j < vectorSort.length; j++) 
                {
                    if (vectorSort[j] < menor && sort == Sort.Low) 
                    {
                        menor = vectorSort[j];
                        pos = j;
                    }else
                    if (vectorSort[j] > menor && sort == Sort.High) 
                    {
                        menor = vectorSort[j];
                        pos = j;
                    }   
                }
                if ( pos != i)
                {
                    tmp = vectorSort[i];
                    vectorSort[i] = vectorSort[pos];
                    vectorSort[pos] = tmp;
                }
                viewVector(vectorSort);
            }            
        }
        else
        {
            int[][] matrixSort = matrix.clone();
            for (int x = 0; x < matrixSort.length; x++) 
            {
                int[] vectorSort = matrixSort[x].clone();
                for (i = 0; i < vectorSort.length-1; i++) 
                {
                    menor = vectorSort[i];
                    pos = i;

                    for (int j = i+1; j < vectorSort.length; j++) 
                    {
                        if (vectorSort[j] < menor && sort == Sort.Low) 
                        {
                            menor = vectorSort[j];
                            pos = j;
                        }else
                        if (vectorSort[j] > menor && sort == Sort.High) 
                        {
                            menor = vectorSort[j];
                            pos = j;
                        }   
                    }
                    if ( pos != i)
                    {
                        tmp = vectorSort[i];
                        vectorSort[i] = vectorSort[pos];
                        vectorSort[pos] = tmp;
                    }
                    matrixSort[x] = vectorSort;
                    viewMatrix(matrixSort);
                }
            }         
        }
    }
    
    public void menu3(Array type)
    {
        while (true) 
        {   
            System.out.println("Elige uno de los siguientes Metodos");
            System.out.println("1. Intercambio");
            System.out.println("2. Selección");
            System.out.println("3. Inserción");
            
            System.out.println("5. SALIR");
            
            getIntScannerIn();
            
            if(op == 5)
                break;
            else
            {   if(op == 1)
                    exchange(type);
                else
                if(op == 2)
                    selection(type);
                else
                if(op == 3)
                    insertion(type);
            }
                
        }
    }
    
    public void menu2(Array type)
    {
        flagSubMenu = true;
        
        while (flagSubMenu) 
        {
            if(flagSubMenuInit)
            {
                switch(op)
                {
                    case 1:
                        setArray(type);
                        break;
                    case 2:
                    case 3:
                        if(op == 2)
                            sort = Sort.Low;
                        else
                            sort = Sort.High;
                        
                        
                        menu3(type);
                        break;
                }
            }
            
            System.out.println("Ingresa una de las siguientes opciones");
            System.out.println("1. Ingresar");
            System.out.println("2. Ordenar de Menor a Mayor");
            System.out.println("3. Ordenar de Mayor a Menor");
            
            System.out.println("5. SALIR");
            System.out.print("  Opción: ");
            
            controlSubMenu(3);
        } 
    }
    
    public void init()
    {
        while (flag) 
        {            
            System.out.println("Ingresa una de las siguientes opciones");
            System.out.println("1. Vector");
            System.out.println("2. Martiz");
            System.out.println("5. Salir");
            
            System.out.print("Opción: ");
            
            getIntScannerIn();
            
            switch(op)
            {
                case 1:
                        menu2(Array.Vector);
                    break;
                case 2:
                        menu2(Array.Matrix);
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
