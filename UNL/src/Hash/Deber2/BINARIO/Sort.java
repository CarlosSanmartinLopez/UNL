/*
 * Copyright (C) 2016 Stelliox.com
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
package Hash.Deber2.BINARIO;


/**
 *
 * @author Stelliox.com
 */
public class Sort {
    static Entry buffer;
    
    public static Entry[] sort(Entry[] vectorSort) {
        
        for (int i = 0; i < vectorSort.length-1; i++) 
            for (int j = 0; j < vectorSort.length-1; j++)
            {
                try {
                   if(Integer.parseInt(vectorSort[j].getKey()) > Integer.parseInt(vectorSort[j+1].getKey()))
                    {
                        buffer = vectorSort[j+1];
                        vectorSort[j+1]= vectorSort[j];
                        vectorSort[j] = buffer;
                    } 
                } catch (Exception e) {
                }
                
            }
        return vectorSort;
    }
}
