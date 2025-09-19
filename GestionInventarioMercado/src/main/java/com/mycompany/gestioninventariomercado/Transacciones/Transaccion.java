/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado.Transacciones;
import com.mycompany.gestioninventariomercado.Tienda;
import java.util.ArrayList;

/**
 *
 * @author matia
 */
public class Transaccion {
    private ArrayList<ItemCarrito> carrito;
    private double precioAcumulado;
    private int cantidadProductos;
    
    /*Constructor*/
    public Transaccion(){
        this.carrito = new ArrayList<>();
        this.precioAcumulado = 0.0;
        this.cantidadProductos = 0;

    }
    
    /*Getters*/
    public int getCantidadProductos()
    {
        return this.cantidadProductos;
    }
    
    public double getPrecioTotal()
    {
        return this.precioAcumulado;
    }
    public ArrayList<ItemCarrito> getCarrito(){
        return this.carrito;
    }
    
    /*Setters*/
    public void setCantidadProductos(int cantidadProductos){
        this.cantidadProductos = cantidadProductos;
    }
    public void setPrecioTotal(double precioAcumulado){
        this.precioAcumulado = precioAcumulado;
    }
    
    
     /*Funciones propias*/
    
    public void añadirItem(ItemCarrito itemCarro){}
    
    public void eliminarItem(ItemCarrito itemCarro){}
    
    public void borrarCarrito(){
        this.carrito.clear();
        this.precioAcumulado = 0.0;
        this.cantidadProductos = 0;
    }
    
    public void procesar(Tienda tienda, String nombreArchivo){}
    
}
    

