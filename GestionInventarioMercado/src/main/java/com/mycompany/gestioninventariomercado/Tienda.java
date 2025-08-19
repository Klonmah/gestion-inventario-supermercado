/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado;

import java.util.ArrayList;

/**
 *
 * @author diazv
 */


public class Tienda {
    /*Variables y Objetos*/
    private ArrayList<Seccion> secciones ;
    private String nombreTienda;
    
    /*Constructor*/
    public Tienda(String nombreTienda){
        this.secciones = new ArrayList<>();
        this.nombreTienda = nombreTienda;
    }
    
    /*Setters*/
    public void setNombreTienda(String nombreTienda){
        this.nombreTienda = nombreTienda;
    }
    
    /*Getters*/
    public String getNombreTienda(){
        return this.nombreTienda;
    }
    
    public Seccion getSeccion(String nombreTienda){
        for(Seccion i: secciones){
            if(i.getNombreSeccion().equalsIgnoreCase(nombreTienda)){
                return i;
            }
        }
        return null;
    }
}
