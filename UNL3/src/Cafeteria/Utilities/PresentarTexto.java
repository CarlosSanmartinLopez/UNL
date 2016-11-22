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
package Cafeteria.Utilities;

/**
 * Utilidad para presentar una Cadena (String) en diferentes colores
 * @author Grupo1
 */

public class PresentarTexto {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    public static void presentarMsjROJO(String msj) {
        System.out.print(ANSI_RED+msj+ANSI_RESET);
    }    
    public static void presentarMsjROJO_LN(String msj) {
        System.out.println(ANSI_RED+msj+ANSI_RESET);
    }
    
    public static void presentarMsjAzul(String msj) {
        System.out.print(ANSI_BLUE+msj+ANSI_RESET);
    }    
    public static void presentarMsjAzul_LN(String msj) {
        System.out.println(ANSI_BLUE+msj+ANSI_RESET);
    }
    
    public static void presentarMsjNegro(String msj) {
        System.out.print(ANSI_BLACK+msj+ANSI_RESET);
    }    
    public static void presentarMsjNegro_LN(String msj) {
        System.out.println(ANSI_BLACK+msj+ANSI_RESET);
    }
    
    public static void presentarMsjVerde(String msj) {
        System.out.print(ANSI_GREEN+msj+ANSI_RESET);
    }    
    public static void presentarMsjVerde_LN(String msj) {
        System.out.println(ANSI_GREEN+msj+ANSI_RESET);
    }
    
    public static void presentarMsjMORADO(String msj) {
        System.out.print(ANSI_PURPLE+msj+ANSI_RESET);
    }    
    public static void presentarMsjMORADO_LN(String msj) {
        System.out.println(ANSI_PURPLE+msj+ANSI_RESET);
    }
}
