/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado.Clases;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;

/**
 * Representa una sección dentro de la tienda.
 * Contiene productos y permite operaciones como agregar, eliminar,
 * buscar productos, cambiar códigos y generar reportes.
 * También permite manejar productos perecibles y vencidos.
 * 
 * @author diazv
 */
public class Seccion {

    /** Mapa de productos con su código como clave */
    private Map<Integer,Producto> productos;

    /** Nombre de la sección */
    private String nombreSeccion;

    /*Constructor*/

    /**
     * Constructor de Seccion.
     * @param nombreSeccion Nombre de la sección
     */
    public Seccion(String nombreSeccion){
        this.productos = new HashMap<>();
        this.nombreSeccion = nombreSeccion;
    }

    /*Setters*/

    /**
     * Establece el nombre de la sección.
     * @param nombreSeccion Nombre de la sección
     */
    public void setNombreSeccion(String nombreSeccion){
        this.nombreSeccion = nombreSeccion;
    }

    /**
     * Establece el mapa de productos.
     * @param productos Mapa de productos
     */
    public void setProductos (Map<Integer,Producto> productos){
        this.productos = productos;
    }

    /*Getters*/

    /**
     * Obtiene el nombre de la sección.
     * @return Nombre de la sección
     */
    public String getNombreSeccion(){
        return this.nombreSeccion;
    }

    /**
     * Obtiene un producto por su código.
     * @param codigoProducto Código del producto
     * @return Producto correspondiente al código o null si no existe
     */
    public Producto getProductoCodigo(int codigoProducto){
        return this.productos.get(codigoProducto);
    }

    /**
     * Obtiene todos los productos de la sección.
     * @return Mapa de productos
     */
    public Map<Integer,Producto> getProductos(){
        return this.productos;
    }

    /*Funciones principales*/

    /**
     * Agrega un producto a la sección.
     * @param codigoProducto Código del producto
     * @param producto Producto a agregar
     * @return true si se agrega correctamente, false si el código ya existe
     */
    public boolean agregarProducto(int codigoProducto,Producto producto){
        if(this.productos.containsKey(codigoProducto)){
            return false;
        }else{
            this.productos.put(codigoProducto,producto);
            return true;
        }
    }

    /**
     * Elimina un producto de la sección.
     * @param codigoProducto Código del producto a eliminar
     * @return true si se elimina correctamente, false si no existe
     */
    public boolean eliminarProducto(int codigoProducto){
        if(this.productos.containsKey(codigoProducto)){
            this.productos.remove(codigoProducto);
            return true;
        }else{
            return false;
        }
    }

    /**
     * Busca un producto por su código.
     * @param codigoProducto Código del producto
     * @return Producto encontrado o null si no existe
     */
    public Producto buscarProducto(int codigoProducto){
         if(this.productos.containsKey(codigoProducto)){
            return this.productos.get(codigoProducto);
        }else{
            return null;
        }
    }

    /**
     * Cambia el código de un producto existente.
     * @param codigoProducto Código actual del producto
     * @param codigoNuevo Nuevo código a asignar
     * @return true si se cambió correctamente, false si no existe
     */
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

    /**
     * Elimina todos los productos vencidos de la sección.
     */
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

    /**
     * Lista todos los productos vencidos de la sección.
     * @return Texto con los productos vencidos
     */
    public String listarProductosVencidos(){
        String texto = "";
        if (this.productos.isEmpty()) {
            return "";
        }else{
            for (Integer key : this.productos.keySet()) {
                Producto p = this.productos.get(key);
                if(p instanceof ProductoPerecible){
                    ProductoPerecible perecible = (ProductoPerecible) p;
                    if(LocalDate.now().isAfter(perecible.getFechaVencimiento())){
                        texto+= this.getNombreSeccion() + ",";
                        texto+= this.productos.get(key).toString();
                        texto+= "1,";
                        texto+= "\n";
                    }
                }else if(this.productos.get(key) instanceof ProductoPereciblePorLote){
                    ProductoPereciblePorLote perecible = (ProductoPereciblePorLote) p;
                    if(LocalDate.now().isAfter(perecible.getFechaVencimiento())){
                        texto+= this.getNombreSeccion() + ",";
                        texto+= this.productos.get(key).toString();
                        texto+= "\n";
                    }
                }
            }
        }
        return texto;
    }

    /**
     * Genera un reporte de la sección en un BufferedWriter.
     * Incluye todos los productos y datos adicionales según su tipo.
     * @param escritor BufferedWriter para escribir el reporte
     * @throws IOException Si ocurre un error al escribir
     */
    public void generarReporteSeccion(BufferedWriter escritor) throws IOException{
            escritor.write("--------------------------------------------");
            escritor.newLine();
            escritor.write("Seccion: "+this.nombreSeccion);
            escritor.newLine();
            escritor.newLine();
            escritor.newLine();
            for (Integer key : this.productos.keySet()) {
                Producto p = this.getProductoCodigo(key);
                if (p instanceof ProductoPerecible)
                {
                    ProductoPerecible per = (ProductoPerecible) p;
                    p.generarReporteProducto(escritor);
                    escritor.write("Fecha de Vencimiento: "+per.getFechaVencimiento());
                    escritor.newLine();
                    escritor.newLine();
                }
                else if (p instanceof ProductoPorLote)
                {
                    ProductoPorLote lote = (ProductoPorLote) p;
                    p.generarReporteProducto(escritor);
                    escritor.write("Cantidad Por Lote: "+lote.getCantidadLote());
                    escritor.newLine();
                }
                else if (p instanceof ProductoPereciblePorLote)
                {
                    ProductoPereciblePorLote perlote = (ProductoPereciblePorLote) p;
                    p.generarReporteProducto(escritor);
                    escritor.write("Fecha de Vencimiento: "+perlote.getFechaVencimiento());
                    escritor.newLine();
                    escritor.write("Cantidad Por Lote: "+perlote.getCantidadLote());
                    escritor.newLine();
                    escritor.newLine();
                }
                else
                {
                    p.generarReporteProducto(escritor);
                    escritor.newLine();
                }
            }
            escritor.newLine();
        }

    /**
     * Devuelve una representación en String de todos los productos de la sección.
     * Incluye datos de la sección y el tipo de producto.
     * @return String con todos los productos de la sección
     */
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