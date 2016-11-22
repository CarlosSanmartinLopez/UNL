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

import Cafeteria.Model.Inventory;
import Cafeteria.Utilities.LeerTeclado;
import Cafeteria.View.MenuView;

/**
 *
 * @author Stelliox.com
 */
public class MainController extends LeerTeclado {
    private MenuView view = new MenuView();
    private InventoryController inventoryController = new InventoryController();
    private OrderController orderController = new OrderController();
    private TableController tableController = new TableController();
    
    private void menuTable() {
        System.out.println("************* SYS *************");
        boolean flag = true;
        
        while (flag) {            
            view.tableView();
            
            switch(leerEntero()) {
                case 1:
                    tableController.view();
                    break;
                case 2:
                    tableController.remove();
                    break;
                case 3:
                    tableController.orderView();
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }
    
    private void menuOrder() {
        System.out.println("************* SYS *************");
        boolean flag = true;
        
        while (flag) {            
            view.orderView();
            
            switch(leerEntero()) {
                case 1:
                    orderController.newOrder(inventoryController);
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }
    
    private void menuInventory() {
        System.out.println("************* SYS *************");
        boolean flag = true;
        
        while (flag) {            
            view.inventoryView();
            
            switch(leerEntero()) {
                case 1:
                    inventoryController.addProduct();
                    break;
                case 2:
                    inventoryController.removeProduct();
                    break;
                case 3:
                    inventoryController.inventoryList();
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }
    
    public void init() {
        System.out.println("************* SYS *************");
        boolean flag = true;
        Inventory inventory = Inventory.getInstance();
        inventory.add("PAN", 1.45, 15);
        inventory.add("CAFE", 1.05, 10);
        inventory.add("AZUCAR", 0.15, 5);
        inventory.add("NATA", 7.45, 12);
        
        
        while (flag) {            
            view.mainView();
            
            switch(leerEntero()) {
                case 1:
                    menuInventory();
                    break;
                case 2:
                    menuOrder();
                    break;
                case 3:
                    menuTable();
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }
}
