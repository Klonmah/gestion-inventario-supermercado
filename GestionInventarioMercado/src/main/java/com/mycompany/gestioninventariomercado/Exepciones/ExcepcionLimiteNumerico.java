/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado.Exepciones;

/**
 *
 * @author diazv
 */
public class ExcepcionLimiteNumerico extends Exception {
    public ExcepcionLimiteNumerico(){
        super("El Valor de codigo, precio y cantidad no pueden ser mayores a 10 millones");
    }
}
