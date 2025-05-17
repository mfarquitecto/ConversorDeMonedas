package com.ConversorDeMonedas.historial;

import com.ConversorDeMonedas.modelos.OperacionCambio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HistorialConversiones {

    private final List<OperacionCambio> historial;

    public HistorialConversiones() {
        this.historial = new ArrayList<>();
    }

    public void agregarOperacion(OperacionCambio operacion) {
        historial.add(operacion);
    }

    public List<OperacionCambio> obtenerHistorial() {
        return Collections.unmodifiableList(historial);
    }

    public boolean estaVacio() {
        return historial.isEmpty();
    }

}
