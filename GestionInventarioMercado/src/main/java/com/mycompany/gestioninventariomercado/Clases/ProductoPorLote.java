/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado.Clases;

/**
 * Representa un producto que se maneja por lotes y no es perecible.
 * Hereda de Producto e incluye información de cantidad por lote.
 * Permite aumentar o reducir stock considerando lotes completos.
 * 
 * @author diazv
 */
public class ProductoPorLote extends Producto {

    /** Cantidad de productos que vienen en un lote */
    private int cantidadLote; 

    /*Constructor*/
    
    /**
     * Constructor de ProductoPorLote con todos los parámetros.
     * @param nombreProducto Nombre del producto
     * @param cantidadProducto Cantidad inicial en stock
     * @param vendedor Nombre del proveedor
     * @param precioCompra Precio de compra
     * @param codigo Código único del producto
     * @param cantidadLote Cantidad de productos por lote
     */
    public ProductoPorLote(String nombreProducto, int cantidadProducto,
                           String vendedor, float precioCompra, int codigo,
                           int cantidadLote) {
        super(nombreProducto, cantidadProducto, vendedor, precioCompra, codigo);
        this.cantidadLote = cantidadLote;
    }

    /**
     * Constructor vacío que inicializa los valores por defecto.
     */
    public ProductoPorLote(){
        super("",0,"",0,0);
        this.cantidadLote = 0;
    }

    /*Getter*/

    /**
     * Obtiene la cantidad de productos por lote.
     * @return Cantidad por lote
     */
    public int getCantidadLote() {
        return cantidadLote;
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
     * Sobrescribe aumentarStock para incrementar stock por lotes.
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
     * Devuelve una representación en String del producto por lote.
     * Incluye los datos del producto base, indica que no es perecible y la cantidad por lote.
     * @return String con todos los datos del producto por lote
     */
    @Override
    public String toString() {
        return super.toString() + ","+ "No Perecible" + "," + this.cantidadLote;
    }
}