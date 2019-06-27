package com.example.centrilink;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.centrilink.MainActivity.MainActivity;

public class DashboardActivity extends AppCompatActivity {

    CardView profile;
    CardView medicalHistory;
    CardView medicalPrescription;
    CardView nearbyPharmacy;
    CardView otp;
    CardView step;
    Button logout;
    TextView nameDash, emailDash;
    String str, qweqwqwe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        profile = findViewById(R.id.profile_view);
        medicalHistory = findViewById(R.id.records_view);
        medicalPrescription = findViewById(R.id.prescription_view);
        nearbyPharmacy = findViewById(R.id.nearby_pharmacy_view);
        logout = findViewById(R.id.buttonLogoutDashboard);
        otp = findViewById(R.id.otp_view);
        step = findViewById(R.id.step_view);

//        getActivity().runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
        nameDash = findViewById(R.id.dashboardName);
        emailDash = findViewById(R.id.dashboardEmail);

        Intent loginn = getIntent();
        str = loginn.getExtras().getString("name");
        qweqwqwe = loginn.getExtras().getString("email");

        nameDash.setText(str);
        emailDash.setText(qweqwqwe);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.bars.setVisibility(View.GONE);
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

        nearbyPharmacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, NearbyPharmacyActivity.class));
            }
        });

        step.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, StepsActivity.class));
            }
        });

        otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(DashboardActivity.this);
                builder1.setTitle("Your OTP is:");
                TextView msg = new TextView(DashboardActivity.this);
                msg.setText("0281");
                msg.setTextSize(64);
                msg.setGravity(Gravity.CENTER_HORIZONTAL);
                builder1.setView(msg);
                builder1.show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MainActivity.bars.setVisibility(View.GONE);
        finish();
    }
}
