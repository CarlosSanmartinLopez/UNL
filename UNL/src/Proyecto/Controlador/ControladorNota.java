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

import Proyecto.Modelo.Arreglos.NotasArreglo;
import Proyecto.Modelo.Nota;
import Proyecto.Utilidades.LeerTeclado;
import Proyecto.Vista.NotaVista;

/**
 * Clase que gestiona y procesa la comunicación entre el MODELO y la VISTA NOTA
 * @author Grupo1
 */
public class ControladorNota extends LeerTeclado {
    private Nota modelo = new Nota();
    private static final NotaVista vista = new NotaVista();
    private static final NotasArreglo notas = NotasArreglo.getInstancia();
        
    public void setNotaCodigo() {
        vista.presentarSetCodigo();
        modelo.setCodigo(leerCadena());
    }

    public void setNotaCodigoEstudiante(String str) {
        vista.presentarSetCodigoEstudiante();
        modelo.setCodigoEstudiante(str);
        vista.presentarMsjMORADO_LN(modelo.getCodigoEstudiante());
    }

    public void setNotaCodigoMateria(String str) {
        vista.presentarSetCodigoMateria();
        modelo.setCodigoMateria(str);
        vista.presentarMsjMORADO_LN(modelo.getCodigoMateria());
    }

    public void setNotaValor() {
        vista.presentarSetValor();
        modelo.setValor(leerDecimal());
    }
    
    public void guardarNota() {
        if(!notas.set(modelo))
            vista.presentarMsjROJO_LN("No existen campos vacios en el arreglo");
        else
            vista.presentarMsjVerde_LN("Datos Guardados");
    }
    
    public void verNotas() {
        int i = 0;
        for (Nota nota : notas.getTodo()) {
            vista.presentarMsjVerde_LN("["+i+"]");
            
            if(nota != null)
                vista.presentarNota(nota);
            else
                vista.presentarNota(new Nota());
            
            i++;
        }
    }
    
    public void presentarNota() {
        vista.presentarNota(modelo);
    }
    
    /**
     * 
     * @return Retorna (True) si existe la Nota a buscar
     */
    public boolean buscarCod_est_mat(String codEst, String codMat) {
        vista.presentarMsjMORADO_LN("-------------------------");
        boolean bandera = false;
        for (Nota nota : notas.getTodo()) {
            if( nota != null && nota.getCodigoEstudiante().equals(codEst) && nota.getCodigoMateria().equals(codMat)) {
                vista.presentarNota(nota);
                vista.presentarMsjMORADO_LN("-------------------------");
                bandera = true;
            }
        }
        return bandera;
    }
    
    /**
     * 
     * @return Retorna (True) si existe la Nota a buscar
     */
    public boolean buscarNota() {
        vista.presentarSetCodigo();
        String codigo = leerCadena();
        
        for (Nota nota : notas.getTodo()) {
            if( nota != null && nota.getCodigo().equals(codigo)) {
                modelo = nota;
                return true;
            }
        }
        return false;
    }
}
