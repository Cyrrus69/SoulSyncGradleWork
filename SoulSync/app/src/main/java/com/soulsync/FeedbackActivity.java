package com.soulsync;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FeedbackActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(Color.parseColor("#3E2723"));

        TextView tvQuestion = new TextView(this);
        tvQuestion.setText("# ARE YOU NOW FEELING BETTER?");
        tvQuestion.setTextSize(24);
        tvQuestion.setTextColor(Color.WHITE);

        TextView tvSubtext = new TextView(this);
        tvSubtext.setText("Your feedback matters");
        tvSubtext.setTextSize(16);
        tvSubtext.setTextColor(Color.LTGRAY);

        Button btnEnter = new Button(this);
        btnEnter.setText("ENTER");
        btnEnter.setBackgroundColor(Color.parseColor("#5D4037"));
        btnEnter.setTextColor(Color.WHITE);

        layout.addView(tvQuestion);
        layout.addView(tvSubtext);
        layout.addView(btnEnter);
        setContentView(layout);

        btnEnter.setOnClickListener(v -> finish());
    }
}