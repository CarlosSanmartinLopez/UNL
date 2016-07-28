/*
 * Copyright (C) 2016 2do A Programacion
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
package Proyecto.Vista;

/**
 *
 * @author 2do A Programacion
 */
public class EstudianteView {
    public void presentarEstudiante(String codigo, String nombres, String apellidos, String cedula, String paralelo, String carrera) {
        System.out.println("Estudiante");
            System.out.println("Codigo: "+codigo);
            System.out.println("Nombres: "+nombres);
            System.out.println("Apellidos: "+apellidos);
            System.out.println("Cedula: "+cedula);
            System.out.println("Paralelo: "+paralelo);
            System.out.println("Carrera: "+carrera);
    }
}
