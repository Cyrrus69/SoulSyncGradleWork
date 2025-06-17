package com.soulsync;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BreathingActivity extends Activity {

    private TextView tvInstruction;
    private Button btnStart;
    private CountDownTimer breathTimer;
    private boolean isBreathingIn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(Color.parseColor("#0D47A1"));
        layout.setPadding(32, 32, 32, 32);

        tvInstruction = new TextView(this);
        tvInstruction.setTextSize(24);
        tvInstruction.setTextColor(Color.WHITE);
        tvInstruction.setText("Ready to begin?");

        btnStart = new Button(this);
        btnStart.setText("START");
        btnStart.setBackgroundColor(Color.parseColor("#2196F3"));
        btnStart.setTextColor(Color.WHITE);

        layout.addView(tvInstruction);
        layout.addView(btnStart);
        setContentView(layout);

        btnStart.setOnClickListener(v -> startBreathingExercise());
    }

    private void startBreathingExercise() {
        btnStart.setVisibility(View.GONE);
        breathTimer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (isBreathingIn) {
                    tvInstruction.setText("Breathe IN\n" + (millisUntilFinished / 1000) + "s");
                } else {
                    tvInstruction.setText("Breathe OUT\n" + (millisUntilFinished / 1000) + "s");
                }
                isBreathingIn = !isBreathingIn;
            }

            @Override
            public void onFinish() {
                tvInstruction.setText("Exercise complete");
                btnStart.setVisibility(View.VISIBLE);
            }
        }.start();
    }

    @Override
    protected void onDestroy() {
        if (breathTimer != null) {
            breathTimer.cancel();
        }
        super.onDestroy();
    }
}