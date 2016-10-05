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
