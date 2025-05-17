package com.ConversorDeMonedas.utilidades;

import java.util.List;
import java.util.Arrays;

public class ListaMonedas {
    private static final List<String> codigos = Arrays.asList(
            "ARS", "BOB", "BRL", "CLP", "COP", "PEN", "PYG", "UYU", "VES", "USD", "EUR"
    );

    private static final List<String> nombres = Arrays.asList(
            "Peso Argentino", "Boliviano", "Real Brasileño", "Peso Chileno", "Peso Colombiano",
            "Sol Peruano", "Guaraní Paraguayo", "Peso Uruguayo", "Bolívar Venezolano",
            "Dólar Estadounidense", "Euro"
    );

    public static void mostrarMonedas() {
        System.out.println("---------- Monedas Sudamericanas ----------");
        for (int i = 0; i < 9; i++) {
            System.out.printf("%2d. %s (%s)\n", i + 1, codigos.get(i), nombres.get(i));
        }
        System.out.println("-------------- Otras Monedas --------------");
        for (int i = 9; i < codigos.size(); i++) {
            System.out.printf("%2d. %s (%s)\n", i + 1, codigos.get(i), nombres.get(i));
        }
    }

    public static String obtenerCodigo(int index) {
        return codigos.get(index - 1); // índice del usuario empieza en 1
    }

    public static int totalMonedas() {
        return codigos.size();
    }
}
