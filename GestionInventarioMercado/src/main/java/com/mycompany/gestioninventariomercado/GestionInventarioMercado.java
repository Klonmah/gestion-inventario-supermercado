package com.mycompany.gestioninventariomercado;

import com.mycompany.gestioninventariomercado.Clases.Tienda;
import java.io.*;

/**
 * Clase principal del proyecto de gestión de inventario de mercado.
 * Se encarga de inicializar la tienda, cargar los datos desde un archivo
 * y mostrar la ventana principal de la interfaz gráfica.
 * 
 * Autor: matia
 */
public class GestionInventarioMercado {

    /**
     * Método principal que inicia la aplicación.
     * 
     * @param args Argumentos de línea de comando (no se usan)
     * @throws IOException Si ocurre un error al cargar los datos del archivo
     */
    public static void main(String[] args) throws IOException {
        Tienda tienda = new Tienda("Tienda de juanita");
        tienda.cargarDatos("inventario.txt");
        VentanaMenuPrincipalGrafico ventanaPrincipal = new VentanaMenuPrincipalGrafico(tienda);
        ventanaPrincipal.setVisible(true);
    }
}