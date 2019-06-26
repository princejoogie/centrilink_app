package com.example.centrilink;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {

    CardView profile;
    CardView medicalHistory;
    CardView medicalPrescription;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        profile = findViewById(R.id.profile_view);
        medicalHistory = findViewById(R.id.records_view);
        medicalPrescription = findViewById(R.id.prescription_view);
        logout = findViewById(R.id.buttonLogoutDashboard);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, ProfileActivity.class));
            }
        });

        medicalHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, MedicalHistoryActivity.class));
            }
        });

        medicalPrescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, MedicalPrescriptionActivity.class));
            }
        });

    }
}
