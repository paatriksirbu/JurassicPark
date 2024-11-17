# Caso Práctico Tema4: Implementación de un Sistema de Monitoreo Reactivo en Jurassic Park
### Link al repositorio: https://github.com/paatriksirbu/JurassicPark.git

### **Descripción**
El sistema avanzado de monitoreo de actividad de dinosaurios para **Jurassic Park** utiliza programación reactiva con **Spring WebFlux** para gestionar múltiples flujos de datos de sensores en tiempo real. Diseñado para garantizar eficiencia, escalabilidad y capacidad de respuesta, este sistema maneja datos de sensores de movimiento, temperatura y frecuencia cardíaca, asegurando una supervisión confiable y precisa del parque.
---

## **Requerimientos**
El sistema debe:
- Procesar grandes volúmenes de datos en tiempo real de diferentes tipos de sensores.
- Gestionar flujos de datos concurrentes utilizando **Spring WebFlux**.
- Implementar mecanismos de **backpressure** para garantizar la consistencia y evitar sobrecarga.
- Enviar alertas inmediatas y permitir una visualización eficiente de datos.
- Mantener alto rendimiento y confiabilidad, con monitoreo y registros eficientes.

## **Solución Propuesta**

### **1. Configuración del Proyecto**
- Proyecto basado en **Spring Boot**.
- Dependencias clave:
  - `spring-boot-starter-webflux` para programación reactiva.
  - `spring-boot-starter-actuator` para monitorización.
  - `projectreactor` para manejar flujos de datos con **Flux** y **Mono**.

### **2. Gestión de Sensores**
- Cada tipo de sensor (movimiento, temperatura, frecuencia cardíaca) se modela como un **bean**.
- Uso del principio de **Inversión de Control (IoC)**.
- Integración de flujos de datos con **Flux** y **Mono**.

### **3. Procesamiento Concurrente**
- Implementación de procesamiento concurrente con **Schedulers**.
- Servicios que manejan la lógica de negocio de cada tipo de dato utilizando programación no bloqueante.

### **4. Backpressure y Comunicación**
- Uso de:
  - `onBackpressureDrop` para descartar datos no procesados si la presión es alta.
  - `onBackpressureBuffer` para almacenar datos temporalmente en búfer.
- Gestión eficiente de la presión en los flujos de datos para evitar cuellos de botella.

### **5. Monitorización y Logs**
- **Spring Actuator** para monitorización de endpoints y estado del sistema.
- **Logging** eficiente con niveles de depuración configurados según el flujo:
  - Información básica del sistema.
  - Eventos críticos en el procesamiento.

---
## **Arquitectura del Proyecto**
La arquitectura está organizada según principios de diseño limpio, utilizando patrones de diseño como **Observer** y **Strategy**:
- `aspects`: Gestión de aspectos transversales (AOP).
- `config`: Configuración del proyecto (e.g., configuración de Firebase, WebFlux).
- `exceptions` y `exceptions.handlers`: Gestión centralizada de errores y excepciones.
- `controllers`: Controladores REST para exposición de datos.
- `enums`: Enumeraciones para niveles de alerta, estados y tipos de sensores.
- `models`: Modelos de datos:
  - `models.Types.Dinos`: Tipos específicos de dinosaurios.
  - `models.Types.Islands`: Tipos específicos de islas.
- `observers`: Implementación del patrón Observer para la gestión de alertas.
- `processor`: Lógica de procesamiento central de los flujos.
- `repositories`: Gestión de persistencia y acceso a datos.
- `services`: Servicios que encapsulan la lógica de negocio.
- `strategies`: Implementación del patrón Strategy para comportamientos específicos.
- `utils`: Utilidades auxiliares para soporte general.

---
