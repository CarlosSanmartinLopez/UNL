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

import Cafeteria.Model.Order;
import Cafeteria.Model.ProductAbstract;
import Cafeteria.Utilities.LeerTeclado;

/**
 *
 * @author Stelliox.com
 */
public class OrderView extends LeerTeclado {
    public int setTable() {
        System.out.print("Numero de mesa ");
            return leerEntero();
    } 
    
    public void view(Order model) {
        System.out.println("Cliente: \t"+model.getClient().getName());
        for (ProductAbstract.Product p : model.getProdList()) {
            System.out.println(p.getName()+"\t"+p.getValue()+"\t"+p.getCant());
        }        
        System.out.println("TOTAL \t\t"+model.getTotalToPay());
    }
}
