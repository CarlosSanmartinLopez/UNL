/*
 * Copyright (C) 2016 Stelliox.com
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
package OOP;

/**
 *
 * @author Carlos
 */
public class Sort 
{
    int[] vector;
    
    public Sort(int[] vector)
    {
        this.vector = vector;
    }
    
    public class Exchange
    {
        int buffer;
        int[] vector;
        int[] vectorSort;
        
        private Exchange(int[] vector)
        {
            this.vector = vector;
        }
        
        public void viewVectorOriginal()
        {
            for (int i : vector) 
                System.out.print("["+i+"] ");
            System.out.println();
        }
        
        public void viewVectorSort()
        {
            for (int n : vectorSort) 
                System.out.print("["+n+"] ");
            
            System.out.println();
        }
        
        public void bubbleSort()
        {
            vectorSort = vector;
            for (int i = 0; i < vectorSort.length-1; i++) 
                for (int j = 0; j < vectorSort.length-1; j++) 
                    if(vectorSort[j] > vectorSort[j+1])
                    {
                        buffer = vectorSort[j+1];
                        vectorSort[j+1] = vectorSort[j];
                        vectorSort[j] = buffer;
                        viewVectorSort();
                    }
        }
        public void coctailSort()
        {
            boolean flag = true;
            vectorSort = vector;
            do 
            {
                flag = false;
                for (int j = 0; j < vectorSort.length-2; j++) 
                    if(vectorSort[j] > vectorSort[j+1])
                    {
                        buffer = vectorSort[j+1];
                        vectorSort[j+1] = vectorSort[j];
                        vectorSort[j] = buffer;
                        viewVectorSort();
                        flag = true;
                    }
                if (!flag)
                    break;
                
                flag = false;
                for (int y = vectorSort.length-2; y >= 0; y--) 
                    if(vectorSort[y] > vectorSort[y+1])
                    {
                        buffer = vectorSort[y+1];
                        vectorSort[y+1] = vectorSort[y];
                        vectorSort[y] = buffer;
                        viewVectorSort();
                        flag = true;
                    }
                
            } while (flag);
            
        }
    }
    
    public class Insertion
    {}
    
    public class Selection
    {}
    
    public Exchange exchange()
    {
        return new Exchange(vector);
    }
}
