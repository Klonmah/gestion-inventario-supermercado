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
        
        File archivo = new File("inventario.txt");
        if(archivo.exists()){
            tienda.cargarDatos("inventario.txt");
            System.out.println("Datos cargados desde archivo");
        }
        
        //FIN DATOS DE INICIO
        
        String ingresado;

        /*variables y clases a usar*/
        int opcion = -1;
        int codigo;
        String nombre;
        int cantidad;
        float precioVenta;
        String vendedor;
        float precioCompra;
        Seccion seccion;
        Producto producto;
        
        
        
        while(opcion != 0){
            System.out.println("----------SISTEMA DE GESTION DE INVENTARIO----------\n\n");
            System.out.println("1: Agregar Producto");
            System.out.println("2: Comprar Producto");
            System.out.println("3: Vender Producto");
            System.out.println("4: Listar Productos");
            System.out.println("5: Buscar Producto");
            System.out.println("6: Eliminar Producto");
            System.out.println("7: Agregar Seccion");
            System.out.println("8: Eliminar Seccion");
            System.out.println("0: Salir\n");
            
            BufferedReader lector = new BufferedReader (new InputStreamReader(System.in));
            ingresado = lector.readLine();
            opcion = Integer.parseInt(ingresado);
            
            switch(opcion){
                case 1:
                    tienda.printSecciones();
                    System.out.println("Ingrese de Que seccion es el Producto que desea Ingresar:");
                    
                    seccion = tienda.getSeccion(lector.readLine());
                    if(seccion == null){
                        System.out.println("Error: Seccion no encontrada");
                    }else{
                        System.out.println("Ingrese Codigo del producto:");
                        codigo = Integer.parseInt(lector.readLine());
                        System.out.println("Ingrese Nombre del producto:");
                        nombre = lector.readLine();
                        System.out.println("Ingrese Cantidad de productos en Stock:");
                        cantidad = Integer.parseInt(lector.readLine());
                        System.out.println("Ingrese Precio de Venta:");
                        precioVenta = Float.parseFloat(lector.readLine());
                        System.out.println("Ingrese Nombre de Vendedor:");
                        vendedor = lector.readLine();
                        System.out.println("Ingrese precio de Compra(Precio que se compra el producto al vendedor):");
                        precioCompra = Float.parseFloat(lector.readLine());
                        producto = new Producto(nombre,cantidad,precioVenta,vendedor,precioCompra);
                        tienda.getSeccion(seccion.getNombreSeccion()).agregarProducto(codigo, producto);
                        
                    }
                    
                    break;
                
                case 2:
                    System.out.println("Ingrese Codigo del producto que desea comprar:");
                    codigo = Integer.parseInt(lector.readLine());
                    
                    
                    break;
                case 4:
                    tienda.printTienda();
                    
                    break;
            }    
            
            System.out.println("Desea Hacer Otra Operacion?\n");
            System.out.println("0: No\n");
            System.out.println("Cualqier otro numero: Si\n");
            ingresado = lector.readLine();
            opcion = Integer.parseInt(ingresado);
            
        }
        
    }
    
}

