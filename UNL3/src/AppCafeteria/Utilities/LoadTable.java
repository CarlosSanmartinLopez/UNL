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
package AppCafeteria.Utilities;

import AppCafeteria.Model.Inventory;
import AppCafeteria.Model.ProductAbstract.Product;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Stelliox.com
 */
public class LoadTable {
    public static JTable loadInventory(JTable jtblInventory) {
        Inventory inventory = Inventory.getInstance();
        List<Product> productList = inventory.getProdList();
        
        DefaultTableModel model = (DefaultTableModel)jtblInventory.getModel();
        
        model.setRowCount(0);
        for (Product product : productList)
            model.addRow(new Object[]{
                            product.getName(),
                            product.getValue(),
                            product.getCant()
                        });
        
        jtblInventory.setModel(model);
        return jtblInventory;
    }
}
