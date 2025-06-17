package com.soulsync;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.android.material.snackbar.Snackbar;

public class SignInActivity extends Activity {

    private EditText etEmailPhone;
    private Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        etEmailPhone = findViewById(R.id.etEmailPhone);
        btnSignIn = findViewById(R.id.btnSignIn);

        btnSignIn.setOnClickListener(v -> {
            String input = etEmailPhone.getText().toString().trim();
            
            if (TextUtils.isEmpty(input)) {
                showError("Please enter email or phone");
                return;
            }

            if (isValidEmail(input) || isValidPhone(input)) {
                startActivity(new Intent(this, NameActivity.class));
            } else {
                showError("Invalid email/phone format");
            }
        });
    }

    private boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidPhone(String phone) {
        return android.util.Patterns.PHONE.matcher(phone).matches() 
            && phone.length() >= 10;
    }

    private void showError(String message) {
        Snackbar.make(btnSignIn, message, Snackbar.LENGTH_LONG)
            .setBackgroundTint(getResources().getColor(R.color.error_red))
            .show();
    }
}