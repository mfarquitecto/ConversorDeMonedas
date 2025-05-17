package com.ConversorDeMonedas.consola;

import com.ConversorDeMonedas.api.ServicioConversion;
import com.ConversorDeMonedas.historial.HistorialConversiones;
import com.ConversorDeMonedas.utilidades.Color;
import com.ConversorDeMonedas.utilidades.ListaMonedas;
import com.ConversorDeMonedas.utilidades.ValidadorEntrada;

import java.util.Scanner;

public class MenuConversion {
    private final ServicioConversion servicioConversion;
    private final Scanner teclado;
    private final HistorialConversiones historial;

    public MenuConversion(Scanner teclado, HistorialConversiones historial) {
        this.teclado = teclado;
        this.historial = historial;
        this.servicioConversion = new ServicioConversion();
    }

    public void iniciar() {
        System.out.println(Color.CYAN + "*******************************************" + Color.RESET);
        System.out.println(Color.CYAN + "*            MONEDAS DE ORIGEN            *" + Color.RESET);
        System.out.println(Color.CYAN + "*******************************************" + Color.RESET);
        ListaMonedas.mostrarMonedas();
        System.out.println("\nINGRESE EL NUMERO DE LA MONEDA DE ORIGEN: ");
        int indexOrigen = ValidadorEntrada.leerOpcion(teclado, 1, ListaMonedas.totalMonedas());

        System.out.println(Color.CYAN + "\n*******************************************" + Color.RESET);
        System.out.println(Color.CYAN + "*            MONEDAS DE DESTINO           *" + Color.RESET);
        System.out.println(Color.CYAN + "*******************************************" + Color.RESET);


        ListaMonedas.mostrarMonedas();
        System.out.println("\nINGRESE EL NUMERO DE LA MONEDA DE DESTINO: ");
        int indexDestino = ValidadorEntrada.leerOpcion(teclado, 1, ListaMonedas.totalMonedas());

        System.out.println("\nINGRESE EL MONTO A CONVERTIR: ");
        double monto = ValidadorEntrada.leerMonto(teclado);

        String codigoOrigen = ListaMonedas.obtenerCodigo(indexOrigen);
        String codigoDestino = ListaMonedas.obtenerCodigo(indexDestino);

        System.out.printf(Color.AMARILLO + "\nCONVIRTIENDO %.2f %s a %s...\n", monto, codigoOrigen, codigoDestino + Color.RESET);

        try {
            var operacion = servicioConversion.convertir(codigoOrigen, codigoDestino, monto);

            System.out.println(Color.VERDE + "\n*******************************************");
            System.out.println("* RESULTADO DE LA OPERACION               *");
            System.out.printf ("  %.2f %s = %.2f %s           \n",
                               monto, codigoOrigen,
                              operacion.getResultado(), codigoDestino);
            System.out.println("*******************************************\n"+ Color.RESET);

            historial.agregarOperacion(operacion);
        } catch (Exception e) {
            System.out.println(Color.ROJO + "ERROR AL REALIZAR LA CONVERSION \n" + e.getMessage() + Color.RESET);
        }

    }
}
