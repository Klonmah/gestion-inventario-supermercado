/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author diazv
 */
public class ItemCarro {
    /*Variables*/
    private Producto producto;
    private int cantidad;
    /*Constructor*/
    public ItemCarro(Producto producto, int cantidad) {
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
    
    public float valorTotal(int compraOventa){
        if(compraOventa == 0){
            return (float) this.cantidad * this.producto.getPrecioCompra();
        }else{
            return (float) this.cantidad * this.producto.getPrecioVenta();
        }
    }
    
    
}
