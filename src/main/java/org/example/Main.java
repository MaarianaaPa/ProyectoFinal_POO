package org.example;
import org.example.Controlador.ControladorPCuerpoHumano;
import org.example.Vista.Ventana;

public class Main {
    public static void main(String[] args) {
        Ventana view = new Ventana("Partes del Cuepo");
        ControladorPCuerpoHumano controladorPCuerpoHumano = new ControladorPCuerpoHumano(view);
    }
}