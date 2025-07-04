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
public class Cart {
    private List<CartItem> items = new ArrayList<>();
    private ShippingServices shippingService;

    public Cart(ShippingServices shippingService) {
        this.shippingService = shippingService;
    }

    public void add(Product product, int quantity) {
        if (quantity <= 0) {
            System.out.println("Quantity must be positive");
            return;
        }
        
        if (quantity > product.getQuentitiy()) {
            System.out.println("Not enough quantity for " + product.getName());
            return;
        }
        
        if (product.canExpire() && product instanceof ExpiredItems) {
            ExpiredItems expirableProduct = (ExpiredItems) product;
            if (expirableProduct.mayExpired()) {
                System.out.println("Cannot add " + product.getName() + " to cart - it's expired!");
                return;
            }
        }
        
        items.add(new CartItem(product, quantity));
        product.setQuentitiy((int) (product.getQuentitiy() - quantity));//update product quentity

    }

    public void checkout(Customers customer) {
        if (items.isEmpty()) {
            System.out.println("Cannot checkout - cart is empty!");
            return;
        }
        
        // Check for expired products
        for (CartItem item : items) {
            if (item.getProduct().canExpire() && item.getProduct() instanceof ExpiredItems) {
                ExpiredItems expirable = (ExpiredItems) item.getProduct();
                if (expirable.mayExpired()) {
                    System.out.println("Cannot checkout - " + item.getProduct().getName() + " is expired!");
                    return;
                }
            }
        }
        
        double subtotal = calculateSubtotal();
        double shipping = calculateShipping();
        double total = subtotal + shipping;
        
        if (total > customer.getBalance() ) {
            System.out.printf("Cannot checkout ", 
                total, customer.getBalance());
            return;
        }
        
        // Process payment
        customer.BalanceAfterchecked(total);
        
        // Print receipt
        printReceipt(subtotal, shipping, total);
        
        // Process shipping
        List<ShippedItemsdone> shippableItems = new ArrayList<>();
        for (CartItem item : items) {
            if (item.getProduct().requiresShipping() && item.getProduct() instanceof ShippedItemsdone) {
                for (int i = 0; i < item.getQuantity(); i++) {
                    shippableItems.add((ShippedItemsdone) item.getProduct());
                }
            }
        }
        
        if (!shippableItems.isEmpty()) {
            shippingService.shipItems(shippableItems);
        }
        
        // Clear cart
        items.clear();
    }

    private double calculateSubtotal() {
        double subtotal = 0;
        for (CartItem item : items) {
            subtotal += item.getProduct().getPrice() * item.getQuantity();
        }
        return subtotal;
    }

    private double calculateShipping() {
        double shipping = 0;
        for (CartItem item : items) {
            if (item.getProduct().requiresShipping() && item.getProduct() instanceof ShippedItemsdone) {
                ShippedItemsdone shippable = (ShippedItemsdone) item.getProduct();
                shipping += shippable.getWeight() * 28; // $10 per kg for shipping
            }
        }
        return shipping;
    }

    private void printReceipt(double subtotal, double shipping, double total) {
        System.out.println("** Checkout receipt **");
        for (CartItem item : items) {
            System.out.println(
            item.getQuantity() + "x " + 
            item.getProduct().getName() + " " + 
            (int)(item.getProduct().getPrice() * item.getQuantity())
        );
    }
    System.out.println("----------------------");
    System.out.println("Subtotal " + (int)subtotal);
    System.out.println("Shipping " + (int)shipping);
    System.out.println("Amount " + (int)total);
    }
    
    
}
