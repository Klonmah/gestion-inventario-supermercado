/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado.Clases;

import java.util.ArrayList;
import java.io.*;
import java.time.LocalDate;

/**
 * Representa una tienda que contiene múltiples secciones.
 * Permite agregar, buscar, eliminar secciones y productos.
 * También maneja la carga y guardado de datos en archivos,
 * así como la generación de reportes.
 * 
 * @author diazv
 */
public class Tienda {

    /** Lista de secciones de la tienda */
    private ArrayList<Seccion> secciones ;

    /** Nombre de la tienda */
    private String nombreTienda;

    /*Constructor*/

    /**
     * Constructor de Tienda con nombre.
     * @param nombreTienda Nombre de la tienda
     */
    public Tienda(String nombreTienda){
        this.secciones = new ArrayList<>();
        this.nombreTienda = nombreTienda;
    }

    /*Setters*/

    /**
     * Establece el nombre de la tienda.
     * @param nombreTienda Nombre de la tienda
     */
    public void setNombreTienda(String nombreTienda){
        this.nombreTienda = nombreTienda;
    }

    /*Getters*/

    /**
     * Obtiene el nombre de la tienda.
     * @return Nombre de la tienda
     */
    public String getNombreTienda(){
        return this.nombreTienda;
    }

    /**
     * Obtiene una sección por su nombre.
     * @param nombreSeccion Nombre de la sección
     * @return Sección encontrada o null si no existe
     */
    public Seccion getSeccion(String nombreSeccion){
        for(Seccion i: secciones){
            if(i.getNombreSeccion().equalsIgnoreCase(nombreSeccion)){
                return i;
            }
        }
        return null;
    }

    /**
     * Obtiene la lista de secciones.
     * @return ArrayList de secciones
     */
    public ArrayList<Seccion> getListSecciones(){
        return secciones;
    }

    /**
     * Agrega una sección a la tienda.
     * @param seccion Sección a agregar
     */
    public void agregarSeccion(Seccion seccion){
        this.secciones.add(seccion);
    }

    /**
     * Busca una sección por nombre.
     * @param nombre Nombre de la sección
     * @return Sección encontrada o null si no existe
     */
    public Seccion buscarSeccion(String nombre){
        for(Seccion i: secciones){
            if(i.getNombreSeccion().equals(nombre)){
                return i;
            }
        }
        return null;
    }

    /**
     * Elimina una sección por nombre.
     * @param nombre Nombre de la sección a eliminar
     */
    public void eliminarSeccion(String nombre){
        for(int i = 0 ; i < secciones.size() ; i++ ){
            if(secciones.get(i).getNombreSeccion().equals(nombre)){
                this.secciones.remove(i);
                break;
            }
        }
    }

    /**
     * Verifica si existe una sección con un nombre dado.
     * @param nombre Nombre de la sección
     * @return true si existe, false si no
     */
    public boolean existeSeccion(String nombre){
        for(Seccion i: secciones){
            if(i.getNombreSeccion().equals(nombre)){
                return true;
            }
        }
        return false;
    }

    /**
     * Guarda los datos de la tienda en un archivo de texto.
     * Incluye todas las secciones y productos.
     * @param archivo Ruta del archivo
     * @throws IOException Si ocurre un error al escribir
     */
    public void guardarDatos(String archivo) throws IOException{
        BufferedWriter escritor = new BufferedWriter (new FileWriter(archivo));
        for (Seccion sec : secciones){
            escritor.write("Seccion;"+sec.getNombreSeccion());
            escritor.newLine();
            for (Integer key : sec.getProductos().keySet()) {
                Producto p = sec.getProductoCodigo(key);
                if (p instanceof ProductoPerecible)
                {
                    ProductoPerecible per = (ProductoPerecible) p;
                    escritor.write("ProductoPerecible;"+key+";"+per.getNombre()+";"+per.getCantidad()+";"+per.getVendedor()+";"+per.getPrecioCompra()+";"+per.getFechaVencimiento());
                    escritor.newLine();
                }
                else if (p instanceof ProductoPorLote)
                {
                    ProductoPorLote lote = (ProductoPorLote) p;
                    escritor.write("ProductoPorLote;"+key+";"+lote.getNombre()+";"+lote.getCantidad()+";"+lote.getVendedor()+";"+lote.getPrecioCompra()+";"+lote.getCantidadLote());
                    escritor.newLine();
                }
                else if (p instanceof ProductoPereciblePorLote)
                {
                    ProductoPereciblePorLote perlote = (ProductoPereciblePorLote) p;
                    escritor.write("ProductoPereciblePorLote;"+key+";"+perlote.getNombre()+";"+perlote.getCantidad()+";"+perlote.getVendedor()+";"+perlote.getPrecioCompra()+";"+perlote.getFechaVencimiento()+";"+perlote.getCantidadLote());
                    escritor.newLine();
                }
                else
                {
                    escritor.write("Producto;"+key+";"+p.getNombre()+";"+p.getCantidad()+";"+p.getVendedor()+";"+p.getPrecioCompra());
                    escritor.newLine();
                }
            }
            escritor.newLine();
        }
        escritor.close();
    }

    /**
     * Genera un reporte completo de la tienda en un archivo "reporte.txt".
     * @throws IOException Si ocurre un error al escribir
     */
    public void generarReporte() throws IOException{
        File archivo = new File("reporte.txt");
        BufferedWriter escritor = new BufferedWriter (new FileWriter(archivo));
        for (Seccion sec : secciones){
            sec.generarReporteSeccion(escritor);
        }
        escritor.close();
    }

