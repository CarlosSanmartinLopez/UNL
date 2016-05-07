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
package OOP;

import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author Carlos Sanmartín López
 */
public class Menu 
{
    private static Scanner sc;
    private static InputStream in = System.in;
    
    private static int op;
    private static boolean flag = true;
    private static boolean flagSubMenu = true;
    private static boolean flagSubMenuInit = false;
    
    private static PersonalInformation pInfo;
    private static ArithmeticOperations aOp;
    private static MultiplicationTable mTable;
    
    public Menu()
    {
        sc = new Scanner(in, "ISO-8859-1");
        op = 0;
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
                    flagSubMenuInit = true;
                break;
            case 2:
                    flagSubMenu = false;
                    flagSubMenuInit = false;
                break;
            default:
                    flagSubMenuInit = false;
                    System.out.println("### La opción No existe ###");
                break;
        }
    }
            
    public static void getMenuPersonalInformation()
    {
        flagSubMenu = true;
        
        while (flagSubMenu) 
        {
            if(flagSubMenuInit)
            {
                sc.nextLine();
                        
                pInfo = new PersonalInformation();
                System.out.println("  Ingresa los Siguientes Datos");        
                System.out.print("      Nombres: ");
                    pInfo.setStrName(sc.nextLine());
                System.out.print("      Apellidos: ");
                    pInfo.setStrSurname(sc.nextLine());
                System.out.print("      Fecha de Nacimiento (dd-mm-aaaa): ");
                    pInfo.setStrBirthDate(sc.nextLine());
                System.out.print("      Cédula: ");
                    pInfo.setStrID(sc.nextLine());
                System.out.print("      Teléfono: ");
                    pInfo.setStrPhone(sc.nextLine());
                System.out.print("      Dirección: ");
                    pInfo.setStrAddress(sc.nextLine());
                System.out.print("      Celular: ");
                    pInfo.setStrCellPhone(sc.nextLine());

                    System.out.println(pInfo.getStrInfo());
            }
            
            System.out.println("Ingresa una de las siguientes opciones");
            System.out.println("1. Ingresar Datos");
            System.out.println("2. SALIR");
            System.out.print("  Opción: ");
            
            controlSubMenu();
        }
        
    }
    public static void getArithmeticOperations()
    {
        flagSubMenu = true;
        
        while (flagSubMenu) 
        {   
            if(flagSubMenuInit)
            {
                System.out.println("   Ingresa la operación que deseas realizar");
                System.out.println("   1. Suma");
                System.out.println("   2. Resta");
                System.out.println("   3. Multiplicación");
                System.out.println("   4. División");
                System.out.println("   5. Residuo");
                System.out.println("   6. SALIR");
                System.out.print("      Opción: ");

                getIntScannerIn();
                 
                aOp = new ArithmeticOperations();            
                if(op !=6 )
                {
                    System.out.print("        Ingresa el valor de A: ");
                        aOp.setA(sc.nextInt());
                    System.out.print("        Ingresa el valor de B: ");
                        aOp.setB(sc.nextInt());
                }

                switch(op)
                {
                    case 1:
                            aOp.sum();
                        break;
                    case 2:
                            aOp.subtraction();
                        break;
                    case 3:
                            aOp.multiplication();
                        break;
                    case 4:
                            try 
                            {
                                aOp.division();
                            } catch (ArithmeticException e) 
                            {
                                System.out.println("*** Error al realizar la Operación **");
                            }                            
                        break;
                    case 5:
                            try 
                            {
                                aOp.residue();
                            } catch (ArithmeticException e) 
                            {
                                System.out.println("*** Error al realizar la Operación **");
                            } 
                        break;
                    case 6:
                            flagSubMenu = false;
                        break;
                    default:
                            System.out.println("### La opción No existe ###");
                        break;
                }

                if(op !=6 )
                    System.out.println("        El resultado es: "+aOp.getR()); 
            }
            
            System.out.println("Ingresa una de las siguientes opciones");
            System.out.println("1. Realizar Operación");
            System.out.println("2. SALIR");
            System.out.print("  Opción: ");
            
            controlSubMenu();
        }        
    }
    
    public static void getMultiplicationTable()
    {
        flagSubMenu = true;
        
        while(flagSubMenu)
        {
            if(flagSubMenuInit)
            {
                mTable = new MultiplicationTable();
        
                System.out.print("   Ingresa el número a multiplicar: ");
                    mTable.setN(sc.nextInt());
                System.out.print("   Ingresa el límite: ");
                    mTable.setLim(sc.nextInt());

                System.out.println(mTable.getTable());

                System.out.println("Ingresa una de las siguientes opciones");
                    System.out.println("1. Ingresar Datos Nuevamente");
                    System.out.println("2. SALIR");
                    System.out.print("  Opción: ");

            }
            
            System.out.println("Ingresa una de las siguientes opciones");
            System.out.println("1. Generar Tabla");
            System.out.println("2. SALIR");
            System.out.print("  Opción: ");
            
            controlSubMenu();
        } 
    }
    
    public static void init()
    {
        while (flag) 
        {            
            System.out.println("Ingresa una de las siguientes opciones");
            System.out.println("1. Datos Personales");
            System.out.println("2. Operaciones Matemáticas");
            System.out.println("3. Tabla de Multiplicar");
            System.out.println("4. Salir");
            
            System.out.print("Opción: ");
            
            getIntScannerIn();
            
            switch(op)
            {
                case 1:
                        getMenuPersonalInformation();
                    break;
                case 2:
                        getArithmeticOperations();
                    break;
                case 3:
                        getMultiplicationTable();
                    break;
                case 4:
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
        Menu menu = new Menu();
        menu.init();
    }
}
