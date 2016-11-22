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
package Cafeteria.Controller;

import Cafeteria.Model.Client;
import Cafeteria.Model.Order;
import Cafeteria.Model.ProductAbstract;
import Cafeteria.Model.Table;
import Cafeteria.Model.TableList;
import Cafeteria.Utilities.LeerTeclado;
import Cafeteria.View.ClientView;
import Cafeteria.View.OrderView;

/**
 *
 * @author Stelliox.com
 */
public class OrderController extends LeerTeclado{
    Order model = null;
    OrderView view = new OrderView();
    
    
    ClientView clientView = new ClientView();
    
    public void newOrder(Cafeteria.Controller.InventoryController inventoryController) {
        model = new Order(new Client(clientView.name()));
        inventoryController.inventoryList();
        do {            
            ProductAbstract.Product product = inventoryController.getView().selectProduct(
                        inventoryController.getModel()
                        );
            int cant = inventoryController.getView().readCant();
            
            if(inventoryController.getModel().remove(product, cant)) {
                model.addProduct(product, cant);
                System.out.println("CONTINUAR SI(cualquier N) | NO(5)");
                if(leerEntero() == 5)
                    break;
            } else {
                System.out.println("La cantidad ingresada excede las unidades en existencia");
            }
            
        } while (true);
        
        do {            
            Table table = new Table(view.setTable(), model);
            TableList tableList = TableList.getInstance();
            
            if(tableList.add(table)) {
                System.out.println("Orden Generada");
                view.view(model);
                break;
            }
                
            System.out.println("Mesa Ocupada");
            
        } while (true);
        
    }
}
