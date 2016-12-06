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
package AppCafeteria.appcafeteria;

import AppCafeteria.GUI.MainView;

/**
 *
 * @author Stelliox.com
 */
public class Main {
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainView interfaz = new MainView(); 
                interfaz.setVisible(true); 
                interfaz.setExtendedState(interfaz.NORMAL);     
            }
        });
    }
}
