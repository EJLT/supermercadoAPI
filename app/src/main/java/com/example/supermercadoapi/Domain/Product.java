package com.example.supermercadoapi.Domain;

public class Product {
    private int id;
    private String name;
    private double precio;
    private String descripcion;
    private String procedencia;



    public Product(int id, String nombre, double precio, String descripcion, String procedencia){
        this.id = id;
        this.name = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.procedencia = procedencia;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }
}
