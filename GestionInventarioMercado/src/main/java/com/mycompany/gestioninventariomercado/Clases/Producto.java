/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado.Clases;

/**
 *
 * @author diazv
 */
public class Producto {
    /*Variables*/
  
    private String nombreProducto;
    private int cantidadProducto;
    private String vendedor;
    private float precioCompra;
    private int codigo;
    
    
    /*Constructor*/
    public Producto(String nombreProducto, int cantidadProducto,String vendedor, float precioCompra,int codigo,String seccion){
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.vendedor = vendedor;
        this.precioCompra = precioCompra;
        this.codigo = codigo;
        ;
    }
    /*Sobrecarga de Constructor*/
    public Producto(String nombreProducto, int cantidadProducto,String vendedor, double precioCompra, int codigo){
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.vendedor = vendedor;
        this.precioCompra = (float) precioCompra;    
        this.codigo = codigo;
    }
    public Producto(){
        this.nombreProducto = "";
        this.cantidadProducto = 0;
        this.vendedor = "";
        this.precioCompra = 0;
        this.codigo = 0;
    }
    
    /*Setters*/
    public void setNombreProducto(String nombreProducto){
        this.nombreProducto = nombreProducto;
    }
    public void setCandidadProducto(int cantidadProducto){
        this.cantidadProducto = cantidadProducto;
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
    
    /*Getters*/
    public String getNombre(){
        return this.nombreProducto;
    }
    public int getCantidad(){
        return this.cantidadProducto;
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
        return this.codigo + "," + this.nombreProducto + "," + this.cantidadProducto + "," + this.vendedor + "," + this.precioCompra;
    }
    
}
