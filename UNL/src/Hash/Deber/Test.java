/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash.Deber;

/**
 *
 * @author Carlos Sanmartin
 */
public class Test 
{
    public static void main(String[] args)
    {
        HashMap hashMap = new HashMap();
        
        hashMap.put("1303753618", "Carl 0");
        hashMap.put("1706172648", "Carl 1");
        hashMap.put("0100967652", "Carl 2");
        hashMap.put("1103037048", "Carl 3");
        hashMap.put("1704997012", "Carl 4");
        hashMap.put("1714818299", "Carl 5");
        hashMap.put("1713627071", "Carl 6");
        hashMap.put("0200982163", "Carl 7");
        hashMap.put("0913537742", "Carl 8");
        hashMap.put("0401197298", "Carl 9");
        hashMap.put("0702648551", "Carl 10");
        hashMap.put("1715241434", "Carl 11");
        hashMap.put("0917385288", "Carl 12");
        hashMap.put("1103756134", "Carl 13");
        hashMap.put("0601646623", "Carl 14");
        hashMap.put("1103201461", "Carl 15");
        hashMap.put("0102051349", "Carl 16");
        hashMap.put("1713580221", "Carl 17");
        hashMap.put("0601899396", "Carl 18");
        hashMap.put("1305267542", "Carl 19");
        hashMap.put("0200562791", "Carl 20");
        hashMap.put("0501675946", "Carl 21");
        hashMap.put("1303292583", "Carl 22");
        hashMap.put("1200984761", "Carl 23");
        hashMap.put("1708706302", "Carl 24");
        hashMap.put("0913056123", "Carl 25");
        hashMap.put("1711453470", "Carl 26");
        hashMap.put("0701396830", "Carl 27");
        hashMap.put("0300907441", "Carl 28");
        hashMap.put("1711402980", "Carl 29");
        
        hashMap.viewTable();
        System.out.println();
        System.out.println("Colisiones Totales -> "+hashMap.count);
        
//        System.out.println(" ");
//        String search = "0401197298";
//        System.out.println(search+" >> "+hashMap.get(search));
    }
}
