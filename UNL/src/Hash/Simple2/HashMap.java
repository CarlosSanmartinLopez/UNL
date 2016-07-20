/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash.Simple2;

import java.math.BigInteger;

/**
 *
 * @author Carlos Sanmartin
 */
public class HashMap 
{
    private final static int TABLE_SIZE = 32;

    HashEntry[] table;

    HashMap() 
    {
        table = new HashEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
    }

    public int get(String key) 
    {
        int hash = new BigInteger(toAscii(key)).mod(new BigInteger(((Integer)TABLE_SIZE).toString())).intValue();
        
        int c = 0;
        while (table[hash] != null && table[hash].getKey() != key)
        {
            c++;
            if (c > TABLE_SIZE)
                break;
            hash = (hash + 1) % TABLE_SIZE; 
        }
        
        if (table[hash] == null)
            return -1;
        else
            return table[hash].getValue();
    }

    public void put(String key, int value) 
    {
        int hash = new BigInteger(toAscii(key)).mod(new BigInteger(((Integer)TABLE_SIZE).toString())).intValue();
        
        int c = 0;
        while (table[hash] != null && table[hash].getKey() != key)
        {
            c++;
            if (c > TABLE_SIZE)
                break;
            hash = (hash + 1) % TABLE_SIZE; 
        }
        
        table[hash] = new HashEntry(key, value);
    }

    public static String toAscii(String s)
    {
        StringBuilder sb = new StringBuilder();
        long asciiInt;
    
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
              asciiInt = (int)c; 
              sb.append(asciiInt);
        }
        return String.valueOf(sb);
  }
}
