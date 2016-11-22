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
package Cafeteria.View;

import Cafeteria.Model.Table;
import Cafeteria.Model.TableList;
import Cafeteria.Utilities.LeerTeclado;

/**
 *
 * @author Stelliox.com
 */
public class TableView extends LeerTeclado{
    
    public void tablesView(TableList tableList){
        for (Table table : tableList.getList()) {
            System.out.println("key -> "+table.getKey()+"\t"+table.getClient().getName());
        }
    }
    
    public int selectTable() {
        System.out.print("Ingresa el numero de mesa");
        return leerEntero();
    }
}
