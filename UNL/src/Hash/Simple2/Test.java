/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash.Simple2;

/**
 *
 * @author Carlos Sanmartin
 */
public class Test 
{
    public static void main(String[] args)
    {
        HashMap hashMap = new HashMap();
        
        hashMap.put("Marco", 105);
        hashMap.put("José", 35);
        hashMap.put("Juan", 1000);
        
        String nombre = "JUAN";
        
        System.out.println(nombre+" -> "+hashMap.get(nombre));
    }
}
