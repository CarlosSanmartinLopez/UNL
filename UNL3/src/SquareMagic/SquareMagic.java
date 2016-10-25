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
package SquareMagic;

import java.util.ArrayList;
import java.util.Arrays; 
import java.util.List;

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
            List<Integer>[] vectorLists = new ArrayList[M.length];
            for (int i = 0; i < M.length; i++) {
                vectorLists[i] = new ArrayList<Integer>();
                for (int j = 0; j < M[i].length; j++) {
                    vectorLists[i].add(V[k]);
                    k++;
                }             
            }
            
            int diagonals = 0;
            
            int x = M.length-1;
            int y = 0;
            int i;
            int j;
            int sf = M.length/2;
            
            int l;
            boolean flagSF = false; 
            
            while (diagonals < M.length) { 
                i = y;
                j = x;
                
                l = sf;
                
                while (i<M.length && j<M.length) {                    
                    M[i][j] = vectorLists[diagonals].get(l); 
                    vectorLists[diagonals].remove(l);
                    i++;
                    j++;
                }  
                 
                if(x > 0)
                    x-=2;
                else
                    y+=2;
                 
                if(flagSF)
                    sf++;
                
                if(sf > 0 && !flagSF) {
                    sf--; 
                    if(sf == 0)
                        flagSF = true;
                } 
                                      
                diagonals++;
            } 
            for (int m = 0; m < vectorLists.length; m++) {
                if(!vectorLists[m].isEmpty()) {
                    int n;
                    int p = vectorLists[m].size()/2; 
                    int xyz;
                    for (n = p; n < vectorLists[m].size(); n++) {
                        xyz = vectorLists[m].get(n-p);
                        vectorLists[m].set(n-p, vectorLists[m].get(n));
                        vectorLists[m].set(n, xyz);
                    }
                } 
            } 
//            for (List<Integer> vectorList : vectorLists) {
//                for (Integer vectorList1 : vectorList) {
//                    System.out.print(vectorList1+" ");
//                } 
//            }
            
            diagonals = 0;
            boolean changeDirection;
            while (diagonals < M.length) {   
                i = 0;
                j = 0;
                l = 0;
                changeDirection = false;
                
                while (i < M.length && j > -1 && l < vectorLists[diagonals].size()) {                    
                    if(M[i][j] > 0) { 
                        if(i == M.length-1) {
                            changeDirection = true;
                            i = 0;
                            j = M.length;
                        }
                        if(!changeDirection)
                            i++; 
                        else
                            j--;
                    } else {
                        if(!vectorLists[diagonals].isEmpty()) {
                            if(!changeDirection)
                                M[i][j] = vectorLists[diagonals].get(l); 
                            else
                                M[i][j] = vectorLists[diagonals].get(l); 
                            i++;
                            j++;
                            l++;
                        }
                        else
                            break;
                    } 
                } 
                diagonals++;
            }
        } else {
            int x = M.length/2;
            int y = x/2;
            int z;
            for (int i = 0; i < M.length; i++)
                for (int j = 0; j < M[i].length; j++) {
                    M[i][j] = V[k];
                    k++;
                }
            
            for (int i = 0; i < y; i++) { 
                for (int j = y; j < M.length-y; j++) {
                    z = M[M.length-1-i][M.length-1-j];
                    M[M.length-1-i][M.length-1-j] = M[i][j];
                    M[i][j] = z;
                     
                } 
            }
            
            for (int i = 0; i < y; i++) { 
                for (int j = y; j < M.length-y; j++) {
                    z = M[M.length-1-j][M.length-1-i];
                    M[M.length-1-j][M.length-1-i] = M[j][i];
                    M[j][i] = z;
                     
                } 
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
//        for (int[] m : M)
//            System.out.println(Arrays.toString(m));
        int sumH;
        int[] sumV = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            sumH = 0;
            for (int j = 0; j < M.length; j++) {
                sumH += M[i][j];
                sumV[j] += M[i][j];
                System.out.print(M[i][j]+" ");
            }
            System.out.print("= "+sumH);
            System.out.println("");
        }
        for (int t : sumV) {
            System.out.print(t+" ");
        }
    }
}
