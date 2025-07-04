/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fawrye.commerce.system;

/**
 *
 * @author dell
 */
//e.g. Mobile scratch card
public class NotExpiredandNotShipped extends Product{

    public NotExpiredandNotShipped(String name, double price, int quentitiy) {
        super(name, price, quentitiy);
    }

    @Override
    public boolean requiresShipping() {
        return false;
    }

    @Override
    public boolean canExpire() {
        return false;
    }
    
}
