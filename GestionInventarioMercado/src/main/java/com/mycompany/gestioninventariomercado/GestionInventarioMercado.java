package com.mycompany.gestioninventariomercado;

import java.io.*;

/**
 *
 * @author matia
 */
        
public class GestionInventarioMercado {

    public static void main(String[] args) throws IOException {
        
        /* PARA RESTAURAR EL CODIGO (LA TERMINAL ANTERIOR) BORRA LAS LINEAS CON ---------%
        Tienda tienda = new Tienda("Supermerca dos");
        
        //DATOS DE INICIO
        
        File archivo = new File("inventario.txt");
        if(archivo.exists()){
            tienda.cargarDatos("inventario.txt");
            System.out.println("Datos cargados desde archivo");
        }
        
        //FIN DATOS DE INICIO
        
        String ingresado;
        -------------------------------------------------------------------------------------------------%*/
        VentanaMenuGestion ventanaprincipal = new VentanaMenuGestion();
        ventanaprincipal.setVisible(true);
        
        
        
        /*variables y clases a usar*/
        /*-------------------------------------------------------------------------------------------------%
        int opcion = -1;
        boolean idiommenu = true; /*true Espaniol, false Ingles*/
        /*-------------------------------------------------------------------------------------------------%
        int codigo;
        String nombre;
        int cantidad;
        float precioVenta;
        String vendedor;
        float precioCompra;
        Seccion seccion;
        Producto producto;
        
        
        while(opcion != 0){
            if ( idiommenu ) {
                System.out.println("----------SISTEMA DE GESTION DE INVENTARIO----------\n\n");
                System.out.println("1: Agregar Producto");
                System.out.println("2: Comprar Producto");
                System.out.println("3: Vender Producto");
                System.out.println("4: Listar Productos");
                System.out.println("5: Buscar Producto");
                System.out.println("6: Eliminar Producto");
                System.out.println("7: Agregar Seccion");
                System.out.println("8: Eliminar Seccion");
                System.out.println("9: Change Language");
                System.out.println("0: Salir\n");
            } else{
                System.out.println("----------INVENTORY MANAGEMENT SYSTEM----------\n\n");
                System.out.println("1: Add Product");
                System.out.println("2: Buy Product");
                System.out.println("3: Sell Product");
                System.out.println("4: List Products");
                System.out.println("5: Search Products");
                System.out.println("6: Erase Products");
                System.out.println("7: Add Section");
                System.out.println("8: Erase Section");
                System.out.println("9: Cambiar Idioma");
                System.out.println("0: Exit\n");
            }
            /*
            BufferedReader lector = new BufferedReader (new InputStreamReader(System.in));
            ingresado = lector.readLine();
            ingresado = ingresado.trim()
            if (ingresado.equals("")) 
            {
                ingresado = "0";
            }
            */
            
            // lector para carácteres
            /*-------------------------------------------------------------------------------------------------%
            BufferedReader lector = new BufferedReader (new InputStreamReader(System.in));
            
            //lectura para enteros
            lectorseguro lectorInts = new lectorseguro();
        
            opcion = lectorInts.leer(idiommenu);
            
            /*
            if ( idiommenu ) { }else{
            }
            */
            /*-------------------------------------------------------------------------------------------------%
            switch(opcion){
                case 1:
                    tienda.printSecciones();
                    if ( idiommenu ) { System.out.println("Ingrese de Que seccion es el Producto que desea Ingresar:");}else{
                    System.out.println("Enter the section of the product you wish to enter:");}
                    
                    seccion = tienda.getSeccion(lector.readLine());
                    if(seccion == null){
                        if ( idiommenu ) { System.out.println("Error: Seccion no encontrada");}else{
                        System.out.println("Error: Section not found"); }
                        
                    }else{
                        if ( idiommenu ) { System.out.println("Ingrese Codigo del producto:");}else{
                        System.out.println("Enter product code:"); }
                        codigo = Integer.parseInt(lector.readLine());
                        
                        if ( idiommenu ) { System.out.println("Ingrese Nombre del producto:");}else{
                        System.out.println("Enter Product Name:"); }
                        nombre = lector.readLine();
                        
                        if ( idiommenu ) {System.out.println("Ingrese Cantidad de productos en Stock:"); }else{
                        System.out.println("Enter Quantity of products in Stock:"); }
                        cantidad = Integer.parseInt(lector.readLine());
                        
                        if ( idiommenu ) {System.out.println("Ingrese Precio de Venta:"); }else{
                        System.out.println("Enter Selling Price:"); }
                        
                        precioVenta = Float.parseFloat(lector.readLine());
                        
                        if ( idiommenu ) {System.out.println("Ingrese Nombre de Vendedor:"); }else{
                        System.out.println("Enter Vendor Name:"); }
                        vendedor = lector.readLine();
                        
                        if ( idiommenu ) {System.out.println("Ingrese precio de Compra(Precio que se compra el producto al vendedor):"); }else{
                        System.out.println("Enter the Purchase Price (Price at which the product is purchased from the seller):"); }
                        precioCompra = Float.parseFloat(lector.readLine());
                        
                        producto = new Producto(nombre,cantidad,precioVenta,vendedor,precioCompra);
                        tienda.getSeccion(seccion.getNombreSeccion()).agregarProducto(codigo, producto);
                        
                    }
                    
                    break;
                
                case 2:
                    if ( idiommenu ) { System.out.println("Ingrese Codigo del producto que desea comprar:");}else{
                    System.out.println("Enter the code of the product you wish to purchase:"); }
                    codigo = Integer.parseInt(lector.readLine());
                    Producto productocompra = tienda.getProductoEnSeccionPorCodigo(codigo);
                    System.out.println(productocompra.toString());
                    
                    break;
                case 4:
                    tienda.printTienda();
                    
                    break;
                case 9:
                    idiommenu = !idiommenu;
                    
                    break;
                case 0:
                    tienda.guardarDatos("inventario.txt");
                    
                    break;
            }    
            
            if ( idiommenu ) { System.out.println("Desea Hacer Otra Operacion?\n");}else{
            System.out.println("Would you like to make another operation?\n");}
            
            System.out.println("0: No\n");
            if ( idiommenu ) { System.out.println("Cualquier otro numero: Si\n");}else{
            System.out.println("Any other number: Yes\n"); }
            
            opcion = lectorInts.leer(idiommenu);
            
            if(opcion==0)tienda.guardarDatos("inventario.txt");
        }
        -------------------------------------------------------------------------------------------------%*/
        
    }
    
}

