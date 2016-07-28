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
package Proyecto.Vista;

import Proyecto.Modelo.Estudiante;
import Proyecto.Utilidades.PresentarTexto;

/**
 * Clase que Presenta un objeto de Estudiante
 * @author Grupo1
 */
public class EstudianteVista extends PresentarTexto {
    
    public void presentarSetCodigo() {
        presentarMsjAzul("  Código: ");
    }
    
    public void presentarSetNombres() {
        presentarMsjAzul("  Nombres: ");
    }
    
    public void presentarSetApellidos() {
        presentarMsjAzul("  Apellidos: ");
    }
    
    public void presentarSetCedula() {
        presentarMsjAzul("  Cédula: ");
    }
    
    public void presentarSetParalelo() {
        presentarMsjAzul("  Paralelo: ");
    }
    
    public void presentarSetCarrera() {
        presentarMsjAzul("  Carrera: ");
    }
    
    public void presentarEstudiante(Estudiante estudiante) {
        presentarSetCodigo();
            presentarMsjNegro_LN(estudiante.getCodigo());
            
        presentarSetNombres();
            presentarMsjNegro_LN(estudiante.getNombres());
            
        presentarSetApellidos();
            presentarMsjNegro_LN(estudiante.getApellidos());
            
        presentarSetCedula();
            presentarMsjNegro_LN(estudiante.getCedula());
            
        presentarSetParalelo();
            presentarMsjNegro_LN(estudiante.getParalelo());
            
        presentarSetCarrera();
            presentarMsjNegro_LN(estudiante.getCarrera());
    }
}
