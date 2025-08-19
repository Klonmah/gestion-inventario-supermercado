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
public class Seccion {
    /**/
    private ArrayList<Producto> productos;
    private String nombreSeccion;
    
    /*Constructor*/
    public Seccion(String nombreSeccion){
        this.productos = new ArrayList<>();
        this.nombreSeccion = nombreSeccion;
    }
    
    public void agregarProducto(Producto producto){
        this.productos.add(producto);
    }
    
    public void mostrarProductos(){
        if(productos.isEmpty()){
             System.out.println("La Sección " + this.nombreSeccion + " está vacía.");
        } else{
            /*Recorre todos los productos y los printea*/
            for(Producto i : productos){
                System.out.println(i);
            }
        }
        
        
    }
    
    
}
