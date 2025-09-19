/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado.Transacciones;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.mycompany.gestioninventariomercado.Tienda;
import com.mycompany.gestioninventariomercado.Transacciones.ItemCarrito;

/**
 *
 * @author diazv
 */
public class ReporteExcel {
    public void generarReporteCompra(Compra datosCompra,String nombreArchivo,Tienda tienda) {
        /*Valores definidos para las posiciones de los valores*/
        int columnaCantidad = 1;
        int columnaCodigo = 2;
        int columnaNombre = 3;
        int columnaValorUnitario = 6;
        int columnaValorTotal = 8;
        
        /*dato para ubicarse dentro de la tabla de productos*/
        int filaActual = 6;
        
        /*Creacion de la hoja de excel y un objeto para que el codigo sea más leible*/
        ItemCarrito item;
        Workbook workbook = new XSSFWorkbook(); /*Crea el excel*/
        Sheet hoja= workbook.createSheet(nombreArchivo);
   
        /*Titulo, fecha y nombre de tienda*/
        hoja.createRow(1).createCell(5).setCellValue("Compra De Productos");
        
        hoja.createRow(3).createCell(1).setCellValue("Tienda: " + tienda.getNombreTienda());
        hoja.createRow(4).createCell(1).setCellValue("Fecha: " + java.time.LocalDate.now().toString());
  
        
        /*Escritura de los datos de los productos*/
        for(int posicionCarrito = 0; posicionCarrito < datosCompra.getCarrito().size()+7; posicionCarrito++){
            item = datosCompra.getCarrito().get(posicionCarrito);
            /*Titulos para la tabla*/
            if(posicionCarrito == 0){
                hoja.createRow(filaActual).createCell(columnaCantidad).setCellValue("Cantidad");
                hoja.createRow(filaActual).createCell(columnaCodigo).setCellValue("Codigo");
                hoja.createRow(filaActual).createCell(columnaNombre).setCellValue("Nombre");
                hoja.createRow(filaActual).createCell(columnaValorUnitario).setCellValue("ValorUnitario");
                hoja.createRow(filaActual).createCell(columnaValorTotal).setCellValue("Total");
                filaActual++;
            }
            /*Datos del producto*/
            hoja.createRow(filaActual).createCell(columnaCantidad).setCellValue(item.getCantidad());
            hoja.createRow(filaActual).createCell(columnaCodigo).setCellValue(item.getProducto().getCodigo());
            hoja.createRow(filaActual).createCell(columnaNombre).setCellValue(item.getProducto().getNombre());
            hoja.createRow(filaActual).createCell(columnaValorUnitario).setCellValue(item.getProducto().getPrecioCompra());
            hoja.createRow(filaActual).createCell(columnaValorTotal).setCellValue(item.getProducto().getPrecioCompra()* item.getCantidad());
            
            filaActual++;
        }
        /*Datos finales, cantidad de todos los productos y el precio de todos los productos*/
        filaActual += 2;
        hoja.createRow(filaActual).createCell(columnaCantidad).setCellValue("Cantidad Total:" + datosCompra.getPrecioTotal());
        hoja.createRow(filaActual).createCell(columnaValorTotal).setCellValue("Total:" + datosCompra.getPrecioTotal());
        
        hoja.autoSizeColumn(0);
        
        try (FileOutputStream fileOut = new FileOutputStream(nombreArchivo + ".xlsx")) {
            workbook.write(fileOut);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
       public void generarReporteVenta(Venta datosCompra,String nombreArchivo,Tienda tienda) {
        /*Valores definidos para las posiciones de los valores*/
        int columnaCantidad = 1;
        int columnaCodigo = 2;
        int columnaNombre = 3;
        int columnaValorUnitario = 6;
        int columnaValorTotal = 8;
        
        /*dato para ubicarse dentro de la tabla de productos*/
        int filaActual = 6;
        
        /*Creacion de la hoja de excel y un objeto para que el codigo sea más leible*/
        ItemCarrito item;
        Workbook workbook = new XSSFWorkbook(); /*Crea el excel*/
        Sheet hoja= workbook.createSheet(nombreArchivo);
   
        /*Titulo, fecha y nombre de tienda*/
        hoja.createRow(1).createCell(5).setCellValue("Venta De Productos");
        
        hoja.createRow(3).createCell(1).setCellValue("Tienda: " + tienda.getNombreTienda());
        hoja.createRow(4).createCell(1).setCellValue("Fecha: " + java.time.LocalDate.now().toString());
  
        
        /*Escritura de los datos de los productos*/
        for(int posicionCarrito = 0; posicionCarrito < datosCompra.getCarrito().size()+7; posicionCarrito++){
            item = datosCompra.getCarrito().get(posicionCarrito);
            /*Titulos para la tabla*/
            if(posicionCarrito == 0){
                hoja.createRow(filaActual).createCell(columnaCantidad).setCellValue("Cantidad");
                hoja.createRow(filaActual).createCell(columnaCodigo).setCellValue("Codigo");
                hoja.createRow(filaActual).createCell(columnaNombre).setCellValue("Nombre");
                hoja.createRow(filaActual).createCell(columnaValorUnitario).setCellValue("ValorUnitario");
                hoja.createRow(filaActual).createCell(columnaValorTotal).setCellValue("Total");
                filaActual++;
            }
            /*Datos del producto*/
            hoja.createRow(filaActual).createCell(columnaCantidad).setCellValue(item.getCantidad());
            hoja.createRow(filaActual).createCell(columnaCodigo).setCellValue(item.getProducto().getCodigo());
            hoja.createRow(filaActual).createCell(columnaNombre).setCellValue(item.getProducto().getNombre());
            hoja.createRow(filaActual).createCell(columnaValorUnitario).setCellValue(item.getProducto().getPrecioVenta());
            hoja.createRow(filaActual).createCell(columnaValorTotal).setCellValue(item.getProducto().getPrecioVenta()* item.getCantidad());
            
            filaActual++;
        }
        /*Datos finales, cantidad de todos los productos y el precio de todos los productos*/
        filaActual += 2;
        hoja.createRow(filaActual).createCell(columnaCantidad).setCellValue("Cantidad Total:" + datosCompra.getPrecioTotal());
        hoja.createRow(filaActual).createCell(columnaValorTotal).setCellValue("Total:" + datosCompra.getPrecioTotal());
        
        hoja.autoSizeColumn(0);
        
        try (FileOutputStream fileOut = new FileOutputStream(nombreArchivo + ".xlsx")) {
            workbook.write(fileOut);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
