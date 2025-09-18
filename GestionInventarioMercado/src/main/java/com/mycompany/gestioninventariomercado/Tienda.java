/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado;

import java.util.ArrayList;
import java.io.*;
import javax.swing.JTextArea;

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
    
    public Seccion getSeccion(String nombreSeccion){
        for(Seccion i: secciones){
            if(i.getNombreSeccion().equalsIgnoreCase(nombreSeccion)){
                return i;
            }
        }
        return null;
    }
    
    public ArrayList getListSecciones(){
        return secciones;
    }
    
    public void agregarSeccion(Seccion seccion){
        this.secciones.add(seccion);
    }
    
    public void printSecciones( JTextArea miniterminal ){
        for(Seccion i: secciones){
            miniterminal.append("Seccion: "+i.getNombreSeccion()+" \n");
        }
    }
    
    public void printTienda( JTextArea miniterminal ) throws IOException{
        for(Seccion i: secciones){
            System.out.println("Seccion: "+i.getNombreSeccion()+" \n");
            i.mostrarProductos(miniterminal);
            System.out.println("\n\n");
        }
    }
    
    public void guardarDatos(String archivo) throws IOException{
        BufferedWriter escritor = new BufferedWriter (new FileWriter(archivo));
        for (Seccion sec : secciones){
            escritor.write("Seccion;"+sec.getNombreSeccion());
            escritor.newLine();
            for (Integer key : sec.getProductos().keySet()) {
                Producto p = sec.getProductoCodigo(key);
                escritor.write("Producto;"+key+";"+p.getNombre()+";"+p.getCantidad()+";"+p.getPrecioVenta()+";"+p.getVendedor()+";"+p.getPrecioCompra());
                escritor.newLine();
            }
            escritor.newLine();
        }
        escritor.close();
    }
    
    public void cargarDatos(String archivo) throws IOException
    {
        BufferedReader lector = new BufferedReader(new FileReader(archivo));
        String linea;
        Seccion i = null;
        while ((linea=lector.readLine()) != null)
        {
            if(linea.isBlank()) continue;
            String[] datos = linea.split(";");
            if(datos[0].equals("Seccion"))
            {
                i = new Seccion(datos[1]);
                agregarSeccion(i);
            }
            else if (datos[0].equals("Producto") && i!= null)
            {
                int codigo = Integer.parseInt(datos[1]);
                String nombre= datos[2];
                int cantidad = Integer.parseInt(datos[3]);
                float precioVenta= Float.parseFloat(datos[4]);
                String vendedor = datos[5];
                float precioCompra = Float.parseFloat(datos[6]);
                Producto p = new Producto(nombre, cantidad, precioVenta, vendedor, precioCompra);
                i.agregarProducto(codigo,p);
            }
        }
    }
    
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
}
