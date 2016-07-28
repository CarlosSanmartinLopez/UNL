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
public class NotaView {
    public void presentarNota(String codigo, String codigoEstudiante, String codigoMateria, double valor) {
        System.out.print("Nota");
            System.out.println("Código: "+codigo);
            System.out.println("Código Estudiante: "+codigoEstudiante);
            System.out.println("Código Materia: "+codigoMateria);
            System.out.println("Valor: "+valor);
    }
}
