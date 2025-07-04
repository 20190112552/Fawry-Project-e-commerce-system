
package fawrye.commerce.system;

import java.util.Date;


public class FawryeCommerceSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create shipping service
        ShippingServices shippingService = new ShippingServices();
        
        // Create a cart
        Cart cart = new Cart(shippingService);
        
        // cheese products
        ExpiredItemandShipped cheese = new ExpiredItemandShipped("Cheese", 100, 10, 0.4, 
                new Date(System.currentTimeMillis() + 7L * 24 * 60 * 60 * 1000));// Expires in 7 days
        // cheese products
        ExpiredItemandShipped biscuits = new ExpiredItemandShipped("Biscuits", 150, 10, 0.7, 
                new Date(System.currentTimeMillis() + 30L * 24 * 60 * 60 * 1000));// Expires in 30 days
       
        //Mobile scratch card products
         NotExpiredandNotShipped scratchCard = new NotExpiredandNotShipped("Scratch Card", 50, 100);
         
         NotExpiredItemandShipped tvpro=new NotExpiredItemandShipped("tv",75.7,102,22.2);
        
        // Create a customer
        Customers customer = new Customers("Ameen Shawky", 1000);
        
        // Add items to cart
        cart.add(cheese, 1);
        
        //cart.add(scratchCard, 1);
        
        cart.add(biscuits, 1);
        
        
        // Checkout
        cart.checkout(customer);
    
        
    }
    
}
