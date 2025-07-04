/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fawrye.commerce.system;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class Customers  {
     
    
    private String name;
    private double balance;

    public Customers(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void BalanceAfterchecked(double amount) {
        balance -= amount;
    }
    
    
 
        
        
}
