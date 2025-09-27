/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;


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
    
    /*Getters*/
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
            this.productos.remove(codigoProducto);
            return true;
        }else{
            return false;
        }
    }
    public Producto buscarProducto(int codigoProducto){
         if(this.productos.containsKey(codigoProducto)){
            return this.productos.get(codigoProducto);
        }else{
            return null;
        }
    }
    public boolean cambiarCodigoProducto(int codigoProducto, int codigoNuevo){
        Producto producto = this.getProductoCodigo(codigoProducto);
        if(this.productos.containsKey(codigoProducto)){
            producto.setCodigo(codigoNuevo);
            this.productos.remove(codigoProducto);
            this.productos.put(codigoNuevo, producto);
            return true;
        }else{
            return false;
        }
        
    }
    
    public void eliminarProductosVencidosPorSeccion(){
        for (Integer key : this.productos.keySet()) {
            Producto p = this.productos.get(key);
            /*Revisa si el Producto es Perecible*/
            if(p instanceof ProductoPerecible){
                ProductoPerecible perecible = (ProductoPerecible) p;
                if (LocalDate.now().isAfter(perecible.getFechaVencimiento())) {
                    this.productos.remove(key);
                }
            /*Revisa si el producto es Perecible y por lote*/
            }else if(p instanceof ProductoPereciblePorLote){
                ProductoPereciblePorLote perecible = (ProductoPereciblePorLote) p;
                if(LocalDate.now().isAfter(perecible.getFechaVencimiento())){
                    this.productos.remove(key);
                }
            }
        }
    }
    
    public String listarProductosVencidos(){
        String texto = "";
        if (this.productos.isEmpty()) {
            return "";
        }else{
            for (Integer key : this.productos.keySet()) {
                if(this.productos.get(key) instanceof ProductoPerecible){
                    texto+= this.getNombreSeccion() + ",";
                    texto+= this.productos.get(key).toString();
                    texto+= "1,";
                    texto+= "\n";
                }else if(this.productos.get(key) instanceof ProductoPereciblePorLote){
                    texto+= this.getNombreSeccion() + ",";
                    texto+= this.productos.get(key).toString();
                    texto+= "\n";
                }
            }
        }
        return texto;
        
    }
    
    @Override
    public String toString(){
        String texto = "";
        if (this.productos.isEmpty()) {
            return "";
        }else{
            for (Integer key : this.productos.keySet()) {
                
                if(this.productos.get(key) instanceof ProductoPerecible){
                    texto+= this.getNombreSeccion() + ",";
                    texto+= this.productos.get(key).toString();
                    texto+= "1,";
                    texto+= "\n";
                }else if(this.productos.get(key) instanceof ProductoPereciblePorLote){
                    texto+= this.getNombreSeccion() + ",";
                    texto+= this.productos.get(key).toString();
                    texto+= "\n";
                }else{
                
                    texto+= this.getNombreSeccion() + ",";
                    texto+= this.productos.get(key).toString();
                    texto += ",No Perecible,";
                    texto += "1";
                    texto+= "\n";
                }
            }
        }
        return texto;
    }
    
    
}
