/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado.Clases;
import com.mycompany.gestioninventariomercado.Clases.Producto;
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
                            int codigo, String seccion, LocalDate fechaVencimiento) {
    
        super(nombreProducto, cantidadProducto, vendedor, precioCompra, codigo, seccion);
        this.fechaVencimiento = fechaVencimiento;
    }

    /* Sobrecarga de constructor usando String para fecha*/
    public ProductoPerecible(String nombreProducto, int cantidadProducto,
                             String vendedor, float precioCompra, int codigo, String seccion,
                             String fechaVencimientoStr) {
        super(nombreProducto, cantidadProducto, vendedor, precioCompra, codigo, seccion);
       /*Convierte String a LocalDate, asumiendo formato yyyy-MM-dd*/
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.fechaVencimiento = LocalDate.parse(fechaVencimientoStr, formatter);
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    /* Método para saber cuántos días faltan para vencer*/
    public int diasParaVencer() {
        return LocalDate.now().until(fechaVencimiento).getDays();
    }
    
    /*Sobrescribir reducirStock para impedir reducir stock de productos vencidos*/
    @Override
    public void reducirStock(int cantidad) {
        if (LocalDate.now().isAfter(fechaVencimiento)) {
            System.out.println("No se puede reducir stock: el producto '" + getNombre() + "' está vencido");
        } else {
            super.reducirStock(cantidad);
        }
    }

    /*Sobrescribir aumentarStock para impedir aumentar stock de productos vencidos*/
    @Override
    public void aumentarStock(int cantidad) {
        if (LocalDate.now().isAfter(fechaVencimiento)) {
            System.out.println("No se puede aumentar stock: el producto '" + getNombre() + "' está vencido");
        } else {
            super.aumentarStock(cantidad);
        }
    }
    
    @Override
    public String toString() {
        return super.toString() + "," + this.fechaVencimiento + ", 1";
    }
}