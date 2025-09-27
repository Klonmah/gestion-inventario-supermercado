/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado.Exepciones;

/**
 *
 * @author diazv
 */
public class VerificadorNumero {

    public static void verificar(int numero) throws ExcepcionNumNegativo, ExcepcionLimiteNumerico {
        if (numero < 0) {
            throw new ExcepcionNumNegativo();
        }
        if (numero > 10_000_000) {
            throw new ExcepcionLimiteNumerico();
        }
    }
    public static void verificar(float numero) throws ExcepcionNumNegativo, ExcepcionLimiteNumerico,ExcepcionLimiteDecimales {
        if (numero < 0) {
            throw new ExcepcionNumNegativo();
        }
        if (numero > 10_000_000) {
            throw new ExcepcionLimiteNumerico();
        }
        float valorMultiplicado = numero * 100;
        if (valorMultiplicado != Math.floor(valorMultiplicado)) {
            throw new ExcepcionLimiteDecimales();
        }
    }
}