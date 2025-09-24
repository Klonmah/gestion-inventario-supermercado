package com.mycompany.gestioninventariomercado;

import java.io.*;

/**
 *
 * @author matia
 */
        
public class GestionInventarioMercado {

    public static void main(String[] args) throws IOException {
        Tienda tienda = new Tienda("Tienda de juanita");
        tienda.cargarDatos("inventario.txt");
        VentanaMenuPrincipalGrafico ventanaPrincipal = new VentanaMenuPrincipalGrafico(tienda);
        ventanaPrincipal.setVisible(true);
        
  
    }
    
}

