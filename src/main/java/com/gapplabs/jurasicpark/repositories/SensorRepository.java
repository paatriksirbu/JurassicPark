package com.gapplabs.jurasicpark.repositories;

import com.gapplabs.jurasicpark.models.Sensor;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import org.springframework.stereotype.Repository;

@Repository
public class SensorRepository {

    private final Firestore firestore;

    public SensorRepository(Firestore firestore) {
        this.firestore = firestore;
    }

    public ApiFuture<WriteResult> saveSensor(Sensor sensor) {
        return firestore.collection("sensors").document(sensor.getId()).set(sensor);
    }

    public ApiFuture<WriteResult> updateSensor(Sensor sensor) {
        return firestore.collection("sensors").document(sensor.getId()).set(sensor);
    }

    public ApiFuture<WriteResult> deleteSensor(String id) {
        return firestore.collection("sensors").document(id).delete();
    }

    public ApiFuture<QuerySnapshot> getAllSensors() {
        return firestore.collection("sensors").get();
    }
}
