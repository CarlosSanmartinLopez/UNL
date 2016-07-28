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

import Proyecto.Modelo.Nota;
import Proyecto.Utilidades.PresentarTexto;

/**
 * Clase que Presenta un objeto de Nota
 * @author Grupo1
 */
public class NotaVista extends PresentarTexto {
    
    public void presentarSetCodigo() {
        presentarMsjAzul("Codigo: ");
    }

    public void presentarSetCodigoEstudiante() {
        presentarMsjAzul("Codigo Estudiante: ");
    }

    public void presentarSetCodigoMateria() {
        presentarMsjAzul("Codigo Materia: ");
    }

    public void presentarSetValor() {
        presentarMsjAzul("Valor: ");
    }

    public void presentarNota(Nota nota) {
        presentarSetCodigo();
            presentarMsjNegro_LN(nota.getCodigo());
            
        presentarSetCodigoEstudiante();
            presentarMsjNegro_LN(nota.getCodigoEstudiante());
            
        presentarSetCodigoMateria();
            presentarMsjNegro_LN(nota.getCodigoMateria());
            
        presentarSetValor();
            presentarMsjNegro_LN(String.valueOf(nota.getValor()));
    }
}
