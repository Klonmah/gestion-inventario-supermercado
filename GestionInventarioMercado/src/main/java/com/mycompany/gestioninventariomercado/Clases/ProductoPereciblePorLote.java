/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado.Clases;

import java.time.LocalDate;

/**
 * Representa un producto perecible que se maneja por lotes.
 * Hereda de Producto e incluye información de cantidad por lote y fecha de vencimiento.
 * Permite aumentar o reducir stock considerando lotes completos y verificar vencimiento.
 * 
 * @author diazv
 */
public class ProductoPereciblePorLote extends Producto {

    /** Cantidad de productos en cada lote */
    private int cantidadLote;          

    /** Fecha de vencimiento del lote */
    private LocalDate fechaVencimiento; 

    /**
     * Constructor de ProductoPereciblePorLote con todos los parámetros.
     * @param nombreProducto Nombre del producto
     * @param cantidadProducto Cantidad inicial en stock
     * @param vendedor Nombre del proveedor
     * @param precioCompra Precio de compra
     * @param codigo Código único del producto
     * @param cantidadLote Cantidad de productos por lote
     * @param fechaVencimiento Fecha de vencimiento del lote
     */
    public ProductoPereciblePorLote(String nombreProducto, int cantidadProducto,String vendedor, float precioCompra, 
                                    int codigo, int cantidadLote, LocalDate fechaVencimiento) {
        super(nombreProducto, cantidadProducto, vendedor, precioCompra, codigo);
        this.cantidadLote = cantidadLote;
        this.fechaVencimiento = fechaVencimiento;
    }
    
    /**
     * Constructor vacío que inicializa los valores por defecto.
     */
    public ProductoPereciblePorLote(){
        super("",0,"",0,0);
        this.cantidadLote = 0;
        this.fechaVencimiento = null;
    }

    /*Getters*/

    /**
     * Obtiene la cantidad de productos por lote.
     * @return Cantidad por lote
     */
    public int getCantidadLote() {
        return cantidadLote;
    }

    /**
     * Obtiene la fecha de vencimiento del lote.
     * @return Fecha de vencimiento
     */
    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }
    
    /*Setters*/

    /**
     * Establece la cantidad de productos por lote.
     * @param cantidadLote Cantidad por lote
     */
    public void setCantidadLote(int cantidadLote) {
        this.cantidadLote = cantidadLote;
    }

    /**
     * Establece la fecha de vencimiento del lote.
     * @param fechaVencimiento Fecha de vencimiento
     */
    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * Verifica si el lote está vencido.
     * @return true si la fecha actual es posterior a la fecha de vencimiento, false en caso contrario
     */
    public boolean estaVencido(){
        if(LocalDate.now().isAfter(fechaVencimiento)){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Sobrescribe aumentarStock para agregar stock por lotes.
     * @param numeroLotes Número de lotes a agregar
     */
    @Override
    public void aumentarStock(int numeroLotes) {
        int cantidadTotal = numeroLotes * this.cantidadLote;
        super.aumentarStock(cantidadTotal);
    }

    /**
     * Verifica si es posible reducir la cantidad de stock por lotes.
     * @param numeroLotes Número de lotes a reducir
     * @return true si se puede reducir, false si la cantidad total excede el stock disponible
     */
    public boolean esPosibleReducir(int numeroLotes){
        int cantidadTotal = numeroLotes * this.cantidadLote;
        if(cantidadTotal > this.getCantidad()){
            return false;
        }else{
            return true;
        }
    }
    
    /**
     * Sobrescribe reducirStock para reducir stock por lotes.
     * @param numeroLotes Número de lotes a reducir
     */
    @Override
    public void reducirStock(int numeroLotes) {
        int cantidadTotal = numeroLotes * this.cantidadLote;
        super.reducirStock(cantidadTotal);
    }

    /**
     * Devuelve una representación en String del producto perecible por lote.
     * Incluye los datos del producto base, la fecha de vencimiento y la cantidad por lote.
     * @return String con todos los datos del producto por lote
     */
    @Override
    public String toString() {
        return super.toString() + "," + this.fechaVencimiento+ "," + this.cantidadLote;
    }
}