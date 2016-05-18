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

/**
 *
 * @author Carlos Sanmartín López
 */
public class ArithmeticOperations 
{
    private static int r,A,B;

    public ArithmeticOperations() 
    {
        r = -1;
        A = 0;
        B = 0;
    }
    
    public static void setA(int aA) 
    {
        A = aA;
    }
    
    public static int getA() 
    {
        return A;
    }

    public static void setB(int aB) 
    {
        B = aB;
    }
    
    public static int getB() 
    {
        return B;
    }

    public static void sum() 
    {
        r = A + B;
    }

    public static void subtraction() 
    {
        r = A - B;
    }

    public static void multiplication() 
    {
        r = A * B;
    }

    public static void division() throws ArithmeticException
    {
        r = A / B;
    }

    public static void residue() throws ArithmeticException
    {
        r = A % B;
    }
    
    public static int getR() 
    {
        return r;
    }  
}
