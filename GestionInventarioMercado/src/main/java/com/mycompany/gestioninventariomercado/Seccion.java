/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JTextArea;

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
    
    public Map<Integer,Producto> getProductos(){
        return this.productos;
    }
    
    /*Resto Funciones*/
    public void agregarProducto(int codigoProducto,Producto producto){
        this.productos.put(codigoProducto,producto);
    }
    
    
    public void mostrarProductos( JTextArea miniterminal ){
        if (this.productos.isEmpty()) {
            miniterminal.append("La Sección " + this.nombreSeccion + " está vacía.\n");
        } else {
            for (Integer key : this.productos.keySet()) {
                miniterminal.append("Código: " + key + "\n");
                miniterminal.append(productos.get(key).toString() + "\n");
            }
        }
        
        
    }
    
    
}
