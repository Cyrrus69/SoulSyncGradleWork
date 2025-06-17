package com.soulsync;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import com.google.android.material.snackbar.Snackbar;

public class NameActivity extends Activity {

    private EditText etName;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        etName = findViewById(R.id.etName);
        btnSubmit = findViewById(R.id.btnSubmit);

        animateElements();

        btnSubmit.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            
            if (TextUtils.isEmpty(name)) {
                showError("Please enter your name");
                return;
            }

            saveName(name);
            navigateToDashboard();
        });
    }

    private void animateElements() {
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        etName.startAnimation(fadeIn);
        
        Animation slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        btnSubmit.startAnimation(slideUp);
    }

    private void saveName(String name) {
        SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        prefs.edit().putString("userName", name).apply();
    }

    private void navigateToDashboard() {
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    private void showError(String message) {
        Snackbar.make(btnSubmit, message, Snackbar.LENGTH_SHORT)
               .setBackgroundTint(getResources().getColor(R.color.error_red))
               .show();
    }
}