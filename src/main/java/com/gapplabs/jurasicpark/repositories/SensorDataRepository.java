package com.gapplabs.jurasicpark.repositories;

import com.gapplabs.jurasicpark.models.SensorData;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import org.springframework.stereotype.Repository;

@Repository
public class SensorDataRepository {

    private final Firestore firestore;

    public SensorDataRepository(Firestore firestore) {
        this.firestore = firestore;
    }

    public ApiFuture<WriteResult> saveSensorData(SensorData sensorData) {
        return firestore.collection("sensorData").document(sensorData.getId()).set(sensorData);
    }

    public ApiFuture<WriteResult> updateSensorData(SensorData sensorData) {
        return firestore.collection("sensorData").document(sensorData.getId()).set(sensorData);
    }

    public ApiFuture<WriteResult> deleteSensorData(String id) {
        return firestore.collection("sensorData").document(id).delete();
    }

    public ApiFuture<QuerySnapshot> getAllSensorData() {
        return firestore.collection("sensorData").get();
    }
}
