/*
 * Copyright (C) 2016 Carlos Sanmartin
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

package Hash.Simple1;

/**
 *
 * @author Carlos Sanmartin
 */
public class HashMapa 
{
    private static final String BLUE = "\u001B[34m";
    private static final String BLACK = "\u001B[30m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String PURPLE = "\u001B[35m";
    
    private final static int TABLE_SIZE = 8;
    HashEntrada[] table;
    
    HashMapa() 
    {
        table = new HashEntrada[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
    }

    private void viewTable()
    {
        int i = 0;
        for (HashEntrada hashEntrada : table)
        {
            try 
            {
                System.out.println(GREEN+"["+BLACK+i+GREEN+"]"+BLACK+" -> "+hashEntrada.getKey()+" -> "+hashEntrada.getValue());
            } catch (Exception e) 
            {
                System.out.println(RED+"["+i+"] -> null -> null"+BLACK);
            }
            i++;
        }
        System.out.println("-----------------------------");
    }
    
    private void viewTable(int hash)
    {
        int i = 0;
        for (HashEntrada hashEntrada : table)
        {
            try 
            {
                if(table[hash].getKey() != hashEntrada.getKey())
                    System.out.println("["+i+"] -> "+hashEntrada.getKey()+" -> "+hashEntrada.getValue());
                else    
                    System.out.println(RED+"["+BLACK+i+RED+"] -> "+hashEntrada.getKey()+" -> "+hashEntrada.getValue()+BLACK);
            } catch (Exception e) 
            {
                System.out.println("["+i+"] -> null -> null");
            }
            i++;
        }
        System.out.println("-----------------------------");
    }
    
    public int get(int key) 
    {
        int hash = (key % TABLE_SIZE);
        
        System.out.println("Clave a Buscar -> "+key);
        
        int c = 0;
        while (table[hash] != null && table[hash].getKey() != key)
        {
            c++;
            if (c > TABLE_SIZE)
                break;
            hash = (hash + 1) % TABLE_SIZE; 
        }
        System.out.println("HASH -> "+hash);
        
        viewTable(hash);
        if (table[hash] == null)
            return -1;
        else
            return table[hash].getValue();
    }

    public void put(int key, int value) 
    {
        int hash = (key % TABLE_SIZE);
//        System.out.println("Modulo de "+key+" entre "+TABLE_SIZE+" es "+hash);
//        System.out.println("HASH Inicial -> "+hash);
        
//        if(table[hash] != null)
//        {
//            System.out.println("COLISION");
//        }
        
        int c = 0;
        while (table[hash] != null && table[hash].getKey() != key)
        {
            c++;
            if (c > TABLE_SIZE)
                break;
////            System.out.println(hash+"+"+1+"%"+TABLE_SIZE+"="+((hash + 1) % TABLE_SIZE));
            hash = (hash + 1) % TABLE_SIZE;            
        }
        
//        System.out.println("HASH Final -> "+hash);
        
        table[hash] = new HashEntrada(key, value);
//        viewTable();
    }
}
