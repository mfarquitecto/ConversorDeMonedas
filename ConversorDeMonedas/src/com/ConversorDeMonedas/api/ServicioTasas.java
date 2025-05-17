package com.ConversorDeMonedas.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ServicioTasas {

    private static final String API_KEY = "xxxxxxxxxxxxxxxxxxx"; // REEMPLAZA CON TU PROPIA API KEY
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public double obtenerTasaCambio(String monedaOrigen, String monedaDestino) {
        try {
            String urlStr = BASE_URL + API_KEY + "/pair/" + monedaOrigen + "/" + monedaDestino;
            URL url = URI.create(urlStr).toURL();
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");

            int codigoRespuesta = conexion.getResponseCode();
            if (codigoRespuesta != 200) {
                throw new ApiException("Error En La Respuesta Del Servidor: " + codigoRespuesta);
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            StringBuilder respuesta = new StringBuilder();
            String linea;

            while ((linea = in.readLine()) != null) {
                respuesta.append(linea);
            }
            in.close();

            // GSON PARA PARSEo JSON
            JsonObject json = JsonParser.parseString(respuesta.toString()).getAsJsonObject();

            // VALIDACION
            String resultado = json.get("result").getAsString();
            if (!"success".equalsIgnoreCase(resultado)) {
                throw new ApiException("La API No Tuvo Una Respuesta Exitosa: " + resultado);
            }

            return json.get("conversion_rate").getAsDouble();

        } catch (Exception e) {
            throw new ApiException("No Se Pudo Obtener La Tasa De Cambio: " + e.getMessage(), e);
        }
    }
}
