package com.ConversorDeMonedas.utilidades;

import java.util.Scanner;

public class ValidadorEntrada {

    public static int leerOpcion(Scanner teclado, int min, int max) {
        while (true) {
            try {
                int opcion = Integer.parseInt(teclado.nextLine().trim());
                if (opcion >= min && opcion <= max) {
                    return opcion;
                } else {
                    System.out.println(Color.ROJO + "- Opción Fuera De Rango -" + Color.RESET);
                    System.out.println("INGRESE EL NUMERO DE LA OPCION DESEADA: ");
                }
            } catch (NumberFormatException e) {
                    System.out.println(Color.ROJO + "- Entrada Inválida. Ingrese Un Número -" + Color.RESET);
                    System.out.println("INGRESE EL NUMERO DE LA OPCION DESEADA: ");
            }
        }
    }

    public static double leerMonto(Scanner teclado) {
        while (true) {
            try {
                double monto = Double.parseDouble(teclado.nextLine().trim());
                if (monto > 0) {
                    return monto;
                } else {
                    System.out.println(Color.ROJO + "- El Monto Debe Ser Mayor Que Cero -"+ Color.RESET);
                    System.out.println("INGRESE EL MONTO A CONVERTIR");
                }
            } catch (NumberFormatException e) {
                System.out.println(Color.ROJO + "- Entrada Inválida. Ingrese Un Número -" + Color.RESET);
                System.out.println("INGRESE EL MONTO A CONVERTIR");
            }
        }
    }
}
