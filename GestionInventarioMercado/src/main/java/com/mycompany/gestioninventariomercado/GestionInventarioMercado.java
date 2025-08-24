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
        Producto leche = new Producto( "Lechita Mumu",3, (float) 2.5,"Soprole",(float)1.1);
        Producto yogurt = new Producto("Yogurt Gurt-Sahur",3, (float) 2.5,"Colun", (float)1.1);
        lacteos.agregarProducto(011,leche);
        lacteos.agregarProducto(012,yogurt);
        tienda.agregarSeccion(lacteos);
        
        Seccion electronicos = new Seccion("Electronicos");
        Producto celular_moco = new Producto("Celular MOCO",10, (float) 400.0,"Samsung",(float)300.0);
        Producto consola_while = new Producto("Consola While",10, (float) 699.0,"Sony", (float)500.0);
        electronicos.agregarProducto(021,celular_moco);
        electronicos.agregarProducto(022,consola_while);
        tienda.agregarSeccion(electronicos);
        
        Seccion juguetes = new Seccion("Juguetes");
        Producto hugomon_tcg = new Producto("Hugomon TCG",200, (float) 5.9,"PokeCo",(float) 3.0);
        Producto aguaneitor = new Producto("Aguaneitor",49, (float) 50.9,"Hasbro",(float)30.9);
        juguetes.agregarProducto(031,hugomon_tcg);
        juguetes.agregarProducto(032,aguaneitor);
        tienda.agregarSeccion(juguetes);
        
        //FIN DATOS DE INICIO
        
        String ingresado;
        
        int opcion = -1;
        
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
                    /*variables y clases a usar*/
                    int codigo;
                    String nombre;
                    int cantidad;
                    float precioVenta;
                    String vendedor;
                    float precioCompra;
                    Seccion seccion;
                    Producto producto;
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
                        seccion.agregarProducto(codigo,producto);
                        
                    }
                    
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

//class Producto{
  //  private String[]nombresProducto;
    //private double[]preciosProducto;
    //public Producto(int tamaño){
       // nombresProducto = new String[tamaño];
        //preciosProducto = new double[tamaño];
    //}
//}
