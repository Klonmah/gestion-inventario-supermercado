package com.mycompany.gestioninventariomercado;

import java.io.*;

/**
 *
 * @author matia
 */
        
public class GestionInventarioMercado {

    public static void main(String[] args) throws IOException {
        Tienda tienda = new Tienda("Supermerca dos");
        
        //DATOS DE INICIO
        
        Seccion lacteos = new Seccion("Lacteos");
        Producto leche = new Producto(011, "Lechita Mumu",3, (float) 2.5);
        Producto yogurt = new Producto(012, "Yogurt Gurt-Sahur",3, (float) 2.5);
        lacteos.agregarProducto(leche);
        lacteos.agregarProducto(yogurt);
        tienda.agregarSeccion(lacteos);
        
        Seccion electronicos = new Seccion("Electronicos");
        Producto celular_moco = new Producto(021, "Celular MOCO",10, (float) 400.0);
        Producto consola_while = new Producto(022, "Consola While",10, (float) 699.0);
        electronicos.agregarProducto(celular_moco);
        electronicos.agregarProducto(consola_while);
        tienda.agregarSeccion(electronicos);
        
        Seccion juguetes = new Seccion("Juguetes");
        Producto hugomon_tcg = new Producto(031, "Hugomon TCG",200, (float) 5.9);
        Producto aguaneitor = new Producto(032, "Aguaneitor",49, (float) 50.9);
        juguetes.agregarProducto(hugomon_tcg);
        juguetes.agregarProducto(aguaneitor);
        tienda.agregarSeccion(juguetes);
        
        //FIN DATOS DE INICIO
        
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
                case 4:
                    tienda.printTienda();
                    
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
