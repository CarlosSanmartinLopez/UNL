/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash.Deber2.HASH;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos Sanmartin
 */

class HashEntryList  extends AbstractList<HashEntry>
{
    private List<HashEntry> list;
    
    public HashEntryList() 
    {
        list = new ArrayList<HashEntry>();
    }
    
    @Override
    public HashEntry get(int i) 
    {
        return list.get(i);
    }

    @Override
    public int size() 
    {
        return list.size();
    }

    @Override
    public boolean add(HashEntry he)
    {
        return list.add(he);
    }
}

public class HashMap 
{
    private int TABLE_SIZE;    
    private String ERROR;
    
    HashEntryList[] table;

    public HashMap(int size) 
    {
        ERROR = "";
        TABLE_SIZE = size;
        table = new HashEntryList[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = new HashEntryList();
    }
    
    public void viewTable() {
        int i = 0;
        for (HashEntryList entryList : table) {
            System.out.println("["+i+"]");
            for (HashEntry entry : entryList) {
                try {
                    System.out.println("    -> "+entry.getKey()+" -> "+entry.getValue());
                } catch (Exception e) {
                    System.out.println("  -> null -> null");
                }
            }
            i++;
        }
        System.out.println("Colisiones TOTALES -> "+countC);
        System.out.println("REGISTROS TOTALES -> "+countR);
    }
    
    public String get(String key) 
    {
        int hash = getHash(key);
        
        for (HashEntry entry : table[hash]) {
            if(entry.getKey().equals(key))
                return entry.getValue();
        }
        
        return "No existe";
    }
    
    private int countC = 0;
    private int countR = 0;
    public boolean put(String key, String value) 
    {
        int hash = getHash(key);
        
        if(countR >= TABLE_SIZE) {
            ERROR = "NO HAY CAMPOS VACIOS";
            return false;
        }
        
        if(table[hash].size() > 0) {
            for (HashEntry hEntry : table[hash]) {
                if(hEntry.getKey().equals(key)) {
                    ERROR = "Ya existe la clave";
                    return false;
                }
            }
            countC++;
        }
        
        countR++;
        table[hash].add(new HashEntry(key, value));
               
        return true;
    }
    
    public int getSize() {
        return TABLE_SIZE;
    }
    
    public int getNumberCollision() {
        return countC;
    }
    
    public int getNumbeRegister() {
        return countR;
    }
    
    public String getError() {
        return ERROR;
    }
    
    private int getHash(String key)
    {
        int hash = (key.hashCode() & 0x7fffffff) % TABLE_SIZE;
        return hash;
    }
}
