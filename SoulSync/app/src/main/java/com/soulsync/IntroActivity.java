package com.soulsync;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class IntroActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create minimalist UI
        TextView textView = new TextView(this);
        textView.setText("CONNECTING SOULS TO TECHNOLOGY");
        textView.setTextSize(20);
        textView.setTextColor(Color.WHITE);
        textView.setBackgroundColor(Color.parseColor("#303F9F")); // Dark blue background

        setContentView(textView);

        // Auto-navigate after delay
        new Handler().postDelayed(() -> {
            startActivity(new Intent(this, LanguageActivity.class));
            finish();
        }, 2500); // 2.5s delay
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}