/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado.Clases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

/**
 * Representa un producto dentro de la tienda.
 * Contiene información sobre el nombre, cantidad, proveedor, precio y código del producto.
 * Permite aumentar o reducir el stock, generar reportes y obtener información como String.
 * 
 * @author diazv
 */
public class Producto {
    /*Variables*/
  
    /** Nombre del producto */
    private String nombreProducto;
    
    /** Cantidad disponible en stock */
    private int cantidadProducto;
    
    /** Nombre del proveedor o vendedor */
    private String vendedor;
    
    /** Precio de compra del producto */
    private float precioCompra;
    
    /** Código único del producto */
    private int codigo;
    
    
    /*Constructor*/
    
    /**
     * Constructor de Producto con todos los parámetros.
     * @param nombreProducto Nombre del producto
     * @param cantidadProducto Cantidad inicial del producto
     * @param vendedor Nombre del proveedor
     * @param precioCompra Precio de compra en float
     * @param codigo Código único del producto
     */
    public Producto(String nombreProducto, int cantidadProducto,String vendedor, float precioCompra,int codigo){
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.vendedor = vendedor;
        this.precioCompra = precioCompra;
        this.codigo = codigo;
        ;
    }
    
    /**
     * Sobrecarga del constructor para precio de compra en double.
     * @param nombreProducto Nombre del producto
     * @param cantidadProducto Cantidad inicial del producto
     * @param vendedor Nombre del proveedor
     * @param precioCompra Precio de compra en double
     * @param codigo Código único del producto
     */
    public Producto(String nombreProducto, int cantidadProducto,String vendedor, double precioCompra, int codigo){
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.vendedor = vendedor;
        this.precioCompra = (float) precioCompra;    
        this.codigo = codigo;
    }
    
    /**
     * Constructor vacío que inicializa los valores por defecto.
     */
    public Producto(){
        this.nombreProducto = "";
        this.cantidadProducto = 0;
        this.vendedor = "";
        this.precioCompra = 0;
        this.codigo = 0;
    }
    
    /*Setters*/
    
    /**
     * Establece el nombre del producto.
     * @param nombreProducto Nombre del producto
     */
    public void setNombreProducto(String nombreProducto){
        this.nombreProducto = nombreProducto;
    }
    
    /**
     * Establece la cantidad disponible del producto.
     * @param cantidadProducto Cantidad del producto
     */
    public void setCantidadProducto(int cantidadProducto){
        this.cantidadProducto = cantidadProducto;
    }
  
    /**
     * Establece el proveedor del producto.
     * @param vendedor Nombre del proveedor
     */
    public void setVendedor(String vendedor){
        this.vendedor = vendedor;
    }
    
    /**
     * Establece el precio de compra del producto.
     * @param precioCompra Precio en float
     */
    public void setPrecioCompra(float precioCompra){
        this.precioCompra = precioCompra;
    }
    
    /**
     * Establece el código único del producto.
     * @param codigo Código del producto
     */
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    /**
     * Sobrecarga para establecer el precio de compra en double.
     * @param precioCompra Precio en double
     */
    public void setPrecioCompra(double precioCompra){
        this.precioCompra = (float)precioCompra;
    }
    
    /*Getters*/
    
    /**
     * Obtiene el nombre del producto.
     * @return Nombre del producto
     */
    public String getNombre(){
        return this.nombreProducto;
    }
    
    /**
     * Obtiene la cantidad disponible del producto.
     * @return Cantidad en stock
     */
    public int getCantidad(){
        return this.cantidadProducto;
    }
    
    /**
     * Obtiene el proveedor del producto.
     * @return Nombre del proveedor
     */
    public String getVendedor(){
        return this.vendedor;
    }
    
    /**
     * Obtiene el precio de compra del producto.
     * @return Precio en float
     */
    public float getPrecioCompra(){
        return this.precioCompra;
    }
    
    /**
     * Obtiene el código único del producto.
     * @return Código del producto
     */
    public int getCodigo(){
        return this.codigo;
    }
    
    /**
     * Aumenta el stock del producto.
     * @param cantidad Cantidad a agregar
     */
    public void aumentarStock(int cantidad){
        this.cantidadProducto += cantidad; 
    }
    
    /**
     * Reduce el stock del producto.
     * @param cantidad Cantidad a restar
     */
    public void reducirStock(int cantidad){
        this.cantidadProducto -= cantidad;
    }
    
    /**
     * Genera un reporte del producto en un archivo usando BufferedWriter.
     * @param escritor BufferedWriter para escribir el reporte
     * @throws IOException Si ocurre un error al escribir
     */
    public void generarReporteProducto(BufferedWriter escritor) throws IOException{
        File archivo = new File("reporte.txt");
        escritor.write(this.nombreProducto+" ("+this.codigo+")");
        escritor.newLine();
        escritor.newLine();
        escritor.write("Stock Disponible: "+this.cantidadProducto);
        escritor.newLine();
        escritor.write("Proveedor: "+this.vendedor);
        escritor.newLine();
        escritor.write("Precio Compra: "+this.precioCompra);
        escritor.newLine();
    }
    
    /**
     * Devuelve una representación en String del producto.
     * @return String con código, nombre, cantidad, proveedor y precio
     */
    @Override
    public String toString() {
        return this.codigo + "," + this.nombreProducto + "," + this.cantidadProducto + "," + this.vendedor + "," + this.precioCompra;
    }
    
}