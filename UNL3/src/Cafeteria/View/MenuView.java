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

/**
 *
 * @author Stelliox.com
 */
public class MenuView {
    public void mainView() {
        System.out.println("1. Inventario");
        System.out.println("2. Pedidos");
        System.out.println("3. Mesas");
        System.out.println("5. SALIR");
    }
    
    public void inventoryView() {
        System.out.println("1. Agregar");
        System.out.println("2. Eliminar");
        System.out.println("3. Ver");
        System.out.println("5. SALIR");
    }
    
    public void orderView() {
        System.out.println("1. Nuevo Pedido");
        System.out.println("5. SALIR");
    }
    
    public void tableView() {
        System.out.println("1. Ver mesas ocupadas");
        System.out.println("2. Desocupar Mesa");
        System.out.println("3. Ver la Orden de la Mesa");
        
        System.out.println("5. SALIR");
    }
}
