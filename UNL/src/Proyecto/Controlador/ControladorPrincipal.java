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

import Proyecto.Utilidades.LeerTeclado;

/**
 *
 * @author Grupo1
 */
public class ControladorPrincipal extends LeerTeclado {
    private boolean bandera = true;
    private ControladorEstudiante controladorEstudiante;
    private ControladorMateria controladorMateria;
    private ControladorNota controladorNota;
    
    private void verEstudiantes() {
        controladorEstudiante = new ControladorEstudiante();
        while(bandera) {
            presentarMsjNegro_LN("-----VER ESTUDIANTES-----");
            presentarMsjNegro_LN("1. Todos");
            presentarMsjNegro_LN("2. Buscar por Cédula");
            presentarMsjNegro_LN("5. ATRAS");

            switch(leerEntero()) {
                case 1:
                    controladorEstudiante.verEstudiantes();
                    break;
                case 2:
                    if(controladorEstudiante.buscarEstudiante())
                        controladorEstudiante.presentarEstudiante();
                    else
                        controladorEstudiante.presentarMsjROJO_LN("No Existe");
                    break;
                case 5:
                    bandera = false;
                    break;
                default:
                    presentarMsjROJO_LN(" LA OPCIÓN NO EXISTE");
                    break;
            }
        }
        bandera = true;
    }
    
    private void verMaterias() {
        controladorMateria = new ControladorMateria();
        while (bandera) {            
            presentarMsjNegro_LN("-----VER MATERIAS-----");
            presentarMsjNegro_LN("1. Todas");
            presentarMsjNegro_LN("2. Buscar por Código");
            presentarMsjNegro_LN("5. ATRAS");

            switch(leerEntero()) {
                case 1:
                    controladorMateria.verMaterias();
                    break;
                case 2:
                    if(controladorMateria.buscarMateria())
                        controladorMateria.presentarMateria();
                    else
                        controladorMateria.presentarMsjROJO_LN("No Existe");
                    break;
                case 5:
                    bandera = false;
                    break;
                default:
                    presentarMsjROJO_LN(" LA OPCIÓN NO EXISTE");
                    break;
            }
        }
        bandera = true;
    }
    
    private void verNotas() {
        controladorNota = new ControladorNota();
        while (bandera) {            
            presentarMsjNegro_LN("-----VER NOTAS-----");
            presentarMsjNegro_LN("1. Todo");
            presentarMsjNegro_LN("2. Seleccionar Estudiante-Materia");
            presentarMsjNegro_LN("3. Buscar por Código");
            presentarMsjNegro_LN("5. ATRAS");

            switch(leerEntero()) {
                case 1:
                    controladorNota.verNotas();
                    break;
                case 2:
                    controladorEstudiante = new ControladorEstudiante();
                    controladorMateria = new ControladorMateria();

                    if(controladorEstudiante.seleccionarEstudiante() && controladorMateria.seleccionarMateria()) {
                        controladorNota.setNotaCodigoEstudiante(controladorEstudiante.getEstudianteSeleccionado().getCodigo());
                        controladorNota.setNotaCodigoMateria(controladorMateria.getMateriaSeleccionado().getCodigo());
                        if(!controladorNota.buscarCod_est_mat(controladorEstudiante.getEstudianteSeleccionado().getCodigo(),
                                controladorMateria.getMateriaSeleccionado().getCodigo()))
                            controladorNota.presentarMsjROJO_LN("No Existen Notas");                        
                    }
                    break;
                case 3:
                    if(controladorNota.buscarNota())
                        controladorNota.presentarNota();
                    else
                        controladorNota.presentarMsjROJO_LN("No Existe");
                    break;
                case 5:
                    bandera = false;
                    break;
                default:
                    presentarMsjROJO_LN(" LA OPCIÓN NO EXISTE");
                    break;
            }
        }
        bandera = true;
    }
    
    private void verInformacion() {
        while (bandera) {    
            presentarMsjNegro_LN("-----VER-----");
            presentarMsjNegro_LN("1. Estudiante");
            presentarMsjNegro_LN("2. Materia");
            presentarMsjNegro_LN("3. Nota");
            presentarMsjNegro_LN("5. ATRAS");

            switch(leerEntero()) {
                case 1:
                    verEstudiantes();
                    break;
                case 2:
                    verMaterias();
                    break;
                case 3:
                    verNotas();
                    break;
                case 5:
                    bandera = false;
                    break;
                default:
                    presentarMsjROJO_LN(" LA OPCIÓN NO EXISTE");
                    break;
            }
        }
        bandera = true;
    }
    
    private void ingresarInformacion() {
        while (bandera) {
            presentarMsjNegro_LN("----INGRESAR----");
            presentarMsjNegro_LN("1. Estudiante");
            presentarMsjNegro_LN("2. Materia");
            presentarMsjNegro_LN("3. Nota");
            presentarMsjNegro_LN("5. ATRAS");

            switch(leerEntero()) {
                case 1:
                    controladorEstudiante = new ControladorEstudiante();

                    controladorEstudiante.setEstudianteCodigo();
                    controladorEstudiante.setEstudianteNombres();
                    controladorEstudiante.setEstudianteApellidos();
                    controladorEstudiante.setEstudianteCedula();
                    controladorEstudiante.setEstudianteParalelo();
                    controladorEstudiante.setEstudianteCarrera();
                    controladorEstudiante.guardarEstudiante();
                    break;
                case 2:
                    controladorMateria = new ControladorMateria();

                    controladorMateria.setMateriaCodigo();
                    controladorMateria.setMateriaDescripcion();
                    controladorMateria.setMateriaCreditos();
                    controladorMateria.guardarMateria();
                    break;
                case 3:
                    controladorNota = new ControladorNota();
                        
                        controladorEstudiante = new ControladorEstudiante();
                        controladorMateria = new ControladorMateria();
                        
                        if(controladorEstudiante.seleccionarEstudiante() && controladorMateria.seleccionarMateria()) {
                            controladorNota.setNotaCodigoEstudiante(controladorEstudiante.getEstudianteSeleccionado().getCodigo());
                            controladorNota.setNotaCodigoMateria(controladorMateria.getMateriaSeleccionado().getCodigo());
                            controladorNota.setNotaCodigo();
                            controladorNota.setNotaValor();
                            controladorNota.guardarNota();
                        }
                    break;
                case 5:
                        bandera = false;
                    break;
                default:
                        presentarMsjROJO_LN(" LA OPCIÓN NO EXISTE");
                    break;
            }
        }
        bandera = true;
    }
    
    public void init() {
        while (bandera) {            
            presentarMsjNegro_LN("-------MENU-------");
            presentarMsjNegro_LN("Escoje una opción:");
                presentarMsjNegro_LN("1. Ver Información");
                presentarMsjNegro_LN("2. Ingresar Información");
                presentarMsjNegro_LN("5. SALIR");
                
            switch(leerEntero()) {
                case 1:
                    verInformacion();
                    break;
                case 2:
                    ingresarInformacion();
                    break;
                case 5:
                    bandera = false;
                    break;
                default:
                    presentarMsjROJO_LN(" LA OPCIÓN NO EXISTE");
                break;
            }
        }
    }
}
