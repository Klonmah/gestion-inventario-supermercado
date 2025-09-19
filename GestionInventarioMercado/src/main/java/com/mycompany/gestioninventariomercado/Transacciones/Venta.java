/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado.Transacciones;
import com.mycompany.gestioninventariomercado.Tienda;


/**
 *
 * @author diazv
 */
public class Venta extends Transaccion{
    
   
    @Override
    public void procesar(Tienda tienda, String nombreArchivo) {
        for (int i = 0; i < getCarrito().size(); i++) {
            ItemCarrito productoCarro = getCarrito().get(i);
            productoCarro.getProducto().reducirStock(productoCarro.getCantidad());   
        }
        ReporteExcel reporte= new ReporteExcel();
        reporte.generarReporteVenta(this, nombreArchivo, tienda);
        this.borrarCarrito();
        System.out.println("Compra procesada");
        
    }
    @Override
    public void añadirItem(ItemCarrito itemCarro){
        this.getCarrito().add(itemCarro);
        this.setCantidadProductos(this.getCantidadProductos()+ itemCarro.getCantidad());
        this.setPrecioTotal(this.getPrecioTotal()+ (itemCarro.getCantidad()* itemCarro.getProducto().getPrecioVenta()));
    }
    @Override
    public void eliminarItem(ItemCarrito itemCarro){
        for(int i = 0; i < this.getCarrito().size();i++){
            if(itemCarro == this.getCarrito().get(i)){
                this.setCantidadProductos(this.getCantidadProductos()- itemCarro.getCantidad());
                this.setPrecioTotal(this.getPrecioTotal()- (itemCarro.getCantidad()* itemCarro.getProducto().getPrecioVenta()));
                this.getCarrito().remove(i);
            }
        }
    }
    
}
