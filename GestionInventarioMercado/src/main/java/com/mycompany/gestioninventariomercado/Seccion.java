/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author diazv
 */
public class Seccion {
    /*Variables y Objetos*/
    private Map<Integer,Producto> productos;
    private String nombreSeccion;
    
    /*Constructor*/
    public Seccion(String nombreSeccion){
        this.productos = new HashMap<>();
        this.nombreSeccion = nombreSeccion;
    }
    
    /*Setter*/
    public void setNombreSeccion(String nombreSeccion){
        this.nombreSeccion = nombreSeccion;
    }
    /*Sobrecarga de metodos 2*/
    public void setNombreSeccion(char nombreSeccion){
        this.nombreSeccion = Character.toString(nombreSeccion);
    }
    
    /*Getter*/
    public String getNombreSeccion(){
        return this.nombreSeccion;
    }
    
    public Producto getProductoCodigo(int codigoProducto){
        return this.productos.get(codigoProducto);
    }
    
    /*Resto Funciones*/
    public void agregarProducto(int codigoProducto,Producto producto){
        this.productos.put(codigoProducto,producto);
    }
    
    
    public void mostrarProductos(){
        if(this.productos.isEmpty()){
             System.out.println("La Sección " + this.nombreSeccion + " está vacía.");
        } else{
            /*Recorre todos los productos y los printea*/
            for (Integer key : this.productos.keySet()) {
                System.out.printf("Codigo: " + key);
                System.out.println(productos.get(key));
            }
        }
        
        
    }
    
    
}
