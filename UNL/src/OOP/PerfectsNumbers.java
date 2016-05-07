/*
 * Copyright (C) 2016 Carlos Sanmartín López
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

import java.util.Scanner;

/**
 *
 * @author Carlos Sanmartín López
 */
public class PerfectsNumbers 
{
    private static long[] n;
    private static long s;
   
    private static int count;
    
    public PerfectsNumbers(int lim)
    {
        n = new long[lim];
        s = 0;
        count = 0;
    }
    
    public static boolean isPerfect(long n)
    {
        if ( n > 5 && n%2==0 )
        {
            s = 0;
            long lim = n/2;
            for (long i = 1; i <= lim; i++)
            {
                System.out.println(lim+"-"+i);
                if(n%i == 0)
                    s += i;
            }            
            if( s == n)
                return true;
            else
                return false;
        }        
        else
            return false;
    }
    
    public static void setArrayNumbers()
    {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n.length; i++) 
        {
            System.out.print("n["+i+"] = ");
            n[i] = sc.nextLong();
        }
    }
    
    public static int getCountPerfects()
    {
        count = 0;
        for (int i = 0; i < n.length; i++) 
        {
            if(isPerfect(n[i]))
                count++;
        }
        return count;
    }
    
    public static void main(String[] args)
    {
        PerfectsNumbers pN = new PerfectsNumbers(4);
        pN.setArrayNumbers();
        System.out.println(pN.getCountPerfects());
    }
    
}
