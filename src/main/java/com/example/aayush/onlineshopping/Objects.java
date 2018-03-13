package com.example.aayush.onlineshopping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aayush on 13-Mar-18.
 */

public interface Objects {
    class Product implements Cloneable{
        float cost;
        int quantity;
        long productID;
        String category;
        String color;
        String name;
        String size;
        Vendor vendor;

        Product(long productID, String name, String category, String color, String size,
                int quantity, float cost, Vendor vendor){
            this.productID = productID;
            this.name = name;
            this.category = category;
            this.color = color;
            this.size = size;
            this.quantity = quantity;
            this.cost = cost;
            this.vendor = vendor;
        }
    }

    class Cart{
        List<Product> productList;
        float totalCost;

        Cart(){
            productList = new ArrayList<>();
            totalCost = 0;
        }

        void addProduct(Product product){
            productList.add(product);
            totalCost += product.cost;
        }

        Product getProduct(long productID){
            Product p = null;
            if(!productList.isEmpty()){
                for(int i = 0;i < productList.size();i++){
                    if(productList.get(i).productID == productID){
                        p = productList.get(i);
                    }
                }
            }
            return p;
        }

        void removeProduct(long productID){
            if(!productList.isEmpty()){
                for(int i = 0;i < productList.size();i++){
                    if(productList.get(i).productID == productID){
                        productList.remove(i);
                    }
                }
            }
        }
    }

    abstract class Person{
        long id;
        String address;
        String emailID;
        String name;
        String password;
        String username;

        Person(String name, String username, String password, String emailID, String address){
            this.name = name;
            this.username = username;
            this.password = password;
            this.emailID = emailID;
            this.address = address;
        }
    }

    class User extends Person{
        Cart cart;

        User(String name, String username, String password, String emailID, String address){
            super(name, username, password, emailID, address);
            cart = new Cart();
        }
    }

    class Vendor extends Person{
        List<Product> products;

        Vendor(String name, String username, String password, String emailID, String address){
            super(name, username, password, emailID, address);
            products = new ArrayList<>();
        }
    }
}