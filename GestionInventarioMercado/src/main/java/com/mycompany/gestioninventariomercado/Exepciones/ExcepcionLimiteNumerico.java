/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado.Exepciones;

/**
 * Excepción que se lanza cuando un número supera el límite permitido de 10.000.000.
 * Usada para validar cantidades máximas.
 */
public class ExcepcionLimiteNumerico extends Exception {

    /**
     * Crea una nueva instancia de la excepción con un mensaje por defecto.
     */
    public ExcepcionLimiteNumerico() {
        super("El Valor de codigo, precio y cantidad no pueden ser mayores a 10 millones");
    }
}



