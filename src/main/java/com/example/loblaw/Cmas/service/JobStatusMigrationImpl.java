package com.example.loblaw.Cmas.service;

import com.example.loblaw.Cmas.Entity.MigrationResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.cloudscheduler.v1.CloudScheduler;
import com.google.api.services.cloudscheduler.v1.model.Job;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;

//public class JobStatusMigrationImpl implements JobStatusMigration{
//    @Override
//    public CloudScheduler cloudTaskScheduler(Long id){
//        try (CloudSchedulerClient cloudSchedulerClient = CloudSchedulerClient.create()) {
//            JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");
//            Job response = cloudSchedulerClient.getJob(name);
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//        return ;
//    }
//}

