/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado;
import com.mycompany.gestioninventariomercado.Transacciones.ItemCarrito;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 *
 * @author diazv
 */
public class ReporteExcel {
    public void generarReporte(String tipo, ArrayList<ItemCarrito> carrito) {
        Workbook workbook = new XSSFWorkbook(); /*Crea el excel*/
        Sheet sheet = workbook.createSheet("Reporte");

        
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Producto");
        header.createCell(1).setCellValue("Cantidad");
        header.createCell(2).setCellValue("Precio");

        
        Row row = sheet.createRow(1);
        row.createCell(0).setCellValue("Leche");
        row.createCell(1).setCellValue(10);
        row.createCell(2).setCellValue(1200);

        // Guardar archivo
        try (FileOutputStream fileOut = new FileOutputStream("Reporte.xlsx")) {
            workbook.write(fileOut);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
