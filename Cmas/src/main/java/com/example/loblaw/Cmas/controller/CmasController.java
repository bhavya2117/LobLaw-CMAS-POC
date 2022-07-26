package com.example.loblaw.Cmas.controller;


import com.example.loblaw.Cmas.Entity.MigrationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

@RestController
public class CmasController {

    private static final RestTemplate restTemplate = new RestTemplate();

    @PostMapping(path = "/migration/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> startMigration(@PathVariable("id") int pcid) throws Exception {
        try {
            ResponseEntity<String> orderResponse = startOrderMigration(pcid);
            CompletableFuture<MigrationResponse> paymentResponse = startPaymentMigration(pcid);
            CompletableFuture<MigrationResponse> cartResponse = startCartMigration(pcid);
            CompletableFuture<MigrationResponse> profileResponse = startProfileMigration(pcid);

            System.out.println(1);
            HttpStatus mrOrder = orderResponse.getStatusCode();
            System.out.println(mrOrder);
            if (mrOrder.equals("200")) {
                System.out.println("order migration completed");
                MigrationResponse mrPayment = paymentResponse.get();
                if (mrPayment.equals("200")) {
                    System.out.println("payment migration completed");
                    MigrationResponse mrCart = cartResponse.get();
                    if (mrCart.equals("200")) {
                        System.out.println("cart migration completed");
                        MigrationResponse mrProfile = profileResponse.get();
                        if (mrProfile.equals("200")) {
                            System.out.println("profile migration completed");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private static CompletableFuture<MigrationResponse> startProfileMigration(int pcid) {
        CompletableFuture<MigrationResponse> completableFuture = new CompletableFuture<>();
        Executors.newCachedThreadPool().submit(() -> {
            completableFuture.complete(new MigrationResponse(200, "Migrated"));
            return null;
        });

        return completableFuture;
    }

    private static CompletableFuture<MigrationResponse> startCartMigration(int pcid) {
        CompletableFuture<MigrationResponse> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(5000);
            completableFuture.complete(new MigrationResponse(200, "Migrated"));
            return null;
        });
        return completableFuture;
    }

    private static CompletableFuture<MigrationResponse> startPaymentMigration(int pcid) {
        CompletableFuture<MigrationResponse> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(3000);
            completableFuture.complete(new MigrationResponse(200, "Migrated"));
            return null;
        });
        return completableFuture;
    }

    private static ResponseEntity<String> startOrderMigration(int pcid) throws
            InterruptedException {
        String url = "http://localhost:8082/migrations/order/"+pcid;
        ResponseEntity<String> result = restTemplate.getForObject(url, ResponseEntity.class);
        return result;
    }
}
