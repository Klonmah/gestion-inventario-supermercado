/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado.Exepciones;

/**
 *
 * @author diazv
 */
public class ExepcionNumNegativo extends Exception {
    public ExepcionNumNegativo(){
        super("Ha ingresado un numero Negativo en una de las casillas");
    }
}
