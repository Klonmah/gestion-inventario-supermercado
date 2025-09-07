/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 *
 * @author hugo
 */
public class lectorseguro {
    private String ingresado;
    
    //constructor
    public lectorseguro(){
        ingresado = "";
    }
    
    //método
    public int leer(boolean idiommenu){
        BufferedReader lector = new BufferedReader (new InputStreamReader(System.in));
        try {
            this.ingresado = lector.readLine();
            this.ingresado = this.ingresado.trim();

            if (this.ingresado.equals("")) {
                this.ingresado = "0";
            }

            return Integer.parseInt(ingresado);

        } catch (IOException e) {
            
            if ( idiommenu ) {System.out.println("Error al leer, se eligio 0"); }else{
            System.out.println("Error, input readed as 0.");}
            return 0;
        } catch (NumberFormatException e) {
            
            if ( idiommenu ) {System.out.println("Error al leer, se eligio 0"); }else{
            System.out.println("Error, input readed as 0.");}
            return 0;
        }
    }
    
    /*
    if ( idiommenu ) { }else{
    }
    */

}
