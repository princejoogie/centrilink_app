package com.example.centrilink.MainActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.centrilink.DashboardActivity;
import com.example.centrilink.R;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    CardView login;
    public static ProgressBar bars;

    EditText email1, password1;
    public static String host = "https://centrilink.tech/";
    public static String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bars = findViewById(R.id.progress_bar);
        email1 = findViewById(R.id.email_main);
        password1 = findViewById(R.id.password_main);
    }

    public void loginBtn(View view) {
        bars.setVisibility(View.VISIBLE);
        String email = email1.getText().toString();
        password = password1.getText().toString();

        background bg = new background();
        String result = "";
        try {
            result = bg.execute(email, password).get();
        } catch(Exception e) {
            Log.d("Error login",  e.getMessage());
        }

        //{"status":"true","data":{"name":"Prince Juguilon","email":"princejoogie@gmail.com","image":"20190226_082925.jpg"}}
        try {
            JSONObject jo = new JSONObject(result);

            if(jo.getString("status").equals("true")) {
                String data_id = "";
                String data_name = "";
                String data_email = "";
                String data_image = "";

                JSONObject jo_data = new JSONObject(jo.getString("data"));
                data_id = jo_data.getString("id");
                data_name = jo_data.getString("name");
                data_email = jo_data.getString("email");
                data_image = jo_data.getString("image");

                Log.d("id", data_id);
                Log.d("Name", data_name);
                Log.d("Email", data_email);
                Log.d("Image", data_image);

                Intent i = new Intent(MainActivity.this, DashboardActivity.class);
                i.putExtra("id", data_id);
                i.putExtra("name", data_name);
                i.putExtra("email", data_email);
                i.putExtra("image", data_image);

                password1.setText("");
                startActivity(i);

            } else {
                bars.setVisibility(View.GONE);
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).create();
                dialog.setTitle("Error");
                dialog.setMessage(result);
                dialog.setIcon(R.mipmap.settings);
                dialog.setButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        } catch (Exception e) {
            Log.d("Error", e.getMessage());
        }
    }
}
