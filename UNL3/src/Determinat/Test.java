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

/**
 *
 * @author Stelliox.com
 */
public class Test {
    public static void main(String[] args) {
        double[][] matrix = new double[][]{
            {5, 6, -10},
            {2, 3, -1}
        };
        
//        double[][] matrix = new double[][]{
//            {2, 3, 1, 6},
//            {6, -2, -1, 3},
//            {3, 1, -1, 4}
//        };
//        
        Determinant determinant = new Determinant(matrix);
    }
}
