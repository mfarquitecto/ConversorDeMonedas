## 💱Conversor de Monedas Sudamericanas💱

Este es un `CONVERSOR DE MONEDAS DE CONSOLA` que permite realizar conversiones entre monedas, principalmente Sudamericanas. Utiliza las tasas de cambio proporcionadas por la API [Exchangerate-API](https://www.exchangerate-api.com/). Además de guardar un historial de las conversiones realizadas.



## 📋 Características

- Conversión entre múltiples divisas.
- Obtención de tasas de cambio en tiempo real desde ExchangeRate API.
- Historial de las conversiones realizadas.
- Interfaz sencilla y colorida basada en Consola.
- Uso de la librería Gson para parseo de JSON.
- Manejo básico de errores de conexión o datos inválidos.



## 🔧 Requisitos

- Java (versión 21 o superior).
- Una cuenta en [Exchange Rate API](https://www.exchangerate-api.com/) para obtener tu API Key gratuita.
- Librería [Gson](https://github.com/google/gson) de Google.



## ⚙️ Instalación

  **1. Clona el repositorio**

```bash
git clone https://github.com/mfarquitecto/Conversor-De-Monedas.git

```

  **2. Obtén tu API Key**

Ve a [ExchangeRate API](https://www.exchangerate-api.com/) y regístrate para obtener una API key gratuita.

Una vez que tengas tu API Key, reemplaza la clave de ejemplo con tu propia clave,

en la clase `com.ConversorDeMonedas.api.ServicioTasas.java` 

```java
private static final String API_KEY = "TU_API_KEY_AQUI"; // Reemplaza con tu propia API Key

```

  **3. Compila y Ejecuta el Proyecto**

Abre terminal o símbolo del sistema, navega al directorio donde se encuentran los archivos `.java` y compila el proyecto utilizando el compilador de Java:

```bash
javac com/ConversorDeMonedas.java
```

Una vez compilado el proyecto, puedes ejecutar la aplicación principal `Main.java`.

```bash
java com.ConversorDeMonedas.consola.Main
```



## 🚀 Cómo utilizar

El programa te guiará a través de la consola, pidiéndote que ingreses la moneda de origen, la moneda de destino y la cantidad a convertir. Consultará la Exchange Rate API para obtener la tasa de cambio actual y mostrará el resultado de la conversión solicitada.

```bash
______
|      .-----.-----.--.--.-----.----.-----.-----.----.
|   ---|  _  |     |  |  |  -__|   _|__ --|  _  |   _|
|______|_____|__|__|\___/|_____|__| |_____|_____|__|
.--|  |-----|   |   |-----.-----.-----.--|  |---.-.-----.
|  _  |  -__|       |  _  |     |  -__|  _  |  _  |__ --|
|_____|_____|__|_|__|_____|__|__|_____|_____|___._|______

*********************************************************
* BIENVENIDOS(AS) AL CONVERSOR DE MONEDAS SUDAMERICANAS *
*********************************************************

1. REALIZAR CONVERSION DE MONEDAS
2. VER HISTORIAL DE CONVERSIONES
3. SALIR

*********************************************************
```
Ejemplo:

```
INGRESE LA MONEDA DE ORIGEN:
> USD (Dólar Estadounidense)

INGRESE LA MONEDA DE DESTINO:
> CLP (Pesos Chilenos)

INGRESE EL MONTO:
> 1
```

Salida:

```
CONVIRTIENDO 1.00 USD a CLP...

*******************************************
*.        RESULTADO DE LA OPERACION       *
           1.00 USD = 940.01 CLP           
*******************************************
```




## 📁 Estructura del Proyecto

```shell
📁 ConversorDeMonedas/
 ├── 📁 api/
 │    ├── ApiException.java
 │    ├── ServicioConversion.java
 │    └── ServicioTasas.java
 ├── 📁 consola/
 │    ├── Main.java
 │    └── MenuConversion.java
 ├── 📁 historial/
 │    └── HistorialConversiones.java
 ├── 📁 modelos/
 │    └── OperacionCambio.java
 └── 📁 utilidades/
      ├── Color.java
      ├── ListaMonedas.java
      └── ValidadorEntrada.java
```



## ✅ Posibles Mejoras futuras

- Implementación de una interfaz gráfica de usuario (GUI).
- Permitir al usuario configurar las monedas preferidas.
- Soporte offline con tasas en caché



## ✍️ Autor

[![mfarquitecto](https://github.com/mfarquitecto.png?size=65)](https://github.com/mfarquitecto)  

##### [mfarquitecto](https://github.com/mfarquitecto)

Proyecto realizado para la **Formación en Java** de *Alura Latam.*



## 📄 Licencia

Este proyecto está bajo la licencia MIT.