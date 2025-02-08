package com.example.messend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.hbb20.CountryCodePicker;

public class LoginPhoneNumber extends AppCompatActivity {

    private ProgressBar progressBar;
    private Button btnOtp;
    CountryCodePicker countryCodePicker;
    EditText phoneInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_phone_number);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        progressBar = findViewById(R.id.login_progressBar);
        btnOtp = findViewById(R.id.sendOTPBtn);
        countryCodePicker = findViewById(R.id.login_countryCode);
        phoneInput = findViewById(R.id.login_mobileNumber);

        countryCodePicker.registerCarrierNumberEditText(phoneInput);

        btnOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!countryCodePicker.isValidFullNumber())
                {
                    phoneInput.setError("Phone Number is not valid");
                }
//                progressBar.setVisibility(View.VISIBLE);
                else
                {
                    Intent intent = new Intent(LoginPhoneNumber.this, LoginOtpActivity.class);
                    intent.putExtra("phone", countryCodePicker.getFullNumberWithPlus());
                    startActivity(intent);
                }

            }
        });

    }
}