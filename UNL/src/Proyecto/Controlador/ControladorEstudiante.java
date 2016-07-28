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

import Proyecto.Modelo.Arreglos.EstudiantesArreglo;
import Proyecto.Modelo.Estudiante;
import Proyecto.Modelo.Listas.EstudiantesLista;
import Proyecto.Utilidades.LeerTeclado;
import Proyecto.Utilidades.ValidarCedula;
import Proyecto.Vista.EstudianteVista;

/**
 * Clase que gestiona y procesa la comunicación entre el MODELO y la VISTA ESTUDIANTE
 * @author Grupo1
 */
public class ControladorEstudiante extends LeerTeclado {
    private Estudiante modelo = new Estudiante();
    private static final EstudianteVista vista = new EstudianteVista();
    private static final EstudiantesArreglo estudiantes = EstudiantesArreglo.getInstancia();
        
    public void setEstudianteCodigo() {
        vista.presentarSetCodigo();
        modelo.setCodigo(leerCadena());
    }
    
    public void setEstudianteNombres() {
        vista.presentarSetNombres();
        modelo.setNombres(leerCadena());
    }
    
    public void setEstudianteApellidos() {
        vista.presentarSetApellidos();
        modelo.setApellidos(leerCadena());
    }
    
    public void setEstudianteCedula() {        
        ValidarCedula validar;
        do {
            vista.presentarSetCedula();
            modelo.setCedula(leerCadena());
            
            validar = new ValidarCedula(modelo.getCedula());
            
        } while (!validar.isTrue());
    }
    
    public void setEstudianteParalelo() {
        vista.presentarSetParalelo();
        modelo.setParalelo(leerCadena());
    }
    
    public void setEstudianteCarrera() {
        vista.presentarSetCarrera();
        modelo.setCarrera(leerCadena());
    }
    
    public void guardarEstudiante() {
        if(!estudiantes.set(modelo))
            vista.presentarMsjROJO_LN("No existen campos vacios en el arreglo");
        else
            vista.presentarMsjVerde_LN("Datos Guardados");
    }
    
    public void verEstudiantes() {
        int i = 0;
        for (Estudiante estudiante : estudiantes.getTodo()) {
            vista.presentarMsjVerde_LN("["+i+"]");
            
            if(estudiante != null)
                vista.presentarEstudiante(estudiante);
            else
                vista.presentarEstudiante(new Estudiante());
            
            i++;
        }
    }
    
    public boolean seleccionarEstudiante() {
        EstudiantesLista estudianteLista = new EstudiantesLista();
        int i = 0;
        for (Estudiante estudiante : estudiantes.getTodo()) {
            if(estudiante != null) {
                estudianteLista.add(estudiante);
                vista.presentarMsjVerde_LN("["+i+"]");
                vista.presentarEstudiante(estudiante);
                i++;
            }
        }
        if(!estudianteLista.isEmpty()) {
            while (true) {                
                vista.presentarMsjMORADO("Selecciona un Estudiante: ");
                try {
                    modelo = estudianteLista.get(leerEntero());
                    break;
                } catch (Exception e) {
                    vista.presentarMsjROJO_LN("No Existe el Estudiante.");
                }
            }
            return true;
        }
        else {
            vista.presentarMsjROJO_LN("No Existen Estudiantes");
            return false;
        }
    }
    public void presentarEstudiante() {
        vista.presentarEstudiante(modelo);
    }
    
    /**
     * @return Devuelve el Estudiante Seleccionado 
     */
    public Estudiante getEstudianteSeleccionado() {
        return modelo;
    }
    
    /**
     * 
     * @return Retorna (True) en caso de encontrar el Estudiante
     */
    public boolean buscarEstudiante() {
        vista.presentarSetCedula();
        String cedula =  leerCadena();
        
        for (Estudiante estudiante : estudiantes.getTodo()) {
            if(estudiante != null && estudiante.getCedula().equals(cedula)) {
                modelo = estudiante;
                return true;
            }
        }
        return false;
    }
}
