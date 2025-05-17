package com.ConversorDeMonedas.api;

import com.ConversorDeMonedas.modelos.OperacionCambio;

import java.time.LocalDateTime;

public class ServicioConversion {

    private final ServicioTasas servicioTasas;

    public ServicioConversion() {
        this.servicioTasas = new ServicioTasas();
    }

    public OperacionCambio convertir(String monedaOrigen, String monedaDestino, double monto) {
        double tasa = servicioTasas.obtenerTasaCambio(monedaOrigen, monedaDestino);
        double resultado = monto * tasa;
        return new OperacionCambio(monedaOrigen, monedaDestino, monto, tasa, resultado, LocalDateTime.now());
    }
}
