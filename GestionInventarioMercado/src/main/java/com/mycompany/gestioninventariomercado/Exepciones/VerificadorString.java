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
 * Clase de utilidades para verificar cadenas de texto.
 * Lanza una excepción si la cadena supera la longitud permitida.
 */
public class VerificadorString {

    /**
     * Verifica que una cadena de texto no supere el límite de caracteres permitido.
     * <p>
     * Condición:
     * <ul>
     *     <li>La longitud máxima permitida es de 30 caracteres.</li>
     * </ul>
     *
     * @param texto la cadena de texto a verificar
     * @throws ExcepcionLimiteString si la cadena supera los 30 caracteres
     */
    public static void verificar(String texto) throws ExcepcionLimiteString {
        if (texto.length() > 30) {
            throw new ExcepcionLimiteString();
        }
    }
}