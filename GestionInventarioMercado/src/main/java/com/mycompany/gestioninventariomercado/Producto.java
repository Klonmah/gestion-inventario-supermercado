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
  
    private String nombreProducto;
    private int cantidadProducto;
    private float precioVenta;
    private String vendedor;
    private float precioCompra;
    
    /*Constructor*/
    public Producto(String nombreProducto, int cantidadProducto, float precioVenta,String vendedor, float precioCompra){
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.precioVenta = precioVenta;
        this.vendedor = vendedor;
        this.precioCompra = precioCompra;
    }
    /*Sobrecarga de Constructor*/
    public Producto(String nombreProducto, int cantidadProducto, int precioVenta,String vendedor, int precioCompra){
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.precioVenta = (float)precioVenta;
        this.vendedor = vendedor;
        this.precioCompra = (float) precioCompra;       
    
    }
    
    /*Setters*/
    public void setNombreProducto(String nombreProducto){
        this.nombreProducto = nombreProducto;
    }
    public void setCandidadProducto(int cantidadProducto){
        this.cantidadProducto = cantidadProducto;
    }
    public void setPrecioVenta(float precioVenta){
        this.precioVenta = precioVenta;
    }
    public void setVendedor(String vendedor){
        this.vendedor = vendedor;
    }
    public void setPrecioCompra(float precioCompra){
        this.precioCompra = precioCompra;
    }
    
    /*sobrecarga de metodos*/
    public void setPrecioCompra(int precioCompra){
        this.precioCompra = (float)precioCompra;
    }
    public void setPrecioCompra(double precioCompra){
        this.precioCompra = (float)precioCompra;
    }
    
    /*Getters*/
    public String getNombre(){
        return this.nombreProducto;
    }
    public int getCantidad(){
        return this.cantidadProducto;
    }
    public float getPrecioVenta(){
        return this.precioVenta;
    }
    public String getVendedor(){
        return this.vendedor;
    }
    public float getPrecioCompra(){
        return this.precioCompra;
    }
   
    
    /*Funcion para Printear los datos del producto*/

    public String toString() {
        return ", Nombre: " + this.nombreProducto 
                + ", Cantidad: " + this.cantidadProducto + ", Precio Venta: " 
                + this.precioVenta + ", Vendedor = " + this.vendedor + ", Precio Compra = " + this.precioCompra;
    }
    
}
