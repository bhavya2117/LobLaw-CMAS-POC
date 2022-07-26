package com.example.loblaw.Cmas.controller;

import com.example.loblaw.Cmas.entity.MigrationJob;
import com.example.loblaw.Cmas.service.MigrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class MigrationController {

    @Autowired
    private MigrationService migrationService;

    @PostMapping("/post")
    public String postFeedData(@RequestBody MigrationJob migrationJob) throws ExecutionException, InterruptedException {

        return migrationService.saveMigrationJobData(migrationJob);
    }

}
