package com.gapplabs.jurasicpark.processors;

import reactor.core.publisher.Flux;

public abstract class DataProcessor<T> {

    // Método principal de procesamiento que sigue el patrón Template Method
    public void processData(Flux<T> dataStream) {
        dataStream
                .doOnNext(this::validate) // Validar los datos
                .flatMap(this::process) // Procesar los datos
                .subscribe(this::publishResult, this::handleError); // Publicar el resultado o manejar errores
    }

    // Validación genérica de los datos
    protected void validate(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
    }

    // Método abstracto que cada subclase debe implementar
    protected abstract Flux<T> process(T data);

    // Publicación del resultado procesado
    protected void publishResult(T result) {
        System.out.println("Processed result: " + result);
    }

    // Manejo de errores durante el procesamiento
    protected void handleError(Throwable error) {
        System.err.println("Error processing data: " + error.getMessage());
    }
}
