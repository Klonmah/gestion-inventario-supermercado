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
 * Excepción que se lanza cuando un texto supera el límite de caracteres permitido.
 * Usada para validar nombres de productos, secciones, vendedores, etc.
 */
public class ExcepcionLimiteString extends Exception {

    /**
     * Crea una nueva instancia de la excepción con un mensaje por defecto.
     */
    public ExcepcionLimiteString() {
        super("Nombre de producto, Nombre de Seccion y Vendedor no pueden tener más de 30 caracteres");
    }
}
