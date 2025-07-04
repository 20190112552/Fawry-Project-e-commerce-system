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
//(e.g. Cheese)
public class ExpiredItemandShipped  extends Product implements ShippedItemsdone,ExpiredItems {
    
    private double weight;
    private Date expiringdate;

    public ExpiredItemandShipped(String name, double price, int quentitiy,double weight,Date expiringdate) {
        super(name, price, quentitiy);
        this.weight=weight;
        this.expiringdate=expiringdate;
    }

    

    @Override
    public boolean requiresShipping() {
        return true;
    }

    @Override
    public boolean canExpire() {
        return true;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public boolean mayExpired() {
        return new Date().after(expiringdate);//return date after expired after # days
    }

    @Override
    public Date getExpiryDate() {
        return expiringdate;
    }
    
    
}
