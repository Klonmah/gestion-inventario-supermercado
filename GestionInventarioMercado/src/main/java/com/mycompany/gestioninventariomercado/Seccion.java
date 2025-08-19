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
    /*Variables y Objetos*/
    private ArrayList<Producto> productos;
    private String nombreSeccion;
    
    /*Constructor*/
    public Seccion(String nombreSeccion){
        this.productos = new ArrayList<>();
        this.nombreSeccion = nombreSeccion;
    }
    
    /*Setter*/
    public void setNombreSeccion(String nombreSeccion){
        this.nombreSeccion = nombreSeccion;
    }
    /*Getter*/
    public String getNombreSeccion(){
        return this.nombreSeccion;
    }
    
    public Producto getProductoCodigo(int codigoProducto){
        for(Producto i : this.productos){
            if(i.getCodigo() == codigoProducto){
                return i;
            }
        }
        return null;
    }
    
    public Producto getProductoNombre(String nombreProducto){
        for(Producto i : this.productos){
            if(i.getNombre().equalsIgnoreCase(nombreProducto)){
                return i;
            }
        }
        return null;
    }
    
    /*Resto Funciones*/
    public void agregarProducto(Producto producto){
        this.productos.add(producto);
    }
    
    
    public void mostrarProductos(){
        if(this.productos.isEmpty()){
             System.out.println("La Sección " + this.nombreSeccion + " está vacía.");
        } else{
            /*Recorre todos los productos y los printea*/
            for(Producto i : this.productos){
                System.out.println(i);
            }
        }
        
        
    }
    
    
}
