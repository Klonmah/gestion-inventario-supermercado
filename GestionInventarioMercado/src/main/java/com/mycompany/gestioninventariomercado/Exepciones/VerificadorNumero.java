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
 * Clase de utilidades para verificar números enteros y decimales.
 * Lanza excepciones si los números no cumplen ciertas condiciones.
 */
public class VerificadorNumero {

    /**
     * Verifica que un número entero sea válido.
     * <p>
     * Condiciones:
     * <ul>
     *     <li>No puede ser negativo.</li>
     *     <li>No puede superar 10,000,000.</li>
     * </ul>
     *
     * @param numero el número entero a verificar
     * @throws ExcepcionNumNegativo si el número es negativo
     * @throws ExcepcionLimiteNumerico si el número supera el límite permitido
     */
    public static void verificar(int numero) throws ExcepcionNumNegativo, ExcepcionLimiteNumerico {
        if (numero < 0) {
            throw new ExcepcionNumNegativo();
        }
        if (numero > 10_000_000) {
            throw new ExcepcionLimiteNumerico();
        }
    }

    /**
     * Verifica que un número decimal (float) sea válido.
     * <p>
     * Condiciones:
     * <ul>
     *     <li>No puede ser negativo.</li>
     *     <li>No puede superar 10,000,000.</li>
     *     <li>No puede tener más de 2 decimales.</li>
     * </ul>
     *
     * @param numero el número decimal a verificar
     * @throws ExcepcionNumNegativo si el número es negativo
     * @throws ExcepcionLimiteNumerico si el número supera el límite permitido
     * @throws ExcepcionLimiteDecimales si el número tiene más de 2 decimales
     */
    public static void verificar(float numero) throws ExcepcionNumNegativo, ExcepcionLimiteNumerico, ExcepcionLimiteDecimales {
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