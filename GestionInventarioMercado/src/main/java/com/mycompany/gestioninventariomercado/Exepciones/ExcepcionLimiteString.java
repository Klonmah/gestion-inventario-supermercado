/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado.Exepciones;

/**
 *
 * @author diazv
 */
public class ExcepcionLimiteString extends Exception{
    public ExcepcionLimiteString(){
        super("Nombre de producto, Nombre de Seccion y Vendedor no pueden tener más de 30 caracteres");
    }
}
