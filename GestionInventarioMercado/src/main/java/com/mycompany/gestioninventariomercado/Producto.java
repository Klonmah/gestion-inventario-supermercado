/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado;

/**
 *
 * @author diazv
 */
public class Producto {
    /*Variables*/
    private int codigoProducto;
    private String nombreProducto;
    private int cantidadProducto;
    private float precio;
    
    /*Constructor*/
    public Producto(int codigoProducto, String nombreProducto, int cantidadProducto, float precio){
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.precio = precio;
    }
    
    /*Setters*/
    public void setCodigoProducto(){
        this.codigoProducto = codigoProducto;
    }
    public void setNombreProducto(){
        this.nombreProducto = nombreProducto;
    }
    public void setCandidadProducto(){
        this.cantidadProducto = cantidadProducto;
    }
    public void setPrecio(){
        this.precio = precio;
    }
    
    /*Getters*/
    public int getCodigo(){
        return this.codigoProducto;
    }
    public String getNombre(){
        return this.nombreProducto;
    }
    public int getCantidad(){
        return this.cantidadProducto;
    }
    public float getPrecio(){
        return this.precio;
    }
    
    public void setCodigo(){
        
    }
    /*Funcion para Printear los datos del producto*/
    @Override
    public String toString() {
        return "Codigo: " + this.codigoProducto + ", Nombre: " + this.nombreProducto 
                + ", Cantidad: " + this.cantidadProducto + "Precio: " + this.precio;
    }
    
}
