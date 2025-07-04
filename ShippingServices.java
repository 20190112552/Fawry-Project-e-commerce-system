/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fawrye.commerce.system;

import java.util.List;

/**
 *
 * @author dell
 */
public class ShippingServices {
  public void shipItems(List<ShippedItemsdone> items) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        
        for (ShippedItemsdone item : items) {
            double weightInGrams = item.getWeight() * 1000;
            System.out.println(getItemCount(items, item.getName()) + "x " + 
                item.getName() + " " + 
                (int)weightInGrams + "g");
            totalWeight += item.getWeight();
        }
        
        System.out.println("Total package weight " + Math.round(totalWeight * 10) / 10.0 + "kg");//update weightfrom g to kg 

    }
    
    private int getItemCount(List<ShippedItemsdone> items, String name) {
        int count = 0;
        double weightidenticalitem=0;
        for (ShippedItemsdone item : items) {
            if (item.getName().equals(name)) {
                count++;
                weightidenticalitem+=item.getWeight();
                
            }
        }
        return count;
    }
    
}
