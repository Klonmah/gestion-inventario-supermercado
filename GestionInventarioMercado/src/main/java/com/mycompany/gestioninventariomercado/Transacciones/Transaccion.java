/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado.Transacciones;
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
    public double getCantidadProductos()
    {
        return this.precioAcumulado;
    }
    
    public double getPrecioTotal()
    {
        return this.precioAcumulado;
    }
    public ArrayList<ItemCarrito> getCarrito(){
        return this.carrito;
    }
    
    
     /*Funciones propias*/
    
    public void añadirItem(ItemCarrito itemCarro){
        this.carrito.add(itemCarro);
        this.cantidadProductos += itemCarro.getCantidad();
        this.precioAcumulado += (itemCarro.getCantidad() * itemCarro.getProducto().getPrecioCompra()); 
    }
    
    public void eliminarItem(ItemCarrito itemCarro){
        for(int i = 0; i < this.carrito.size();i++){
            if(itemCarro == this.carrito.get(i)){
                this.cantidadProductos += itemCarro.getCantidad();
                this.precioAcumulado += (itemCarro.getCantidad() * itemCarro.getProducto().getPrecioCompra()); 
                this.carrito.remove(i);
            }
        }
    }
    
    public void borrarCarrito(){
        this.carrito.clear();
        this.precioAcumulado = 0.0;
        this.cantidadProductos = 0;
    }
    
    public void procesar(){}
    
    //public void printCarrito(){
    //    for(int i = 0; i < this.carritoCompras.size();i++){
    //        System.out.printf(this.carritoCompras.get(i));
    //    }
    //}
}
    

