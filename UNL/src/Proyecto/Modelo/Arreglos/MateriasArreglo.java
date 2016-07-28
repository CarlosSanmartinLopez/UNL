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

import Proyecto.Modelo.Materia;

/**
 * Clase que contiene en un arreglo todas las Materias
 * @author Grupo1
 */
public class MateriasArreglo {
    private static MateriasArreglo INSTANCIA = null;
    private static final int LIMITE = 3;
    private static  int indice = 0;
    private Materia[] materias;
    
    private MateriasArreglo() {
        materias = new Materia[LIMITE];
    }
    
    private static void crearInstancia() {
        if (INSTANCIA == null)
            INSTANCIA = new MateriasArreglo();
    }
    
    /**
     * 
     * @return Retorna una INSTANCIA UNICA en toda la ejecucion del programa
     */
    public static MateriasArreglo getInstancia() {
        if (INSTANCIA == null)
            crearInstancia();
        
        return INSTANCIA;
    }
    
    public boolean set(Materia materia) {
        if(indice < LIMITE) {
            materias[indice] = materia;
            indice++;
            return true;
        }
        else
            return false;
    }
    
    public Materia get(int indice) {
       return materias[indice];
    }
    
    public Materia[] getTodo() {
       return materias;
    }
    
    public int getDimension() {
        return indice;
    }
}
