/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash.Deber2.HASH;

/**
 *
 * @author Carlos Sanmartin
 */
public class Test 
{
    public static void main(String[] args) {
        long TInicio, TFin, tiempo;
        TInicio = System.currentTimeMillis(); 
        
        HashMap hashMap = new HashMap(22);
        
        hashMap.put("0706215738","ARMIJOS BRAVO STEEVEN MICHAEL");
        hashMap.put("1105021131","CARPIO ORTEGA JOSSED EFREN");
        hashMap.put("0705743151","CARRIÓN RAMÍREZ JHONNY FERNANDO");
        hashMap.put("0706195609","CEDEÑO CONDOY MICHAEL ALEXIS");   
        hashMap.put("1105803942","CHAMBA GRANDA JAIME ANDRES");
        hashMap.put("1105993065","COLLAGUAZO CORONEL BRAYAN AUGUSTO");
        hashMap.put("1105077240","JIMENEZ ROA ROSA MARIA");
        hashMap.put("1104665144","LOAIZA PIEDRA PEDRO JOSÉ");
        hashMap.put("1150440558","LOPEZ ROMERO ALEXANDRA PATRICIA");
        hashMap.put("1900826569","LOZANO LOZANO RUBÉN DARÍO");   
        hashMap.put("1104339526","MEDINA DÍAZ PABLO DANILO");
        hashMap.put("1104808413","MENDOZA JAPON JHONY XAVIER");
        hashMap.put("0704458231","MITE YAGUANA JOEL GABRIEL");   
        hashMap.put("1105116899","MOROCHO ABRIGO JHONNY MICHAEL");   
        hashMap.put("1105209397","NAGUA GONZÁLEZ KAREN NATHALÍ");
        hashMap.put("1104955107","RIVERA GUAMAN RAMIRO RENE");
        hashMap.put("1150036844","RIVERA MEDINA SANTIAGO GERMAN");
        hashMap.put("1105234098","ROMERO VEGA RAÚL RAMIRO");   
        hashMap.put("0705643740","SANMARTIN FREIRE EDHISSON ALEXIS");
        hashMap.put("1104271737","SANMARTÍN LÓPEZ CARLOS ANDRÉS");   
        hashMap.put("1150692414","VILLAMAGUA POMA JHULISSA ISABEL");
        hashMap.put("1104787021","VITERI JUMBO JUAN GABRIEL");
        
//        hashMap.viewTable();
//        
//        System.out.println("Colisiones Totales -> "+hashMap.getNumberCollision());
        
//        System.out.println(" ");
        String search = "1104955107";
        System.out.println(search+" >> "+hashMap.get(search));
        
        TFin = System.currentTimeMillis();
        tiempo = TFin - TInicio;
        
        System.out.println("TIEMPO (milisegundos)> "+ tiempo);
    }
}
