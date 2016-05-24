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
    private double[][] R;
    
    private Scanner sc = new Scanner(System.in);
    private double sum;
    private int count;
    
    public Matrix(int size)
    {
        this.size = size;
        matrix = new double[size][size];
    }
    
    public Matrix(double[][] matirx)
    {
        size = matirx.length;
        this.matrix = matirx;
    }
    
    public void viewMatrix()
    {
        for (double[] ds : matrix) 
        {
            for (double d : ds)
            {
                System.out.print("["+d+"] ");
            }
            System.out.println("");
        }
    }
    
    public void viewMatrix(double[][] matrix)
    {
        for (double[] ds : matrix) 
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
        for (int i = 0; i < matrix.length; i++) 
            for (int j = 0; j < matrix.length; j++)
            {
                System.out.print("["+i+j+"] > ");
                matrix[i][j] = sc.nextDouble();
            }                
    }
    
    
    public double getMeanDiagonal2()
    {
        sum = 0;
        for (int i= 0; i < matrix.length; i++) 
            sum += matrix[i][matrix.length-1-i];
                      
        mean = sum / size;
        
        return mean;
    }
    
    public double getMeanAboveDiagonal2()
    {
        sum = 0;
        count = 0;
        for (int i = 0; i < matrix.length-1; i++) 
            for (int j = 0; j < matrix.length-1-i; j++) 
            {
                count++;
                sum += matrix[i][j];
            }
                
        mean = sum / count;
        
        return mean;
    }
    
    public double getMeanUnderDiagonal2()
    {
        sum = 0;
        count = 0;
        for (int i = matrix.length-1; i > 0; i--) 
            for (int j = matrix.length-1; j > matrix.length-1-i; j--) 
            {
                count++;
                sum += matrix[i][j];
            }      
           
        mean = sum / count;
         
        return mean;
    }
    
    public double[][] getMultiplication(double[][] matrixB)
    {
        if( (matrix.length != matrixB.length) || (matrix[0].length != matrixB[0].length) )
            throw new RuntimeException("Illegal Matrix Dimensions");
        
        R = new double[size][size];
        
        for (int i = 0; i < matrix.length; i++) 
            for (int j = 0; j < matrix[i].length; j++)
                for (int k = 0; k < matrixB.length; k++) 
                    R[i][j] +=  matrix[i][k]* matrixB[k][j];
        
        return R;
    }
    
    public double[][] getTransposedMatrix()
    {
        R = new double[size][size];
        
        for (int i = 0; i < matrix.length; i++) 
            for (int j = 0; j < matrix[i].length; j++) 
                R[j][i] = matrix[i][j];
            
        return R;
    }
    
    public static void main(String[] args) 
    {
        double[][] A = new double[3][3];
       
        A[0][0] = 2; 
        A[0][1] = 0; 
        A[0][2] = 1; 
        
        A[1][0] = 3; 
        A[1][1] = 0; 
        A[1][2] = 0; 
        
        A[2][0] = 5; 
        A[2][1] = 1; 
        A[2][2] = 1; 
        
        Matrix mx = new Matrix(A);
        
        mx.viewMatrix();
        
        System.out.println(mx.getMeanDiagonal2());
        System.out.println(mx.getMeanAboveDiagonal2());
        System.out.println(mx.getMeanUnderDiagonal2());
          
        double[][] B = new double[3][3];
        B[0][0] = 1; 
        B[0][1] = 0; 
        B[0][2] = 1; 
        
        B[1][0] = 1; 
        B[1][1] = 2; 
        B[1][2] = 1; 
        
        B[2][0] = 1; 
        B[2][1] = 1; 
        B[2][2] = 0; 
        
        mx.viewMatrix(mx.getMultiplication(B));
    }
}
