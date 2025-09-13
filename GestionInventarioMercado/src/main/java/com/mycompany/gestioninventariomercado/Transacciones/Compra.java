/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado.Transacciones;

/**
 *
 * @author matia
 */
public class Compra extends Transaccion {
    @Override
    public void procesar() {
        for (int i = 0; i < getCarrito().size(); i++) {
            ItemCarrito productoCarro = getCarrito().get(i);
            productoCarro.getProducto().aumentarStock(productoCarro.getCantidad());
        }
        System.out.println("Compra procesada");
    }
}
