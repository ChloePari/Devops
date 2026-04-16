package com.example.myservice.entities;

public class Order {

    private String id;
    private int idCustomer;
    private float total;

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }
    public int getIdCustomer() {
        return idCustomer;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    public float getTotal() {
        return total;
    }
}
