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

package Hash.Simple1;

/**
 *
 * @author Carlos Sanmartin
 */
public class Test 
{
    public static void main(String[] args) 
    {
        HashMapa hm = new HashMapa();
        hm.put(21,875);
        hm.put(14,5);
        hm.put(56,85);
        hm.put(10,75);
        hm.put(100,7511);
        hm.put(33,775);
        hm.put(20,785); // colision
        hm.put(26,785); // colision
        // hm.put(12,757);
        
        System.out.println("-> "+hm.get(100));
    }
}
