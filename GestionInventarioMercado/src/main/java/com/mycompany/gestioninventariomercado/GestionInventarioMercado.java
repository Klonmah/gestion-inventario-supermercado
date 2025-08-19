package com.mycompany.gestioninventariomercado;

import java.io.*;

/**
 *
 * @author matia
 */
        
public class GestionInventarioMercado {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

class Producto{
    private String[]nombresProducto;
    private double[]preciosProducto;
    public Producto(int tamaño){
        nombresProducto = new String[tamaño];
        preciosProducto = new double[tamaño];
    }
}
