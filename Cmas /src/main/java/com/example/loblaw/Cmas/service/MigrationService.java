package com.example.loblaw.Cmas.service;

import com.example.loblaw.Cmas.entity.MigrationJob;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class MigrationService {
    private static final String COLLECTION_NAME = "migration";

    public String saveMigrationJobData(MigrationJob migrationJob) throws ExecutionException, InterruptedException {
        Firestore dbFirestone= FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture =dbFirestone.collection(COLLECTION_NAME).document().set(migrationJob);
        return collectionApiFuture.get().getUpdateTime().toString();
    }

}
