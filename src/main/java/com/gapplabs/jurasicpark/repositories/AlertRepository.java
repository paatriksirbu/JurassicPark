package com.gapplabs.jurasicpark.repositories;

import com.gapplabs.jurasicpark.models.Alert;
import com.gapplabs.jurasicpark.models.Sensor;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import org.springframework.stereotype.Repository;

@Repository
public class AlertRepository {

    private final Firestore firestore;

    public AlertRepository(Firestore firestore) {
        this.firestore = firestore;
    }

    public ApiFuture<WriteResult> saveAlert(Alert alert) {
        return firestore.collection("alerts").document(alert.getId()).set(alert);
    }

    public ApiFuture<WriteResult> updateAlert(Alert alert) {
        return firestore.collection("alerts").document(alert.getId()).set(alert);
    }

    public ApiFuture<WriteResult> deleteAlert(String id) {
        return firestore.collection("alerts").document(id).delete();
    }

    public ApiFuture<QuerySnapshot> getAllAlerts() {
        return firestore.collection("alerts").get();
    }
}
