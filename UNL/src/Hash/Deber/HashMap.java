/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash.Deber;

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
    private final static int TABLE_SIZE = 30;

    HashEntryList[] table;

    HashMap() 
    {
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
    }
    
    public String get(String key) 
    {
        int hash = getHash(key);
        
        int c = 0;
        for (HashEntry entry : table[hash]) {
            if(entry.getKey() == key)
                return entry.getValue();
        }
        
        return "Null";
    }
    
    int count = 0;
    public void put(String key, String value) 
    {
        int hash = getHash(key);
        
        boolean flag = true;

        if(table[hash].size() > 0)
            count++;
        
        table[hash].add(new HashEntry(key, value));
    }

    private static int getHash(String key)
    {
        int hash = (key.hashCode() & 0x7fffffff) % TABLE_SIZE;
        return hash;
    }
}
