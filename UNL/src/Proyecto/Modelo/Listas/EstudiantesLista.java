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

import Proyecto.Modelo.Estudiante;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grupo1
 */
public class EstudiantesLista extends AbstractList<Estudiante> {

    private List<Estudiante> list;
    
    public EstudiantesLista() {
        list = new ArrayList<Estudiante>();
    }
    
    @Override
    public Estudiante get(int i) {
        return list.get(i);
    }

    @Override
    public int size() {
        return list.size();
    }
    
    @Override
    public boolean add(Estudiante e) {
        return list.add(e);
    }
}
