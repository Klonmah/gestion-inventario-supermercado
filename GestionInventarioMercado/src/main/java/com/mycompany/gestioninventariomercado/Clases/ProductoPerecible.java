/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado.Clases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author diazv
 */




public class ProductoPerecible extends Producto {
    private LocalDate fechaVencimiento;

    /*Constructor*/
    public ProductoPerecible(String nombreProducto, int cantidadProducto, String vendedor, float precioCompra, 
                            int codigo, LocalDate fechaVencimiento) {
    
        super(nombreProducto, cantidadProducto, vendedor, precioCompra, codigo);
        this.fechaVencimiento = fechaVencimiento;
    }

    /* Sobrecarga de constructor usando String para fecha*/
    public ProductoPerecible(String nombreProducto, int cantidadProducto,
                             String vendedor, float precioCompra, int codigo,
                             String fechaVencimientoStr) {
        super(nombreProducto, cantidadProducto, vendedor, precioCompra, codigo);
       /*Convierte String a LocalDate, asumiendo formato yyyy-MM-dd*/
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.fechaVencimiento = LocalDate.parse(fechaVencimientoStr, formatter);
    }
    public  ProductoPerecible(){
        super("",0,"",0,0);
        this.fechaVencimiento = null;
    }
    

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
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
 
    /*Recordar usar el estaVencido para ambos*/
    /*Sobrescribir reducirStock para impedir reducir stock de productos vencidos*/
    @Override
    public void reducirStock(int cantidad) {
        super.reducirStock(cantidad);
    }

    /*Sobrescribir aumentarStock para impedir aumentar stock de productos vencidos*/
    @Override
    public void aumentarStock(int cantidad) {
        super.aumentarStock(cantidad); 
    }
    
    @Override
    public String toString() {
        return super.toString() + "," + this.fechaVencimiento + ", 1";
    }
}