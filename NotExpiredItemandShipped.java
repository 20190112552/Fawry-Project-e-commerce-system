/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fawrye.commerce.system;

/**
 *
 * @author dell
 */

//e.g., TV 
public class NotExpiredItemandShipped extends Product implements ShippedItemsdone {
    
    
    private double weight;
    
    public NotExpiredItemandShipped(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public boolean requiresShipping() {
        return true;
    }

    @Override
    public boolean canExpire() {
        return false;
    }

    @Override
    public double getWeight() {
        return weight;
    }
    
}
