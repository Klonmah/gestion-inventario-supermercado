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
 * Excepción que se lanza cuando un número ingresado es negativo.
 * Usada para validar cantidades, precios u otros valores numéricos.
 */
public class ExcepcionNumNegativo extends Exception {

    /**
     * Crea una nueva instancia de la excepción con un mensaje por defecto.
     */
    public ExcepcionNumNegativo() {
        super("El número no puede ser negativo");
    }
}