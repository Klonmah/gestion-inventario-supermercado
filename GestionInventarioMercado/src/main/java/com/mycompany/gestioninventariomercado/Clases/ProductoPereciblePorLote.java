/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado.Clases;

/**
 *
 * @author diazv
 */

import java.time.LocalDate;

public class ProductoPereciblePorLote extends Producto {
    private int cantidadLote;          
    private LocalDate fechaVencimiento; 

    
    public ProductoPereciblePorLote(String nombreProducto, int cantidadProducto,String vendedor, float precioCompra, 
                                    int codigo, int cantidadLote, LocalDate fechaVencimiento) {
        super(nombreProducto, cantidadProducto, vendedor, precioCompra, codigo);
        this.cantidadLote = cantidadLote;
        this.fechaVencimiento = fechaVencimiento;
    }
    
    public ProductoPereciblePorLote(){
        super("",0,"",0,0);
        this.cantidadLote = 0;
        this.fechaVencimiento = null;
    }
    /*Getters*/
    public int getCantidadLote() {
        return cantidadLote;
    }
    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }
    
    /*Setters*/
    public void setCantidadLote(int cantidadLote) {
        this.cantidadLote = cantidadLote;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public boolean estaVencido(){
        if(LocalDate.now().isAfter(fechaVencimiento)){
            return true;
        }else{
            return false;
        }
    }
    
    /*Sobreescritura del aumentar stock para que funcione por lotes y por fecha de vencimiento*/
    @Override
    /*Recordar: Usar estaVencido antes de aumentar o reducir el stock*/
    public void aumentarStock(int numeroLotes) {
        int cantidadTotal = numeroLotes * this.cantidadLote;
        super.aumentarStock(cantidadTotal);
    }

    public boolean esPosibleReducir(int numeroLotes){
        int cantidadTotal = numeroLotes * this.cantidadLote;
        if(cantidadTotal > this.getCantidad()){
            return false;
        }else{
            return true;
        }
    }
    
    /*Sobreescritura del reducir stock para que funcione por lotes y por fecha de vencimiento*/
    @Override
    /*Recordar: Usar el esPosibleReducir antes del reducir stock*/
    public void reducirStock(int numeroLotes) {
        
        int cantidadTotal = numeroLotes * this.cantidadLote;
        super.reducirStock(cantidadTotal);
   
    }

    @Override
    public String toString() {
        return super.toString() + "," + this.fechaVencimiento+ "," + this.cantidadLote;
    }
}