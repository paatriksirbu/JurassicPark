package com.gapplabs.jurasicpark.exceptions;

public class AlertThresholdExceededException extends RuntimeException {
    public AlertThresholdExceededException(String message) {
        super(message);
    }
}
