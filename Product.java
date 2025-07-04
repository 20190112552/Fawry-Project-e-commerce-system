/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fawrye.commerce.system;

import java.util.List;
import fawrye.commerce.system.ShippedItemsdone;

/**
 *
 * @author dell
 */
public abstract class Product {
    private String name;
    private double price;
    private int quantity;


    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public double getPrice(){
        return price;
    }
    
    public void setQuentitiy(int  quentitiy){
        this.quantity=quentitiy;
    }
    public double getQuentitiy(){
        return quantity;
    }
    public abstract boolean requiresShipping();

    public abstract boolean canExpire();

        
        
}

