/*
 * Copyright (C) 2016 Grupo1
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
package Proyecto.Utilidades;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Utilidad para leer el teclado
 * @author Grupo1
 */
public class LeerTeclado extends PresentarTexto {
    
    private static final InputStream in = System.in;
    private static Scanner sc;
    
    /**
     * 
     * @return Devuelve un valor Entero (int)
     */
    public int leerEntero() {
        int op;
        sc = new Scanner(in);
        
        while (true) {            
            try 
            {
                presentarMsjROJO(" -> ");
                op = sc.nextInt();
                return op;
            } catch (Exception e) 
            {
                presentarMsjROJO_LN("No es un número ENTERO");
                sc.nextLine();
            }        
        }
    }
    
    /**
     * 
     * @return Devuelve un valor Decimal (double)
     */
    public double leerDecimal() {
        double op;
        sc = new Scanner(in);
        
        while (true) {            
            try 
            {
                presentarMsjROJO(" -> ");
                op = sc.nextDouble();
                return op;
            } catch (Exception e) 
            {
                presentarMsjROJO_LN("No es un Decimal");
                sc.nextLine();
            }        
        }
    }
    
     /**
     * 
     * @return Devuelve una Cadena (String)
     */
    public String leerCadena() {
        String op;
        sc = new Scanner(in, "ISO-8859-1");
        
        op = sc.nextLine().toUpperCase();
        
        while (op.isEmpty()) { 
            presentarMsjROJO_LN("Tienes que completar la información");
            presentarMsjROJO("-> ");
            op = sc.nextLine().toUpperCase();
        }
        return op;
    }
    
}
