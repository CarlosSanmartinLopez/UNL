/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash.Deber2.BINARIO;


/**
 *
 * @author Carlos Sanmartin
 */

public class Table 
{
    private int TABLE_SIZE;    
    private String ERROR;
    
    Entry[] table;

    public Table(int size) 
    {
        ERROR = "";
        TABLE_SIZE = size;
        table = new Entry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
    }
    
    public void viewTable() {
        int i = 0;
        for (Entry entry : table) {
            System.out.println("["+i+"]");
            try {
                    System.out.println("    -> "+entry.getKey()+" -> "+entry.getValue());
                } catch (Exception e) {
                    System.out.println("  -> null -> null");
                }
            i++;
        }
    }
    
    public String get(String key) 
    {
        int s = search(key);
        if(s < 0)
            return "No existe";
        else
            return table[s].getValue();        
    }
    
    private int i = 0;
    
    public boolean put(String key, String value) 
    {
        if(i < TABLE_SIZE)
            table[i] = new Entry(key, value);
        else
            return false;
        
        i++;
        table = Sort.sort(table);
        return true;
    }
    
    private int search(String key) {
        int n = table.length; 
        int center, inf = 0, sup = n-1; 
        
        while(inf<=sup){ 
            center = (sup+inf)/2; 
            if(table[center].getKey().equals(key)) 
                return center; 
            else 
                if(Integer.parseInt(key) < Integer.parseInt(table[center].getKey())) { 
                    sup = center-1; 
                } 
                else { 
                    inf = center+1; 
                } 
        } 
        return -1;
    }
}
