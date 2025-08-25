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
    
    /*Funciones propias*/
    
    public void añadirItem(ItemCarrito itemCarro){
        this.carritoVentas.add(itemCarro);
        this.cantidadProductos += itemCarro.getCantidad();
        this.precioAcumulado += (itemCarro.getCantidad() * itemCarro.getProducto().getPrecioVenta()); 
    }
    
    public int retornarCantidadProductos(){
        return this.cantidadProductos;
    }
    
    public double retornarPrecioTotal()
    {
        return this.precioAcumulado;
    }
    
}
