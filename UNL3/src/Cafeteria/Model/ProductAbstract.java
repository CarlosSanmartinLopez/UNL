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

public abstract class ProductAbstract {
    public class Product {
        private String name;
        private double value;
        int cant;
        
        public Product() {
        }
        
        public Product(String name, double value) {
            this.name = name;
            this.value = value;
        }
        
        public Product(String name, double value, int cant) {
            this.name = name;
            this.value = value;
            this.cant = cant;
        }

        public String getName() {
            return name;
        }

        public double getValue() {
            return value;
        }

        public int getCant() {
            return cant;
        }

        public void setCant(int cant) {
            this.cant = cant;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setValue(double value) {
            this.value = value;
        }
    } 
} 
