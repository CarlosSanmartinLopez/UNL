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
package Cafeteria.Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stelliox.com
 */
public class Order extends ProductAbstract {
    private Client client;
    private List<Product> products;
    
    public Order(Client client) {
        this.client = client;
        products = new ArrayList(); 
    }
    
    public void addProduct(Product product, int cant) {
        products.add(new Product(product.getName(), product.getValue(), cant));
    }
    
    public List<Product> getProdList() {
        return products;
    }
    
    public double getTotalToPay() {
        double sum = 0;
        
        for (Product product : products)
            sum += (product.getValue() * product.getCant());
        
        return sum;
    }

    public Client getClient() {
        return client;
    }
    
    
}
