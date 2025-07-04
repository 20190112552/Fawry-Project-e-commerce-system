/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fawrye.commerce.system;

import java.util.Date;

/**
 *
 * @author dell
 */
public class ExpiredandNotShipped extends Product implements ExpiredItems{
    private Date expiringdate;

    public ExpiredandNotShipped(String name, double price, int quentitiy) {
        super(name, price, quentitiy);
        this.expiringdate=expiringdate;
    }

    @Override
    public boolean requiresShipping() {
        return false;
    }

    @Override
    public boolean canExpire() {
        return true;
    }

    @Override
    public boolean mayExpired() {
        return new Date().after(expiringdate);
    }

    @Override
    public Date getExpiryDate() {
        return expiringdate;
    }

   
    
}
