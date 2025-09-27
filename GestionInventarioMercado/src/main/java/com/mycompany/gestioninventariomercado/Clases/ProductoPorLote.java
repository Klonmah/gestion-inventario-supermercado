/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioninventariomercado.Clases;



/**
 *
 * @author diazv
 */
public class ProductoPorLote extends Producto {
    /*Lote es que un producto venga en un packete de varios, por ejemplo un pack de 6 de leche de chocolate*/
    /*Cantidad de Productos que vienen en 1 lote de productos*/
    private int cantidadLote; 

    /*Constructor*/
    public ProductoPorLote(String nombreProducto, int cantidadProducto,
                           String vendedor, float precioCompra, int codigo,
                           int cantidadLote) {
        super(nombreProducto, cantidadProducto, vendedor, precioCompra, codigo);
        this.cantidadLote = cantidadLote;
    }
    public ProductoPorLote(){
        super("",0,"",0,0);
        this.cantidadLote = 0;
    }

    /*Getter*/
    public int getCantidadLote() {
        return cantidadLote;
    }
    /*Setters*/
    public void setCantidadLote(int cantidadLote) {
        this.cantidadLote = cantidadLote;
    }

    /*Sobrescribir aumentarStock para incrementar por lote*/
    @Override
    
    public void aumentarStock(int numeroLotes) {
        int cantidadTotal = numeroLotes * this.cantidadLote;
        super.aumentarStock(cantidadTotal);
    }

    public boolean esPosibleReducir(int numeroLotes){
        int cantidadTotal = numeroLotes * this.cantidadLote;
        if(cantidadTotal > this.getCantidad()){
            return false;
        }else{
            return true;
        }
    }
    
    /*Sobreescritura del reducir stock para que funcione por lotes y por fecha de vencimiento*/
    @Override
    /*Recordar: Usar el esPosibleReducir antes del reducir stock*/
    public void reducirStock(int numeroLotes) {
        
        int cantidadTotal = numeroLotes * this.cantidadLote;
        super.reducirStock(cantidadTotal);
        
    }

    @Override
    public String toString() {
        return super.toString() + ","+ "No Perecible" + "," + this.cantidadLote;
    }
}