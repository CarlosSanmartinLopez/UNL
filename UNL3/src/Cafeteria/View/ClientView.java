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

import Cafeteria.Utilities.LeerTeclado;

/**
 *
 * @author Stelliox.com
 */
public class ClientView extends LeerTeclado {
    
    public String name() {
        System.out.println("Ingrese el Nombre del Cliente");
        return leerCadena();
    }
}
