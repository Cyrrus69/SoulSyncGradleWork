package com.soulsync;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class LanguageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create UI programmatically
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        Button btnEnglish = new Button(this);
        btnEnglish.setText("English");
        
        Button btnHindi = new Button(this);
        btnHindi.setText("हिंदी");

        layout.addView(btnEnglish);
        layout.addView(btnHindi);
        setContentView(layout);

        // Click handlers
        btnEnglish.setOnClickListener(v -> selectLanguage("en"));
        btnHindi.setOnClickListener(v -> selectLanguage("hi"));
    }

    private void selectLanguage(String langCode) {
        // Save language preference
        SharedPreferences prefs = getSharedPreferences("SoulSyncPrefs", MODE_PRIVATE);
        prefs.edit().putString("language", langCode).apply();

        // Navigate to next screen
        Toast.makeText(this, "Language set: " + langCode, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, SignInActivity.class));
        finish();
    }
}