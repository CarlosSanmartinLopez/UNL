/*
 * Copyright (c) 2016 Stelliox.com.
 * 
 * This file is part of Stelliox.com.
 * 
 * This code can not be copied and/or distributed without the express
 * permission of Stelliox.com <ejemplo@stelliox.com>
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *    DEVELOPED BY STELLIOX.COM
 *    ECUADOR - LOJA - 2016
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */
package AppCafeteria.Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stelliox.com
 */
public class TableList {
    
    private static TableList INSTANCE = null;
    private List<Table> tableList;
    
    private TableList() {
        tableList = new ArrayList();
    }
    
    private static void createInstance() {
        if(INSTANCE == null)
            INSTANCE = new TableList();
    }
    
    public static TableList getInstance() {
        if(INSTANCE == null)
            createInstance();
        
        return INSTANCE;
    }
    
    public boolean add(Table table){
        for (Table tableL : tableList) {
            if(tableL.getKey() == table.getKey())
                return false;
        }
        tableList.add(table);
        return true;
    }
    
    public List<Table> getList() {
        return tableList;
    }
    
    public boolean remove(int key) {
        for (int i = 0; i < tableList.size(); i++) {
            if(tableList.get(i).getKey() == key) {
                tableList.remove(i);
                return true;
            }
        }
        
        return false;
    }
}
