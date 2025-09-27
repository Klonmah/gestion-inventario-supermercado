/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado.Exepciones;

/**
 *
 * @author diazv
 */
public class ExepcionLimiteProductos extends Exception {
    public ExepcionLimiteProductos(){
        super("El Stock de Cada Producto no puede superar las 1000 unidades.");
    }
}
