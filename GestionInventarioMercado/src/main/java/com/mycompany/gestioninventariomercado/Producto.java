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
    private int codigo;
    private String seccion;
    
    /*Constructor*/
    public Producto(String nombreProducto, int cantidadProducto, float precioVenta,String vendedor, float precioCompra,int codigo,String seccion){
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.precioVenta = precioVenta;
        this.vendedor = vendedor;
        this.precioCompra = precioCompra;
        this.codigo = codigo;
        this.seccion = seccion;
    }
    /*Sobrecarga de Constructor*/
    public Producto(String nombreProducto, int cantidadProducto, int precioVenta,String vendedor, int precioCompra, int codigo){
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.precioVenta = (float)precioVenta;
        this.vendedor = vendedor;
        this.precioCompra = (float) precioCompra;    
        this.codigo = codigo;
        
    }
    public Producto(String nombreProducto, int cantidadProducto, double precioVenta,String vendedor, double precioCompra, int codigo){
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.precioVenta = (float)precioVenta;
        this.vendedor = vendedor;
        this.precioCompra = (float) precioCompra;    
        this.codigo = codigo;
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
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    /*sobrecarga de metodos*/
    /*Precio Compra*/
    public void setPrecioCompra(int precioCompra){
        this.precioCompra = (float)precioCompra;
    }
    public void setPrecioCompra(double precioCompra){
        this.precioCompra = (float)precioCompra;
    }
    /*Precio Venta*/
    public void setPrecioVenta(int precioVenta){
        this.precioVenta = (float)precioVenta;
    }
    public void setPrecioVenta(double precioVenta){
        this.precioVenta = (float)precioVenta;
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
    public int getCodigo(){
        return this.codigo;
    }
    
    public void aumentarStock(int cantidad){
        this.cantidadProducto += cantidad; 
    }
    
    public void reducirStock(int cantidad){
        this.cantidadProducto -= cantidad;
    }
    
    /*Funcion para Printear los datos del producto*/
@Override
    public String toString() {
        return this.codigo + "," + this.nombreProducto + "," + this.cantidadProducto + "," + this.precioVenta + "," + this.vendedor + "," + this.precioCompra;
    }
    
}
