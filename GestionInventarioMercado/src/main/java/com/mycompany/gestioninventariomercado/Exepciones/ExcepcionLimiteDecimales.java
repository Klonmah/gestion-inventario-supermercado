/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado.Exepciones;

/**
 *
 * @author diazv
 */
/**
 * Excepción que se lanza cuando un número decimal tiene más de dos decimales.
 * Usada típicamente para validar precios de productos.
 */
public class ExcepcionLimiteDecimales extends Exception {

    /**
     * Crea una nueva instancia de la excepción con un mensaje por defecto.
     */
    public ExcepcionLimiteDecimales() {
        super("El Precio no puede tener más de 2 decimales");
    }
}