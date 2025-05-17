package com.ConversorDeMonedas.consola;

import com.ConversorDeMonedas.utilidades.ValidadorEntrada;
import com.ConversorDeMonedas.utilidades.Color;
import com.ConversorDeMonedas.historial.HistorialConversiones;
import com.ConversorDeMonedas.modelos.OperacionCambio;

import java.util.Scanner;

public class Main {

    private static final Scanner teclado = new Scanner(System.in);
    private static final HistorialConversiones historial = new HistorialConversiones();

    public static void main(String[] args) {
        boolean continuar = true;

        mostrarMenuConLogo();

        while (continuar) {
            mostrarMenuPrincipal();
            int opcion = ValidadorEntrada.leerOpcion(teclado, 1, 3);

            switch (opcion) {
                case 1 -> new MenuConversion(teclado, historial).iniciar();
                case 2 -> mostrarHistorial();
                case 3 -> {
                    System.out.println(Color.VERDE + "***** ¡GRACIAS POR USAR ESTE CONVERSOR DE MONEDAS! ******" + Color.RESET);
                    continuar = false;
                }
            }
        }
    }

    public static void mostrarMenuConLogo() {
                String logo = """
                 ______
                |      .-----.-----.--.--.-----.----.-----.-----.----.
                |   ---|  _  |     |  |  |  -__|   _|__ --|  _  |   _|
                |______|_____|__|__|\\___/|_____|__| |_____|_____|__|
                .--|  |-----|   |   |-----.-----.-----.--|  |---.-.-----.
                |  _  |  -__|       |  _  |     |  -__|  _  |  _  |__ --|
                |_____|_____|__|_|__|_____|__|__|_____|_____|___._|______
                """;
        System.out.println(Color.CYAN + logo + Color.RESET);
    }

    public static void mostrarMenuPrincipal() {
        System.out.println(Color.MAGENTA + "*********************************************************");
        System.out.println("* BIENVENIDOS(AS) AL CONVERSOR DE MONEDAS SUDAMERICANAS *");
        System.out.println("*********************************************************\n" + Color.RESET);
        System.out.println(Color.AZUL + "1. REALIZAR CONVERSION DE MONEDAS");
        System.out.println("2. VER HISTORIAL DE CONVERSIONES");
        System.out.println("3. SALIR\n" + Color.RESET);
        System.out.println(Color.MAGENTA + "*********************************************************\n" + Color.RESET);
        System.out.println("INGRESE EL NUMERO DE LA OPCION DESEADA: ");
    }

    public static void mostrarHistorial() {
        if (historial.estaVacio()) {
            System.out.println(Color.AMARILLO + "AUN NO EXISTEN CONVERSIONES REALIZADAS\n" + Color.RESET);
            return;
        }

        System.out.println(Color.CYAN + "\n*********************************************************");
        System.out.println( "*               HISTORIAL DE CONVERSIONES               *");
        System.out.println( "*********************************************************" + Color.RESET);

        for (OperacionCambio op : historial.obtenerHistorial()) {
            System.out.printf("%s → %s | Monto: %.2f | Resultado: %.2f | Tasa: %.4f | Fecha: %s\n",
                    op.getMonedaOrigen(),
                    op.getMonedaDestino(),
                    op.getMonto(),
                    op.getResultado(),
                    op.getTasa(),
                    op.getFechaFormateada()
            );
        }
        System.out.println();
    }
}




