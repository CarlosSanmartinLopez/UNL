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
package Proyecto.Modelo.Arreglos;

import Proyecto.Modelo.Nota;

/**
 * Clase que contiene en un arreglo todas las Notas
 * @author Grupo1
 */
public class NotasArreglo {
    private static NotasArreglo INSTANCIA = null;
    private static final int LIMITE = 3;
    private static  int indice = 0;
    private Nota[] notas;
    
    private NotasArreglo() {
        notas = new Nota[LIMITE];
    }
    
    private static void crearInstancia() {
        if (INSTANCIA == null)
            INSTANCIA = new NotasArreglo();
    }
    
    /**
     * 
     * @return Retorna una INSTANCIA UNICA en toda la ejecucion del programa
     */
    public static NotasArreglo getInstancia() {
        if (INSTANCIA == null)
            crearInstancia();
        
        return INSTANCIA;
    }
    
    public boolean set(Nota nota) {
        if(indice < LIMITE) {
            notas[indice] = nota;
            indice++;
            return true;
        }
        else
            return false;
    }
    
    public Nota get(int indice) {
       return notas[indice];
    }
    
    public Nota[] getTodo() {
       return notas;
    }
    
    public int getDimension() {
        return indice;
    }
}
