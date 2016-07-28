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
package Proyecto.Controlador;

import Proyecto.Modelo.Arreglos.MateriasArreglo;
import Proyecto.Modelo.Listas.MateriasLista;
import Proyecto.Modelo.Materia;
import Proyecto.Utilidades.LeerTeclado;
import Proyecto.Vista.MateriaVista;

/**
 * Clase que gestiona y procesa la comunicación entre el MODELO y la VISTA MATERIA
 * @author Grupo1
 */
public class ControladorMateria extends LeerTeclado {
    private Materia modelo = new Materia();
    private static final MateriaVista vista = new MateriaVista();
    private static final MateriasArreglo materias = MateriasArreglo.getInstancia();

    public void setMateriaCodigo() {
        vista.presentarSetCodigo();
        modelo.setCodigo(leerCadena());
    }

    public void setMateriaDescripcion() {
        vista.presentarSetDescripcion();
        modelo.setDescripcion(leerCadena());
    }

    public void setMateriaCreditos() {
        vista.presentarSetCreditos();
        modelo.setCreditos(leerEntero());
    }
    
    public void guardarMateria() {
        if(!materias.set(modelo))
            vista.presentarMsjROJO_LN("No existen campos vacios en el arreglo");
        else
            vista.presentarMsjVerde_LN("Datos Guardados");
    }
    
    public void verMaterias() {
        int i = 0;
        for (Materia materia : materias.getTodo()) {
            vista.presentarMsjVerde_LN("["+i+"]");
            
            if(materia != null)
                vista.presentarMateria(materia);
            else
                vista.presentarMateria(new Materia());
            
            i++;
        }
    }
    
    public boolean seleccionarMateria() {
        MateriasLista materiaLista = new MateriasLista();
        int i = 0;
        for (Materia materia : materias.getTodo()) {
            if(materia != null) {
                materiaLista.add(materia);
                vista.presentarMsjVerde_LN("["+i+"]");
                vista.presentarMateria(materia);
                i++;
            }
        }
        if(!materiaLista.isEmpty()) {
            while (true) {                
                vista.presentarMsjMORADO("Selecciona una Materia: ");
                try {
                    modelo = materiaLista.get(leerEntero());
                    break;
                } catch (Exception e) {
                    vista.presentarMsjROJO_LN("No Existe la Materia.");
                }
            }
            return true;
        }
        else {
            vista.presentarMsjROJO_LN("No Existen Materias");
            return false;
        }
    }
    
    public void presentarMateria() {
        vista.presentarMateria(modelo);
    }
    /**
     * @return Devuelve la Materia Seleccionado 
     */
    public Materia getMateriaSeleccionado() {
        return modelo;
    }
    
    /**
     * 
     * @return Retorna (True) si existe la Materia a buscar
     */
    public boolean buscarMateria() {
        vista.presentarSetCodigo();
        String codigo = leerCadena();
        
        for (Materia materia: materias.getTodo()) {
            if(materia != null && materia.getCodigo().equals(codigo)) {
                modelo = materia;
                return true;
            }            
        }
        return false;
    }
}