    /**
     * Carga los datos de la tienda desde un archivo de texto.
     * @param archivo Ruta del archivo
     * @throws IOException Si ocurre un error al leer
     */
    public void cargarDatos(String archivo) throws IOException
    {
        BufferedReader lector = new BufferedReader(new FileReader(archivo));
        String linea;
        Seccion i = null;
        String seccionActual = null;
        while ((linea=lector.readLine()) != null)
        {
            if(linea.isBlank()) continue;
            String[] datos = linea.split(";");
            if(datos[0].equals("Seccion"))
            {
                i = new Seccion(datos[1]);
                agregarSeccion(i);
                seccionActual=datos[1];
            }
            else if (datos[0].equals("Producto") && i!= null)
            {
                int codigo = Integer.parseInt(datos[1]);
                String nombre= datos[2];
                int cantidad = Integer.parseInt(datos[3]);
                String vendedor = datos[4];
                float precioCompra = Float.parseFloat(datos[5]);
                
                Producto p = new Producto(nombre, cantidad, vendedor, precioCompra,codigo);
                i.agregarProducto(codigo,p);
            }
            else if (datos[0].equals("ProductoPerecible") && i!= null)
            {
                int codigo = Integer.parseInt(datos[1]);
                String nombre= datos[2];
                int cantidad = Integer.parseInt(datos[3]);
                String vendedor = datos[4];
                float precioCompra = Float.parseFloat(datos[5]);
                
                LocalDate FechaVencimiento = LocalDate.parse(datos[6]);
                ProductoPerecible p = new ProductoPerecible(nombre, cantidad, vendedor, precioCompra,codigo,FechaVencimiento);
                i.agregarProducto(codigo,p);
            }
            else if (datos[0].equals("ProductoPorLote") && i!= null)
            {
                int codigo = Integer.parseInt(datos[1]);
                String nombre= datos[2];
                int cantidad = Integer.parseInt(datos[3]);
                String vendedor = datos[4];
                float precioCompra = Float.parseFloat(datos[5]);
                
                int cantidadLote = Integer.parseInt(datos[6]);
                ProductoPorLote p = new ProductoPorLote(nombre, cantidad, vendedor, precioCompra,codigo,cantidadLote);
                i.agregarProducto(codigo,p);
            }
            else if (datos[0].equals("ProductoPereciblePorLote") && i!= null)
            {
                int codigo = Integer.parseInt(datos[1]);
                String nombre= datos[2];
                int cantidad = Integer.parseInt(datos[3]);
                String vendedor = datos[4];
                float precioCompra = Float.parseFloat(datos[5]);
                
                LocalDate fechaVencimiento = LocalDate.parse(datos[6]);
                int cantidadLote = Integer.parseInt(datos[7]);
                ProductoPereciblePorLote p = new ProductoPereciblePorLote(nombre, cantidad, vendedor, precioCompra,codigo,cantidadLote,fechaVencimiento);
                i.agregarProducto(codigo,p);
            }
        }
    }

    /**
     * Obtiene un producto por código dentro de todas las secciones.
     * @param codigo Código del producto
     * @return Producto encontrado o null si no existe
     */
    public Producto getProductoEnSeccionPorCodigo(int codigo)
    {
        for (Seccion sec : secciones) {
            Producto p = sec.getProductoCodigo(codigo);
            if (p != null){
                return p;
            }
        }
        return null; 
    }

    /**
     * Obtiene el nombre de la sección donde se encuentra un producto.
     * @param codigo Código del producto
     * @return Nombre de la sección o "" si no existe
     */
    public String getNombreSeccionDeProducto(int codigo){
        for (Seccion sec : secciones) {
            if(sec.buscarProducto(codigo) != null){
                return sec.getNombreSeccion();
            }
        }
        return "";
    }

    /**
     * Elimina un producto por su código.
     * @param codigo Código del producto
     * @return true si se eliminó, false si no existe
     */
    public boolean eliminarProductoPorCodigo(int codigo){
        for (Seccion sec : secciones) {
            if(sec.getProductoCodigo(codigo) != null){
                sec.eliminarProducto(codigo);
                return true;
            }
        }
        return false;
    }

    /**
     * Cambia la sección de un producto.
     * @param codigoProducto Código del producto
     * @param nombreSeccionNueva Nueva sección donde mover el producto
     * @return true si se pudo cambiar, false si no existe
     */
    public boolean cambiarSeccionProducto(int codigoProducto,String nombreSeccionNueva){
        Producto buscado = this.getProductoEnSeccionPorCodigo(codigoProducto);
        if(buscado != null){
            this.eliminarProductoPorCodigo(codigoProducto);
            this.getSeccion(nombreSeccionNueva).agregarProducto(codigoProducto, buscado);
            return true;
        }else{
            return false;
        }
    }

    /**
     * Elimina todos los productos vencidos de todas las secciones.
     */
    public void eliminarProductosVencidos(){
        for(int i = 0; i < this.secciones.size();i++){
            this.secciones.get(i).eliminarProductosVencidosPorSeccion();
        }
    }

    /**
     * Lista todos los productos vencidos de todas las secciones.
     * @return String con todos los productos vencidos
     */
    public String listarProductosVencidos(){
        String text = "";
        for(Seccion i: this.secciones){
            text+= i.listarProductosVencidos();
        }
        return text;
    }

    /**
     * Devuelve una representación en String de toda la tienda y sus secciones.
     * @return String con todas las secciones y productos
     */
    @Override
    public String toString(){
        String text = "";
        for(Seccion i: this.secciones){
            text+= i.toString();
        }
        return text;
    }
}