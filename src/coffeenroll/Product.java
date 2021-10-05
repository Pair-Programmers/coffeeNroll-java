/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeenroll;


public class Product {
    String name;
    float price;
    float total;

    public Product() {
    }

    public Product(String name, float price, float total) {
        this.name = name;
        this.price = price;
        this.total = total;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getTotal() {
        return total;
    }
    
    public void addToTotal(float total) {
        this.total = this.total + total;
    }
}
