/*
 * Copyright (C) 2016 Carlos Sanmartín
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
 * @author Carlos Sanmartín
 */
public class Matrix 
{
    private int size;
    private double mean;
    private double[][] matrix;
    private double[][] transposedMatrix;
    
    private Scanner sc = new Scanner(System.in);
    private double sum;
    private int count;
    
    public Matrix(int size)
    {
        this.size = size;
        this.matrix = new double[size][size];
    }
    
    public Matrix(double[][] aMatirx)
    {
        this.size = aMatirx.length;
        this.matrix = aMatirx;
    }
    
    public void viewMatrix()
    {
        for (double[] ds : this.matrix) 
        {
            for (double d : ds)
            {
                System.out.print("["+d+"] ");
            }
            System.out.println("");
        }
    }
    
    public void setMatriz()
    {
        for (int i = 0; i < this.matrix.length; i++) 
            for (int j = 0; j < this.matrix.length; j++)
            {
                System.out.print("["+i+j+"] > ");
                this.matrix[i][j] = sc.nextDouble();
            }                
    }
    
    
    public double getMeanDiagonal2()
    {
        this.sum = 0;
        for (int i= 0; i < this.matrix.length; i++) 
            this.sum += this.matrix[i][this.matrix.length-1-i];
                      
        this.mean = this.sum / this.size;
        
        return mean;
    }
    
    public double getMeanAboveDiagonal2()
    {
        this.sum = 0;
        this.count = 0;
        for (int i = 0; i < this.matrix.length-1; i++) 
            for (int j = 0; j < this.matrix.length-1-i; j++) 
            {
                this.count++;
                this.sum += this.matrix[i][j];
            }
                
        this.mean = this.sum / this.count;
        
        return mean;
    }
    
    public double getMeanUnderDiagonal2()
    {
        this.sum = 0;
        this.count = 0;
        for (int i = this.matrix.length-1; i > 0; i--) 
            for (int j = this.matrix.length-1; j > this.matrix.length-1-i; j--) {
                this.count++;
                this.sum += this.matrix[i][j];
            }      
           
        this.mean = this.sum / this.count;
         
        return mean;
    }
    
    public int getMultiplication()
    {
        return 0;
    }
    public void getTransposedMatrix()
    {
        this.transposedMatrix = new double[this.size][this.size];
        
        for (int i = 0; i < this.matrix.length; i++) 
        {
            for (int j = 0; j < 10; j++) 
            {
                this.transposedMatrix[][] = [][];
            }
        }
    }
    
    public static void main(String[] args) 
    {
        double[][] m = new double[4][4];
       
        m[0][0] = 2; 
        m[0][1] = 4; 
        m[0][2] = 6; 
        m[0][3] = 7; 
        
        m[1][0] = 8; 
        m[1][1] = 9; 
        m[1][2] = 10; 
        m[1][3] = 11;
        
        m[2][0] = 12; 
        m[2][1] = 13; 
        m[2][2] = 14; 
        m[2][3] = 15;
        
        m[3][0] = 16; 
        m[3][1] = 17; 
        m[3][2] = 18; 
        m[3][3] = 19;
        
        
        Matrix mx = new Matrix(m);
        //mx.setMatriz();
        mx.viewMatrix();
        
        System.out.println(mx.getMeanUnderDiagonal2());
        
        
    }
}
