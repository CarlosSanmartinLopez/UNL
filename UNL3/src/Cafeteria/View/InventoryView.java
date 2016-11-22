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

import Cafeteria.Model.Inventory;
import Cafeteria.Model.ProductAbstract.Product;
import Cafeteria.Utilities.LeerTeclado;
import java.util.List;

/**
 *
 * @author Stelliox.com
 */
public class InventoryView extends LeerTeclado {
    public void listView(List<Product> productList) {
        int i = 0;
        System.out.println("LISTA DE PRODUCTOS");
        for (Product product : productList) {
            System.out.println(i+"\t"+product.getName()+"\t"+product.getValue()
                    +"\t"+product.getCant());
            i++;
        }
    }
    
    public String addName() { 
        System.out.print("Nombre: ");
            return leerCadena();
    }
    
    public double addValue() { 
        System.out.print("Valor: ");
            return leerDecimal();
    }
    
    public int addCant() { 
        System.out.print("Cantidad: ");
            return leerEntero();
    }
    
    public Product selectProduct(Inventory model) {
        while (true) {            
            try {
                System.out.println("Selecciona el Producto");
                return model.get(leerEntero());
            } catch (Exception ex) {
                System.out.println("No existe el producto");
            }
        }
        
    }
    
    public int readCant() {
        System.out.println(" > Ingresa la cantidad ");
        return leerEntero();
    }
}
