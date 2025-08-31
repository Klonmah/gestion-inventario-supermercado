/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado;
import java.util.ArrayList;
/**
 *
 * @author matia
 */
public class CarroCompras {
    private ArrayList<ItemCarrito> carritoCompras;
    private double precioAcumulado;
    private int cantidadProductos;
    
    /*Constructor*/
    public CarroCompras(){
    this.carritoCompras = new ArrayList<>();
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
     /*Funciones propias*/
    
    public void añadirItem(ItemCarrito itemCarro){
        this.carritoCompras.add(itemCarro);
        this.cantidadProductos += itemCarro.getCantidad();
        this.precioAcumulado += (itemCarro.getCantidad() * itemCarro.getProducto().getPrecioCompra()); 
    }
    
    public void eliminarItem(ItemCarrito itemCarro){
        for(int i = 0; i < this.carritoCompras.size();i++){
            if(itemCarro == this.carritoCompras.get(i)){
                this.cantidadProductos += itemCarro.getCantidad();
                this.precioAcumulado += (itemCarro.getCantidad() * itemCarro.getProducto().getPrecioCompra()); 
                this.carritoCompras.remove(i);
            }
        }
    }
    
    //public void printCarrito(){
    //    for(int i = 0; i < this.carritoCompras.size();i++){
    //        System.out.printf(this.carritoCompras.get(i));
    //    }
    //(())}
}
    

