/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PASCUAL;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stelliox.com
 */
public class Pascual {
    int levels;
    List<Integer>[] levelsList;
    
    public Pascual(int levels, boolean unitary) {
        this.levels = levels;
        levelsList = new ArrayList[levels];
        
        if(unitary)
            generateUnitary();
        else
            generateNormal();
        
        view();
    }
    
    private void generateUnitary() {
        for (int i = 0; i < levelsList.length; i++) {
            levelsList[i] = new ArrayList();
            for (int j = 0; j < i+1; j++) 
                levelsList[i].add(1);
        }
    }
    
    private void generateNormal() {
        int sum;
        for (int i = 0; i < levelsList.length; i++) {
            levelsList[i] = new ArrayList();
            for (int j = 0; j < i+1; j++) {
                if(i > 1 && j > 0 && j < i) {
                    sum = levelsList[i-1].get(j-1)+levelsList[i-1].get(j);
                    levelsList[i].add(sum);
                }
                else
                    levelsList[i].add(1);
            }
        }
    }
    
    private void view() {
        for (int i = 0; i < levelsList.length; i++) {
            
            for (int j = 0; j < levelsList[levelsList.length-i-1].size(); j++) {
                System.out.print(" ");
            }
            System.out.println(levelsList[i].toString()
                    .replaceAll(",", "")
                    .replace("[", "")
                    .replace("]", ""));
        }
    }
}
