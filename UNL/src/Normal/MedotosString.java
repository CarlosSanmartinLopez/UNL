/*
 * Copyright (C) 2016 Carlos Sanmartín
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

package Normal;

/**
 *
 * @author Carlos Sanmartín
 */
public class MedotosString 
{
    public static final String BLUE = "\u001B[34m";
    public static final String BLACK = "\u001B[30m";
   
    public static void Output(String msg,Object result)
    {
        System.out.println(BLACK+msg+" "+BLUE+"'"+result.toString()+"'");
    }
    
    public static void main(String[] args) 
    {
        String nombreCompleto;
        String nombreCompletoDiferente;        
        String concatenacion;        
        String subCadena1;
        String subCadena2;
        String cadenaMayuscula;
        String cadenaMinuscula;
        int longitud;
        int primerCaracter;
        int ultimoCaracter;
        char caracter;
        String[] arregloCadena;
        char[] arregloChar;
        boolean comparacion;
        
        nombreCompleto = "Carlos Andrés Sanmartín López";
            Output("Cadena1:",nombreCompleto);
        nombreCompletoDiferente = "carlos andrés sanmartín lópez";
            Output("Cadena2:",nombreCompletoDiferente);
        
            
        longitud = nombreCompleto.length();        
            Output("Longitud",longitud);
        
        primerCaracter = nombreCompleto.indexOf('L');
            Output("La primera posicion de la letra 'L'(mayuscula) es ",primerCaracter);
            
        ultimoCaracter = nombreCompleto.lastIndexOf('s');
            Output("La ultima posicion de la letra 's' es ",ultimoCaracter);
            
        caracter = nombreCompleto.charAt(4);
            Output("En la posicion 4 se encuentra el caracter",caracter);
        
        subCadena1 = nombreCompleto.substring(7);
            Output("La subcadena comprendida desde la posicion 7 es",subCadena1);
            
        subCadena2 = nombreCompleto.substring(4, 24);
            Output("La subcadena comprendida entre las posiciones 4 y 24 es",subCadena2);
            
        cadenaMayuscula = nombreCompleto.toUpperCase();
            Output("La cadena convertida a mayúsculas es",cadenaMayuscula);
        
        cadenaMinuscula = nombreCompleto.toLowerCase();
            Output("La cadena convertida a minúsculas es",cadenaMinuscula);
            
        comparacion = nombreCompleto.equals(nombreCompletoDiferente);
            Output("El resultado de comparar cadena1 y cadena2 es",comparacion);
            
        comparacion = nombreCompleto.equalsIgnoreCase(nombreCompletoDiferente);
            Output("El resultado de comparar cadena1 y cadena2 sin tomar en cuenta las MAYÚSCULAS es ",comparacion);
            
        Output("La variable 'comparacion' convertida a estring es ", String.valueOf(comparacion));
        
        arregloCadena = nombreCompleto.split(" ");
            Output("La Cadena convertia en un Arreglo String es","");
            for (String palabra : arregloCadena) 
                Output(">",palabra);
            
        arregloChar = nombreCompleto.toCharArray();
            Output("La Cadena convertia en un Arreglo Char es","");
            for (char b : arregloChar)  
                Output(">>", b);
        
        nombreCompletoDiferente = "  "+nombreCompletoDiferente+" ";
        Output("La variable 'Cadena2' concatenada con espacios al principio y final es", nombreCompletoDiferente);
        
        nombreCompletoDiferente = nombreCompletoDiferente.trim();
        Output("La variable 'Cadena2' eliminando los espacios en blanco al principio y al final de la cadena es", nombreCompletoDiferente);
        
        concatenacion = nombreCompleto.concat("-").concat(nombreCompletoDiferente);
        Output("La concatenacion de las variables 'Cadena1' y 'Cadena2' es", concatenacion);
    }   
}
