// AlertStrategy.java
package com.gapplabs.jurasicpark.strategies;

import reactor.core.publisher.Flux;

public interface AlertStrategy {
    void processData(Flux<Number> dataStream);  // Método para procesar el flujo de datos y emitir alertas.
}
