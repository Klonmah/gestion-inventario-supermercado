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
    
    /*Funciones propias*/
    
    public void añadirItem(ItemCarrito itemCarro){
        this.carritoCompras.add(itemCarro);
        this.cantidadProductos += itemCarro.getCantidad();
        this.precioAcumulado += (itemCarro.getCantidad() * itemCarro.getProducto().getPrecioCompra()); 
    
    }
    
    public double retornarCantidadProductos()
    {
        return this.precioAcumulado;
    }
    
    public double retornarPrecioTotal()
    {
        return this.precioAcumulado;
    }
}
    

