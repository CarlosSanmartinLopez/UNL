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

import Proyecto.Modelo.Estudiante;

/**
 * Clase que contiene en un arreglo todos los Estudiantes
 * @author Grupo1
 */
public class EstudiantesArreglo {
    private static EstudiantesArreglo INSTANCIA = null;
    private static final int LIMITE = 3;
    private static  int indice = 0;
    private Estudiante[] estudiantes;
    
    private EstudiantesArreglo() {
        estudiantes = new Estudiante[LIMITE];
    }
    
    private static void crearInstancia() {
        if (INSTANCIA == null) 
            INSTANCIA = new EstudiantesArreglo();
    }
    
    /**
     * 
     * @return Retorna una INSTANCIA UNICA en toda la ejecucion del programa
     */
    public static EstudiantesArreglo getInstancia() {
        if (INSTANCIA == null) 
            crearInstancia();
        
        return INSTANCIA;
    }
    
    public boolean set(Estudiante estudiante) {
        if(indice < LIMITE) {
            estudiantes[indice] = estudiante;
            indice++;
            return true;
        }
        else
            return false;
    }
    
    public Estudiante get(int indice) {
       return estudiantes[indice];
    }
    
    public Estudiante[] getTodo() {
       return estudiantes;
    }
}
