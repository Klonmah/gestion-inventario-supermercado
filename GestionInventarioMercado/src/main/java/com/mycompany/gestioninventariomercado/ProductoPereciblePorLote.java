/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado;

/**
 *
 * @author diazv
 */
import java.time.LocalDate;

public class ProductoPereciblePorLote extends Producto {
    private int cantidadLote;          
    private LocalDate fechaVencimiento; 

    
    public ProductoPereciblePorLote(String nombreProducto, int cantidadProducto,String vendedor, float precioCompra, 
                                    int codigo, String seccion, int cantidadLote, LocalDate fechaVencimiento) {
        super(nombreProducto, cantidadProducto, vendedor, precioCompra, codigo, seccion);
        this.cantidadLote = cantidadLote;
        this.fechaVencimiento = fechaVencimiento;
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

    /* Días para que el producto llegue a su fecha de vencimiento*/
    public int diasParaVencer() {
        return LocalDate.now().until(fechaVencimiento).getDays();
    }

    /*Sobreescritura del aumentar stock para que funcione por lotes y por fecha de vencimiento*/
    @Override
    public void aumentarStock(int numeroLotes) {
        if (LocalDate.now().isAfter(fechaVencimiento)) {
            System.out.println("No se puede aumentar stock: el producto '" + getNombre() + "' está vencido");
        } else {
            int cantidadTotal = numeroLotes * cantidadLote;
            super.aumentarStock(cantidadTotal);
        }
    }

    /*Sobreescritura del reducir stock para que funcione por lotes y por fecha de vencimiento*/
    @Override
    public void reducirStock(int numeroLotes) {
        if (LocalDate.now().isAfter(fechaVencimiento)) {
            System.out.println("No se puede reducir stock: el producto '" + getNombre() + "' está vencido");
        } else {
            int cantidadTotal = numeroLotes * cantidadLote;
            if (cantidadTotal > getCantidad()) {
                System.out.println("No se puede reducir stock: no hay suficientes productos para " + numeroLotes + " lotes");
            } else {
                super.reducirStock(cantidadTotal);
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + "," + this.fechaVencimiento+ "," + this.cantidadLote;
    }
}