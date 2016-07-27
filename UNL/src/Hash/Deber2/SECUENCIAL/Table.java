/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash.Deber2.SECUENCIAL;


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
        for (Entry entry : table) {
            if(entry.getKey().equals(key))
                return entry.getValue();
        }
        
        return "No existe";
    }
    
    private int i = 0;
    
    public boolean put(String key, String value) 
    {
        if(i < TABLE_SIZE)
            table[i] = new Entry(key, value);
        else
            return false;
        
        i++;       
        return true;
    }    
}
