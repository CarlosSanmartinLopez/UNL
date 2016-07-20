package Persona;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlos Sanmartin
 */
public class Test {
    public static void main(String[] args) {
        Persona[] personas = new Persona[5];
        
        personas[0] = new Persona("Carlos Andrés", "Sanmartin Lopez", 21, "1104141414");
        personas[1] = new Persona("Pedro José", "Loaiza Piedra", 21, "1106525874");
        personas[2] = new Persona("Jhony Fernando", "Carrion L", 20, "0158745856");
        personas[3] = new Persona("Walter Jose", "Mardonado Armijos", 19, "1025878546");
        personas[4] = new Persona("Maria Cristina", "Leiva Gómez", 21, "1198587854");
        
        for (Persona persona : personas) 
        {
            
            System.out.println("Cédula   :  "+persona.getCedula());   
            System.out.println("Nombres  :  "+persona.getNombres());   
            System.out.println("Apellidos:  "+persona.getApellidos());
            System.out.println("Edad     :  "+persona.getEdad());
            System.out.println("--------------------------------------");
            
        }
        
    }
}
