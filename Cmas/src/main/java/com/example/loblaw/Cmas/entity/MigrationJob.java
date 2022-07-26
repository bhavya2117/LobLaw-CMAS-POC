package com.example.loblaw.Cmas.entity;

import com.google.api.client.util.DateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MigrationJob {

    private String tenantId;

    private ArrayList<String> customerList;

    private DateTime scheduledDateTime;
}