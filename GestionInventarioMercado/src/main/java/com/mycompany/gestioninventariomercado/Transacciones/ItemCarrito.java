/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado.Transacciones;
import com.mycompany.gestioninventariomercado.Producto;

/**
 *
 * @author diazv
 */
public class ItemCarrito {
    /*Variables*/
    private Producto producto;
    private int cantidad;
    /*Constructor*/
    public ItemCarrito(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }
    
    /*setters*/
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    
    /*Getters*/
    public int getCantidad(){
        return this.cantidad;
    }
    
    public Producto getProducto(){
        return this.producto;
    }
    
    public String toString() {
        return "Producto: " + this.producto.getNombre() + ", Cantidad: " + this.cantidad + " ,";
    }
    
}
