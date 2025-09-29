/*
 * Click nbfs://nbfs/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbfs/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado.Clases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Representa un producto perecible, que hereda de Producto.
 * Contiene información adicional de fecha de vencimiento y métodos para verificar si está vencido.
 * Permite controlar el stock considerando productos perecibles.
 * 
 * @author diazv
 */
public class ProductoPerecible extends Producto {

    /** Fecha de vencimiento del producto */
    private LocalDate fechaVencimiento;

    /*Constructor*/
    
    /**
     * Constructor de ProductoPerecible con todos los parámetros.
     * @param nombreProducto Nombre del producto
     * @param cantidadProducto Cantidad inicial en stock
     * @param vendedor Nombre del proveedor
     * @param precioCompra Precio de compra
     * @param codigo Código único del producto
     * @param fechaVencimiento Fecha de vencimiento del producto
     */
    public ProductoPerecible(String nombreProducto, int cantidadProducto, String vendedor, float precioCompra, 
                            int codigo, LocalDate fechaVencimiento) {
        super(nombreProducto, cantidadProducto, vendedor, precioCompra, codigo);
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * Constructor vacío que inicializa los valores por defecto.
     */
    public ProductoPerecible(){
        super("",0,"",0,0);
        this.fechaVencimiento = null;
    }
    
    /**
     * Obtiene la fecha de vencimiento del producto.
     * @return Fecha de vencimiento como LocalDate
     */
    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * Establece la fecha de vencimiento del producto.
     * @param fechaVencimiento Fecha de vencimiento a establecer
     */
    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    
    /**
     * Verifica si el producto está vencido.
     * @return true si la fecha actual es posterior a la fecha de vencimiento, false en caso contrario
     */
    public boolean estaVencido(){
        if(LocalDate.now().isAfter(fechaVencimiento)){
            return true;
        }else{
            return false;
        }
    }
 
    /*Recordar usar el estaVencido para reducir y aumentar stock*/
    
    /**
     * Sobrescribe reducirStock para considerar productos perecibles.
     * Actualmente permite reducir stock como la clase padre.
     * @param cantidad Cantidad a reducir
     */
    @Override
    public void reducirStock(int cantidad) {
        super.reducirStock(cantidad);
    }

    /**
     * Sobrescribe aumentarStock para considerar productos perecibles.
     * Actualmente permite aumentar stock como la clase padre.
     * @param cantidad Cantidad a aumentar
     */
    @Override
    public void aumentarStock(int cantidad) {
        super.aumentarStock(cantidad); 
    }
    
    /**
     * Devuelve una representación en String del producto perecible.
     * Incluye todos los datos de Producto y la fecha de vencimiento.
     * @return String con todos los datos del producto perecible
     */
    @Override
    public String toString() {
        return super.toString() + "," + this.fechaVencimiento + ", 1";
    }
}