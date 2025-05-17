package com.ConversorDeMonedas.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OperacionCambio {

    private final String monedaOrigen;
    private final String monedaDestino;
    private final double monto;
    private final double tasa;
    private final double resultado;
    private final LocalDateTime fechaHora;

    public OperacionCambio(String monedaOrigen, String monedaDestino, double monto, double tasa, double resultado, LocalDateTime fechaHora) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.monto = monto;
        this.tasa = tasa;
        this.resultado = resultado;
        this.fechaHora = fechaHora;
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public double getMonto() {
        return monto;
    }

    public double getTasa() {
        return tasa;
    }

    public double getResultado() {
        return resultado;
    }

    public String getFechaFormateada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return fechaHora.format(formatter);
    }
}
