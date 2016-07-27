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
package Hash.Deber;

import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author Stelliox.com
 */
public class Init {
    private static final InputStream in = System.in;
    private static Scanner sc;
    private HashMap table;
    
    private boolean flag = true;

    public Init() {
        table = new HashMap(0);
    }
    
    private int readtInt() {
        int op;
        sc = new Scanner(in);
        
        while (true) {            
            try 
            {
                System.out.print(" -> ");
                op = sc.nextInt();
                return op;
            } catch (Exception e) 
            {
                System.out.println("No es un número ENTERO");
                sc.nextLine();
            }        
        }
    }
    
    private String readString() {
        String op;
        sc = new Scanner(in, "ISO-8859-1");
        
        op = sc.nextLine().toUpperCase();
        
        while (op.isEmpty()) { 
            System.out.println("Tienes que completar la información");
            System.out.println("-> ");
            op = sc.nextLine().toUpperCase();
        }
        return op;
    }
    
    private void setSizeTableMenu() {
        System.out.print("Tamaño ");
        table = new HashMap(readtInt());
    }
    
    private void setDataTableMenu() {
        while (flag) {            
            System.out.println("-------Ingresar Datos-------");
            System.out.println("Escoje una opción:");
                System.out.println("1. Ingresar Nuevo Dato");
                
                System.out.println("5. Atras");
                
                switch(readtInt()) {
                    case 1:
                        if(table.getSize() > 0) {
                            System.out.print(" Cédula -> ");
                                String key = readString();
                                
                            System.out.print(" Nombres -> ");
                                String value = readString();
                            
                            if(!table.put(key, value)) {
                                System.out.println(table.getError());;
                            }
                        }
                        else
                            System.out.println("No ingresaste un tamaño para la tabla");
                        break;
                    case 5:
                        flag = false;
                        break;
                    default:
                        System.out.println(" ** LA OPCIÓN NO EXISTE **");
                    break;
                }
        }
        
        flag = true;
    }
    
    private void viewTable() {
        table.viewTable();
    }
    
    private void search() {
        System.out.print("N Cédula -> ");
        System.out.println(table.get(readString()));;
    }
        
    public void mainMenu() {
        while (flag) {            
            System.out.println("-------MENU-------");
            System.out.println("Escoje una opción:");
                System.out.println("1. Ingresar Dimension de la Tabla");
                System.out.println("2. Ingresar Datos (Cédula, Nombres)");
                System.out.println("3. Ver Tabla");
                System.out.println("4. Buscar");
                
                System.out.println("5. SALIR");
                
                switch(readtInt()) {
                    case 1:
                        setSizeTableMenu();
                        break;
                    case 2:
                        setDataTableMenu();
                        break;
                    case 3:
                        viewTable();
                        break;
                    case 4:
                        search();
                        break;
                    case 5:
                        flag = false;
                        break;
                    default:
                        System.out.println(" ** LA OPCIÓN NO EXISTE **");
                    break;
                }
        }
    }
    public static void main(String[] args) {
        Init init = new Init();
        init.mainMenu();
    }
}
