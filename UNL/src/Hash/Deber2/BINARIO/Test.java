/*
 * Copyright (C) 2016 Stelliox.com
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
package Hash.Deber2.BINARIO;

/**
 *
 * @author Stelliox.com
 */
public class Test {
    public static void main(String[] args) {
        long TInicio, TFin, tiempo;
        TInicio = System.currentTimeMillis(); 
        
        Table table = new Table(22);
        
        table.put("0706215738","ARMIJOS BRAVO STEEVEN MICHAEL");
        table.put("1105021131","CARPIO ORTEGA JOSSED EFREN");
        table.put("0705743151","CARRIÓN RAMÍREZ JHONNY FERNANDO");
        table.put("0706195609","CEDEÑO CONDOY MICHAEL ALEXIS");   
        table.put("1105803942","CHAMBA GRANDA JAIME ANDRES");
        table.put("1105993065","COLLAGUAZO CORONEL BRAYAN AUGUSTO");
        table.put("1105077240","JIMENEZ ROA ROSA MARIA");
        table.put("1104665144","LOAIZA PIEDRA PEDRO JOSÉ");
        table.put("1150440558","LOPEZ ROMERO ALEXANDRA PATRICIA");
        table.put("1900826569","LOZANO LOZANO RUBÉN DARÍO");   
        table.put("1104339526","MEDINA DÍAZ PABLO DANILO");
        table.put("1104808413","MENDOZA JAPON JHONY XAVIER");
        table.put("0704458231","MITE YAGUANA JOEL GABRIEL");   
        table.put("1105116899","MOROCHO ABRIGO JHONNY MICHAEL");   
        table.put("1105209397","NAGUA GONZÁLEZ KAREN NATHALÍ");
        table.put("1104955107","RIVERA GUAMAN RAMIRO RENE");
        table.put("1150036844","RIVERA MEDINA SANTIAGO GERMAN");
        table.put("1105234098","ROMERO VEGA RAÚL RAMIRO");   
        table.put("0705643740","SANMARTIN FREIRE EDHISSON ALEXIS");
        table.put("1104271737","SANMARTÍN LÓPEZ CARLOS ANDRÉS");   
        table.put("1150692414","VILLAMAGUA POMA JHULISSA ISABEL");
        table.put("1104787021","VITERI JUMBO JUAN GABRIEL");
        
//        table.viewTable();
        
        String search = "1104955107";
        System.out.println(search+" >> "+table.get(search));
        
        TFin = System.currentTimeMillis();
        tiempo = TFin - TInicio;
        
        System.out.println("TIEMPO (milisegundos)> "+ tiempo);
    }
}
