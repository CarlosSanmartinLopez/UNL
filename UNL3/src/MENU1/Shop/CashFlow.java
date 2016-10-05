/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MENU1.Shop;

/**
 *
 * @author Stelliox.com
 */
public class CashFlow {
    double cash = 0;
    
    private CashFlow() {
    }
    
    public static CashFlow getInstance() {
        return CashFlowHolder.INSTANCE;
    }
    
    private static class CashFlowHolder {

        private static final CashFlow INSTANCE = new CashFlow();
    }
    
    public void add(double cash) {
        this.cash += cash;
    }
    
    public void subtract(double cash) {
        this.cash -= cash;
    }
}
