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

package Hash.Deber2.BINARIO;


/**
 *
 * @author Carlos Sanmartin
 */
public class Entry 
{
    private String key;
    private String value;
    
    public Entry(String key, String value) 
    {
        this.key = key;
        this.value = value;
    } 

    public String getKey() 
    {
        return key;
    }

    public String getValue() 
    {
        return value;
    }   
}
