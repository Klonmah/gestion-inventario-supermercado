package com.mycompany.gestioninventariomercado;

import java.io.*;

/**
 *
 * @author matia
 */
        
public class GestionInventarioMercado {

    public static void main(String[] args) throws IOException {
        Tienda tienda = new Tienda("Supermerca dos");
        String ingresado;
        int opcion = -1;
        
        while(opcion != 0){
            System.out.println("----------SISTEMA DE GESTION DE INVENTARIO----------\n\n");
            System.out.println("1: Agregar Producto\n");
            System.out.println("2: Comprar Producto\n");
            System.out.println("3: Vender Producto\n");
            System.out.println("4: Listar Productos\n");
            System.out.println("5: Buscar Producto\n");
            System.out.println("6: Eliminar Producto\n");
            System.out.println("7: Agregar Seccion\n");
            System.out.println("8: Eliminar Seccion\n");
            System.out.println("0: Salir\n");
            
            BufferedReader lector = new BufferedReader (new InputStreamReader(System.in));
            ingresado = lector.readLine();
            opcion = Integer.parseInt(ingresado);
            
            switch(opcion){
                case 1:
                    tienda.printSecciones();
                    
                    break;
            }    
            
            
        }
        
        
    }
}

//class Producto{
  //  private String[]nombresProducto;
    //private double[]preciosProducto;
    //public Producto(int tamaño){
       // nombresProducto = new String[tamaño];
        //preciosProducto = new double[tamaño];
    //}
//}
