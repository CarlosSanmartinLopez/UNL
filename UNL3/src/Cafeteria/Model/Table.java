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

/**
 *
 * @author Stelliox.com
 */

public class Table {
    private int key;
    private Client client;
    private Order order;

    public Table(int key, Order order) {
        this.key = key;
        this.client = order.getClient();
        this.order = order;
    }

    public Client getClient() {
        return client;
    }

    public Order getOrder() {
        return order;
    }

    public int getKey() {
        return key;
    }
}
