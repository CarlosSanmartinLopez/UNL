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
package AppCafeteria.Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stelliox.com
 */
public class Inventory extends ProductAbstract {
    private static Inventory INSTANCE = null;
    private List<Product> prodList;
    
    private Inventory() {
        prodList = new ArrayList();
    }
    
    private static void createInstance() {
        if(INSTANCE == null)
            INSTANCE = new Inventory();
    }
    
    public static Inventory getInstance() {
        if(INSTANCE == null)
            createInstance();
        
        return INSTANCE;
    }
    
    public void add(String name, double value, int cant) {
        Product product = new Product(name, value);
        
        for (int i = 0; i < prodList.size(); i++)
            if(prodList.get(i).getName().equals(product.getName())) {
                prodList.get(i).setValue(value);
                prodList.get(i).setCant(prodList.get(i).cant + cant);
                return;
            }
        
        prodList.add(new Product(product.getName(), product.getValue(), cant));
    }
    
    public void add(String name, int cant) {
        for (int i = 0; i < prodList.size(); i++)
            if(prodList.get(i).getName().equals(name)) {
                prodList.get(i).setCant(prodList.get(i).cant + cant);
                return;
            }
        
        prodList.add(new Product(name, 0, cant));
    }
    
    public Product get(int i) throws Exception {
        Product prod = prodList.get(i);
        return new Product(prod.getName(), prod.getValue());
    }
    
    public Product get(String str){
        for (int i = 0; i < prodList.size(); i++)
            if(prodList.get(i).getName().equals(str)) {
                return prodList.get(i);
            }
        return null;
    }
    
    public boolean remove(String name) {
        for (int i = 0; i < prodList.size(); i++)
            if(prodList.get(i).getName().equals(name)) {
                prodList.remove(i);
                return true;
            }   
        
        return false;
    }
    
    public boolean remove(String name, int cant) {
        for (int i = 0; i < prodList.size(); i++)
            if(prodList.get(i).getName().equals(name)) {
                if(prodList.get(i).getCant() >= cant){
                    prodList.get(i).setCant(prodList.get(i).cant - cant); 
                    return true;
                } else {
                    System.out.println("Excede la cantidad en existencia \n"
                            + "\tProd: "+prodList.get(i).getName()+" (En existencia "+prodList.get(i).cant+")");
                    break;
                }
            }   
        
        return false;
    }
    
    public List<Product> getProdList() {
        return prodList;
    }
}
