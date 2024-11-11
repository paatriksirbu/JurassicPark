package com.gapplabs.jurasicpark.strategies;

public class AlertStrategy {

    //Clase AlertStrategy para definir la estrategia de alerta

    private String alertMessage;

    public AlertStrategy(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public void execute() {
        System.out.println(alertMessage);
    }


}
