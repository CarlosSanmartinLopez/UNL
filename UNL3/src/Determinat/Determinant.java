/*
 * Copyright (C) 2016 Stelliox.com
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
package Determinat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Stelliox.com
 */
public class Determinant {
    private double[][] equations;
    private List<double[]> equationsList;
    private double[] variables;
    private double deltaSystem; 
    
    public Determinant(double[][] equations) {
        this.equations = equations;
        variables = new double[equations[0].length-1];
        
        deltaSystem = delta(-1);
        
        for (int i = 0; i < equations[0].length-1; i++) {
            variables[i] = (delta(i)/deltaSystem);
            
            System.out.println(variables[i]);
        }
        
        double v;
        double ev = 0;
        for (int i = 0; i < equations.length; i++) {
            v = 0;
            ev = equations[i][equations[i].length-1];
            for (int j = 0; j < equations[0].length-1; j++) {
                v += equations[i][j]*variables[j];
            }
            System.out.println("Value -> "+v+" | Expected Value -> "+ev);
        }
    }
    
    private void changeValues(int p) {
        for (int i = 0; i < equationsList.size(); i++)
            equationsList.get(i)[p] = equationsList.get(i)[equationsList.get(i).length-1];        
    }
    
    private double delta(int p) {
        int i = 0;
        int x;
        int y;
        double m;
        double s0 = 0;
        double s1 = 0;
        
        double[][] equationsClone = new double[equations.length][];
        
        for (int j = 0; j < equations.length; j++) {
           equationsClone[j] = Arrays.copyOf(equations[j], equations[j].length);
        }
        
        equationsList = new ArrayList<>();
        equationsList.addAll(Arrays.asList(equationsClone));
        
        for (int j = 0; j < equationsClone[0].length-2; j++)
            equationsList.add(equationsClone[j]);
        if(p > -1)
            changeValues(p);
        
        while (i < equations.length) {
            x = i;
            y = 0;
            m = 1; 
            while (y < equations[0].length-1) {   
                m *= equationsList.get(x)[y];
                
                x++; 
                y++;
            } 
            s0 += m;
            i++;
        } 
        
        i = 0;
        while (i < equations.length) {
            x = equationsList.size()-1-i;
            y = 0;
            m = 1; 
            while (y < equations[0].length-1) {  
                m *= equationsList.get(x)[y];
                
                x--; 
                y++;
            }
            s1 += m;
            i++;
        }
        
//        System.out.println("S0 -> "+s0);
//        System.out.println("S1 -> "+s1);
//        System.out.println("delta -> "+(s0-s1));
        
        return s0-s1;
    }
}
