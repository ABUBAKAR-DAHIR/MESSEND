package com.example.messend;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;


import java.util.HashMap;
import java.util.Map;

public class LoginOtpActivity extends AppCompatActivity {

    private EditText otp;
    private Button nextButton;
    private ProgressBar progressBar;
    private TextView resendOTP;
    String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_otp);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        otp = findViewById(R.id.login_otp);
        nextButton = findViewById(R.id.login_next_btn);
        progressBar =findViewById(R.id.login_otp_progress_bar);
        resendOTP = findViewById(R.id.resend_otp);

        phoneNumber = getIntent().getExtras().getString("phone");
        Toast.makeText(getApplicationContext(), phoneNumber, Toast.LENGTH_SHORT).show();
        FirebaseApp.initializeApp(this);

        Map<String, String> data = new HashMap<>();
        data.put("Number", phoneNumber);

        FirebaseFirestore.getInstance().collection("This_is_a_test").add(data);



//        FirebaseFirestore.getInstance().collection("Phone Numbers").add(data);
//        new HashMap<>();

//        sendOtp(phoneNumber, false);

    }

//    void sendOtp(String phoneNumber, boolean isResend)
//    {
//        setInProgress(true);
//    }
//
//    void setInProgress(boolean inProgress)
//    {
//        if(inProgress)
//        {
//            progressBar.setVisibility(View.VISIBLE);
//            nextButton.setVisibility(View.GONE);
//        }
//        else
//        {
//            progressBar.setVisibility(View.GONE);
//            nextButton.setVisibility(View.VISIBLE);
//        }
//    }
}











