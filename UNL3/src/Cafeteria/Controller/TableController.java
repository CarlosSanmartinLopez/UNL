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

import Cafeteria.Model.TableList;
import Cafeteria.View.OrderView;
import Cafeteria.View.TableView;


/**
 *
 * @author Stelliox.com
 */
public class TableController {
    TableList model = TableList.getInstance();
    TableView view = new TableView();
    OrderView orderView = new OrderView();
    
    public void view() {
        view.tablesView(model);
    }
    
    public void remove() {
        view();
                    
        int k = view.selectTable();
        for (int i = 0; i < model.getList().size(); i++) {
            if(model.getList().get(i).getKey() == k) {
               model.getList().remove(i); 
            }
        }
        System.out.println("La mesa esta libre");
        
    }
    
    public void orderView(){
        view();
        
                  
        int k = view.selectTable();
        for (int i = 0; i < model.getList().size(); i++) {
            if(model.getList().get(i).getKey() == k) {
               orderView.view(model.getList().get(i).getOrder());
               return;
            }
        } 
        System.out.println("No tiene Orden");
    }
}
