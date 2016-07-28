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
package Proyecto.Utilidades;

/**
 * Utilidad para Validar el numero de Cédula
 * @author Grupo 1
 */
public class ValidarCedula extends PresentarTexto {
    private static final int[] COEFICIENTE = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2};
    private int RESULTADO = 0, SUMA = 0;
    private static final int NUMERO_PROVINCIAS = 24;
    
    private final String cedula;
    private char[] caracteres;
    
    public ValidarCedula(String cedula) {
        this.cedula = cedula;
    }
    private boolean verificarCedula() {
        if((cedula.length()-1) != COEFICIENTE.length) {
            presentarMsjROJO_LN("La Cédula no contiene de 10 caracteres");
            return false;
        }
        
        if(!cedula.matches("[0-9]*")) {
            presentarMsjROJO_LN("La Cédula contiene caracteres No Numéricos");
            return false;
        }
                        
        int n;
        caracteres = cedula.toCharArray();
        int provincia = Integer.parseInt(String.valueOf(caracteres[0]+""+caracteres[1]));
        
        if(provincia < 1 && provincia > NUMERO_PROVINCIAS) {
            presentarMsjROJO_LN("Cédula NO VALIDA");
            return false;
        }
        
        for (int i = 0; i < COEFICIENTE.length; i++) {
            n = Integer.parseInt(String.valueOf(caracteres[i]));
            RESULTADO = COEFICIENTE[i] * n;
            
            if(RESULTADO >= 10)
                RESULTADO -= 9;
            
            SUMA += RESULTADO;
        }
            
        SUMA = (((SUMA / 10) + 1) * 10) - SUMA;
        if(SUMA == Integer.parseInt(String.valueOf(caracteres[9])))
            return true;
        
        presentarMsjROJO_LN("Cédula NO VALIDA.");
        return false;
    }
    
    public boolean isTrue() {
            return verificarCedula();
    }
}
