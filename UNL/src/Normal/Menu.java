/*
 * Copyright (C) 2016 Carlos Sanmartín López
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

package Normal;

import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author Carlos Sanmartín López
 */
public class Menu 
{
    public static void main(String[] args) 
    {
        boolean flagMenu = true;
        boolean flagSubMenu = true;
        boolean flagFactor = false;
        
        int op; // opcion
        
        InputStream in = System.in;
        
        Scanner sc = new Scanner(in,"ISO-8859-1");
        
        while (flagMenu) 
        {            
            System.out.println("--------------------------------------------");
            System.out.println("Ingresa una de las siguientes opciones");
            System.out.println("1. Datos Personales");
            System.out.println("2. Operaciones Matemáticas");
            System.out.println("3. Tabla de Multiplicar");
            System.out.println("4. Salir");
            
            System.out.print("Opcion: ");
            try 
            {
                op = sc.nextInt();
            } catch (Exception e) 
            {
                op = -1;
            }                        
            switch(op)
            {
                case 1:                    
                    String nombre, apellido, fechaN, tel, dir; 
                    flagSubMenu = true;
                    while (flagSubMenu) 
                    {   
                        sc.nextLine(); // Limpia el buffer1
                        if(flagFactor)
                        {
                            System.out.println("  >Ingresa los siguientes datos");
                            System.out.print("  >Nombres: "); 
                                nombre = sc.nextLine();
                            System.out.print("  >Apellidos: ");
                                apellido = sc.nextLine();
                            System.out.print("  >Fecha de Nacimiento: ");
                                fechaN = sc.nextLine();
                            System.out.print("  >Número de Telefono: ");
                                tel = sc.nextLine();
                            System.out.print("  >Dirección: ");
                                dir = sc.nextLine();

                            System.out.println(" ====== "); 
                            System.out.println(" Te llamas " + nombre + " " + apellido + ".\n" +
                                               " Naciste el " + fechaN + ".\n" +
                                               " Tu número de teléfono es " + tel + " y tu dirección es " + dir);                        
                            System.out.println(" ====== ");
                            
                            System.out.println("");
                                                        
                        }    
                    
                        System.out.println(" >Ingresa una de las siguientes opciones");
                        System.out.println("  1. Ingresar Datos ");
                        System.out.println("  2. Salir");
                        System.out.print("    Opción: ");
                        
                        try 
                        {
                            op = sc.nextInt();
                        } catch (Exception e) 
                        {
                            op = -1;
                        }
                        switch(op)
                        {
                            case 1:
                                flagFactor = true;
                                break;
                            case 2:
                                flagFactor = false;
                                flagSubMenu = false;
                                break;
                            default:
                                flagFactor = false;
                                System.out.println("***No existe la opción****");
                                break;
                        }
                    }                    
                    break;
                case 2:                    
                    int a, b, r = 0; 
                    flagSubMenu = true;
                    while (flagSubMenu) 
                    {   
                        sc.nextLine(); // Limpia el buffer
                        if(flagFactor)
                        {
                            System.out.println("  >Ingresa la operación que deseas realizar");
                            System.out.println("   1. Suma");
                            System.out.println("   2. Resta");
                            System.out.println("   3. Multiplicación");
                            System.out.println("   4. División");
                            System.out.println("   5. Residuo");
                            
                            System.out.print("     Opcion: ");
                                try 
                                {
                                    op = sc.nextInt();
                                } catch (Exception e) 
                                {
                                    op = -1;
                                }
                            
                            System.out.print("      Ingresa el valor de A: ");
                                a = sc.nextInt();
                            System.out.print("      Ingresa el valor de B: ");
                                b = sc.nextInt();
                                
                            switch(op)
                            {
                                case 1:
                                        r = a + b;
                                    break;
                                case 2:
                                        r = a - b;
                                    break;
                                case 3:
                                        r = a * b;                                      
                                    break;
                                case 4:
                                        try 
                                        {
                                            r = a / b;
                                        } 
                                        catch (ArithmeticException e) 
                                        {
                                            System.out.println("****Surguio un error durante la operación****");
                                        }
                                    break;
                                case 5:
                                        try 
                                        {
                                            r = a % b;
                                        } 
                                        catch (ArithmeticException e) 
                                        {
                                            System.out.println("****Surguio un error durante la operación****");
                                        };
                                    break;
                                default:
                                        r = -1;
                                        System.err.println("La opción no existe");
                                    break;
                            }
                            
                            System.out.println("      El resultado es: " + r);
                        }    
                        System.out.println("");
                        System.out.println(" >Ingresa una de las siguientes opciones");
                        System.out.println("  1. Realizar operación ");
                        System.out.println("  2. Salir");
                        System.out.print("    Opción: ");
                        try 
                        {
                            op = sc.nextInt();
                        } catch (Exception e) 
                        {
                            op = -1;
                        }
                        switch(op)
                        {
                            case 1:
                                flagFactor = true;
                                break;
                            case 2:
                                flagFactor = false;
                                flagSubMenu = false;
                                break;
                            default:
                                flagFactor = false;
                                System.out.println("***No existe la opción****");
                                break;
                        }
                    }                    
                    break;
                case 3:                    
                    int n, lim; 
                    flagSubMenu = true;
                    while (flagSubMenu) 
                    {   
                        sc.nextLine(); // Limpia el buffer
                        if(flagFactor)
                        {
                            System.out.print("  >Ingresa el número a multiplicar: ");
                                n = sc.nextInt();
                            
                            System.out.print("  >Ingresa el limite: ");
                                lim = sc.nextInt();
                                
                            for (int i = 1; i <= lim; i++) 
                            {
                                System.out.println(n + " X " + i + " = " + n*i);
                            }                            
                        }    
                        System.out.println("");
                        System.out.println(" >Ingresa una de las siguientes opciones");
                        System.out.println("  1. Generar tabla");
                        System.out.println("  2. Salir");
                        System.out.print("    Opción: ");
                        try 
                        {
                            op = sc.nextInt();
                        } catch (Exception e) 
                        {
                            op = -1;
                        }
                        switch(op)
                        {
                            case 1:
                                flagFactor = true;
                                break;
                            case 2:
                                flagFactor = false;
                                flagSubMenu = false;
                                break;
                            default:
                                flagFactor = false;
                                System.out.println("***No existe la opción****");
                                break;
                        }
                    }                    
                    break;
                case 4:
                        flagMenu = false;
                    break;
                default:
                    System.out.println("***No existe la opción****");
                    break;
            }
        }
    }
}
