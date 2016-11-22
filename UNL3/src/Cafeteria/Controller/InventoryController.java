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
import Cafeteria.Model.ProductAbstract;
import Cafeteria.View.InventoryView;
import java.util.List;

/**
 *
 * @author Stelliox.com
 */
public class InventoryController {
    private Inventory model = Inventory.getInstance();
    private InventoryView view = new InventoryView();
    
    public List<ProductAbstract.Product> getProdList() {
        return model.getProdList();
    }
    
    public void inventoryList() {
        view.listView(getProdList());
    }
    
    public void addProduct() {
        model.add(view.addName(), view.addValue(), view.addCant());
    }
     
    public void removeProduct() {
        inventoryList();
        model.remove(view.selectProduct(model), view.readCant());
    }
    
    public InventoryView getView() {
        return view;
    }

    public Inventory getModel() {
        return model;
    }
}
