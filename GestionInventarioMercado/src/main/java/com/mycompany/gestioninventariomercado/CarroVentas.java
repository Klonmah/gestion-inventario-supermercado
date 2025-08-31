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
public class CarroVentas {
    private ArrayList<ItemCarrito> carritoVentas;
    private double precioAcumulado;
    private int cantidadProductos;
    
    /*Constructor*/
    public CarroVentas(){
    this.carritoVentas = new ArrayList<>();
    this.precioAcumulado = 0.0;
    this.cantidadProductos = 0;
    }
    
    
    public int getCantidadProductos(){
        return this.cantidadProductos;
    }
    
    public double getPrecioTotal()
    {
        return this.precioAcumulado;
    }
        /*Funciones propias*/
    
    public void añadirItem(ItemCarrito itemCarro){
        this.carritoVentas.add(itemCarro);
        this.cantidadProductos += itemCarro.getCantidad();
        this.precioAcumulado += (itemCarro.getCantidad() * itemCarro.getProducto().getPrecioVenta()); 
    }
    public void eliminarItem(ItemCarrito itemCarro){
        for(int i = 0; i < this.carritoVentas.size();i++){
            if(itemCarro == this.carritoVentas.get(i)){
                this.cantidadProductos += itemCarro.getCantidad();
                this.precioAcumulado += (itemCarro.getCantidad() * itemCarro.getProducto().getPrecioVenta()); 
                this.carritoVentas.remove(i);
            }
        }
    }
    
}
