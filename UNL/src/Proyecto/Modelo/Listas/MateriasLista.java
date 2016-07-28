/*
 * Copyright (C) 2016 Grupo1
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
package Proyecto.Modelo.Listas;

import Proyecto.Modelo.Materia;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grupo1
 */
public class MateriasLista extends AbstractList<Materia> {

    private List<Materia> list;
    
    public MateriasLista() {
        list = new ArrayList<Materia>();
    }
    
    @Override
    public Materia get(int i) {
        return list.get(i);
    }

    @Override
    public int size() {
        return list.size();
    }
    
    @Override
    public boolean add(Materia m) {
        return list.add(m);
    }
}
