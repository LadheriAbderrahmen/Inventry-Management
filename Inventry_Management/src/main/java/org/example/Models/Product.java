package org.example.Models;

public class Product {
    private int id;
    private String name;
    private int Qte;

    public Product(int id, String name,  int Qte) {
        this.id = id;
        this.name = name;
        this.Qte = Qte;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public int getQte() {
        return Qte;
    }

    @Override
    public String toString() {
        return getName();
    }
}
