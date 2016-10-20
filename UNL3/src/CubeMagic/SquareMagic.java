/*
 * Copyright (C) 2016 Carlos Andres Sanmartín López
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package CubeMagic;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Carlos Andres Sanmartín López
 */
public class SquareMagic {
    private int sum;
    private int median;
    private int[] V;
    private int[][] M;
    
    public SquareMagic(int size) {
        V = new int[size*size];
        M = new int[size][size];
        
        generateV(); 
        sortV();
        
        generateM();
    }
    
    private void generateV() { 
        for (int i = 0; i < V.length; i++) {
            V[i] = i+1;
        } 
    }
    
    private void generateM() {
        int k = 0;
        if(M.length % 2 > 0) {
            int[][] vector = new int[M.length][M.length];
            for (int i = 0; i < M.length; i++) {
                for (int j = 0; j < M[i].length; j++) {
                    vector[i][j] = V[k];
                    k++;
                }            
            }
            
            int diagonals = M.length;
            int x = M.length-1;
            while (diagonals > 0) {    
                for (int i = 0; i < M.length; i++) {
                    for (int j = 0; j < M.length; j++) {
                        if(i == x)
                            M[i][j] = 8;
                    }
                }
                
                diagonals--;
            }
        } else {
            for (int i = 0; i < M.length; i++)
                for (int j = 0; j < M[i].length; j++) {
                    if(i == j)
                        M[M.length-j-1][M.length-i-1] = V[k];
                        if(j == i) {
                            M[M.length-1-i][M.length-1-j] = V[k];
                        }
                        else
                            if((M.length-1-1) == i)
                                M[j][i] = V[k];
                            else
                            M[i][j] = V[k];
                    k++;
                }
        }
    }
       
    private void sortV() {
        Arrays.sort(V);
        median = V[V.length/2];
        sum = 0;
        
        for (int v : V)
            sum += v;
    }
    
    public int getSum() {
        return sum;
    }
    
    public int getMedian() {
        return median;
    }
    
    public void viewV() {
        System.out.println(Arrays.toString(V));
    }
    
    public void viewM() {
        for (int[] m : M)
            System.out.println(Arrays.toString(m));
    }
}
