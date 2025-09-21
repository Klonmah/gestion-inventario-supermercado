/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JTextArea;
import java.io.*;


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
    public boolean agregarProducto(int codigoProducto,Producto producto){
        if(this.productos.containsKey(codigoProducto)){
            return false;
        }else{
            this.productos.put(codigoProducto,producto);
            return true;
        }
    }
    public boolean eliminarProducto(int codigoProducto){
        if(this.productos.containsKey(codigoProducto)){
            return false;
        }else{
            this.productos.remove(codigoProducto);
            return true;
        }
    }
    public Producto buscarProducto(int codigoProducto){
         if(this.productos.containsKey(codigoProducto)){
            return this.productos.get(codigoProducto);
        }else{
            this.productos.remove(codigoProducto);
            return null;
        }
    }
    
    
    public void mostrarProductos( JTextArea miniterminal ) throws IOException{
        if (this.productos.isEmpty()) {
            miniterminal.append("La Sección " + this.nombreSeccion + " está vacía.\n");
        } else {
            File archivo = new File("Reporte_Productos_"+this.nombreSeccion+".txt");
            BufferedWriter escritor = new BufferedWriter (new FileWriter(archivo));
          
            for (Integer key : this.productos.keySet()) {
                miniterminal.append("Código: " + key + "\n");
                miniterminal.append(productos.get(key).toString() + "\n");
                escritor.write("Código: " + key + "\n");
                escritor.write(productos.get(key).toString() + "\n");
                escritor.newLine();
            }
            escritor.close();
        }  
    }
    
    @Override
    public String toString(){
        String texto = "";
        if (this.productos.isEmpty()) {
            return "";
        }else{
            for (Integer key : this.productos.keySet()) {
                texto+= this.getNombreSeccion();
                texto+= this.productos.get(key).toString();
                texto+= "\n";
            }
        }
        return texto;
    }
    
    
}
