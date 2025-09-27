/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado.Exepciones;

/**
 *
 * @author diazv
 */
public class ExcepcionLimiteDecimales extends Exception {
    public ExcepcionLimiteDecimales() {
        super("El Precio no puede tener más de 2 decimales");
    }
}