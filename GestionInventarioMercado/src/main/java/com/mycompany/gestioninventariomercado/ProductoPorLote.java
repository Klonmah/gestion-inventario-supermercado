/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado;

/**
 *
 * @author diazv
 */
public class ProductoPorLote extends Producto {
    /*Lote es que un producto venga en un packete de varios, por ejemplo un pack de 6 de leche de chocolate*/
    /*Cantidad de Productos que vienen en 1 lote de productos*/
    private int cantidadLote; 

    /*Constructor*/
    public ProductoPorLote(String nombreProducto, int cantidadProducto, float precioVenta,
                           String vendedor, float precioCompra, int codigo, String seccion,
                           int cantidadLote) {
        super(nombreProducto, cantidadProducto, precioVenta, vendedor, precioCompra, codigo, seccion);
        this.cantidadLote = cantidadLote;
    }

    /*Getter*/
    public int getCantidadLote() {
        return cantidadLote;
    }
    /*Setters*/
    public void setCantidadLote(int cantidadLote) {
        this.cantidadLote = cantidadLote;
    }

    /*Sobrescribir aumentarStock para incrementar por lote*/
    @Override
    public void aumentarStock(int lotes) {
        int cantidadTotal = lotes * cantidadLote; /* total de productos en los lotes*/
        super.aumentarStock(cantidadTotal);
    }

    /*Sobreescribe Reducir stock para que funcione por lotes*/
    @Override
    public void reducirStock(int numeroLotes) {
        int cantidadTotal = numeroLotes * cantidadLote;
        if (cantidadTotal > getCantidad()) {
            System.out.println("No se puede reducir stock: No hay suficientes productos para " + numeroLotes + " lotes");
        } else {
            super.reducirStock(cantidadTotal);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "," + cantidadLote;
    }
}