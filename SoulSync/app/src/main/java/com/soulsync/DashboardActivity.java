package com.soulsync;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;

public class DashboardActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(Color.parseColor("#212121"));
        layout.setPadding(32, 32, 32, 32);

        SharedPreferences prefs = getSharedPreferences("SoulSyncPrefs", MODE_PRIVATE);
        String userName = prefs.getString("userName", "User");

        TextView tvGreeting = new TextView(this);
        tvGreeting.setText("Hi " + userName + ", how can I help you?");
        tvGreeting.setTextSize(20);
        tvGreeting.setTextColor(Color.WHITE);

        CardView cardRelax = createCard("RELAX", Color.parseColor("#7B1FA2"));
        CardView cardMemory = createCard("MEMORY", Color.parseColor("#512DA8"));
        CardView cardMusic = createCard("MUSIC", Color.parseColor("#303F9F"));

        layout.addView(tvGreeting);
        layout.addView(cardRelax);
        layout.addView(cardMemory);
        layout.addView(cardMusic);
        setContentView(layout);

        cardRelax.setOnClickListener(v -> startActivity(new Intent(this, RelaxActivity.class)));
        cardMemory.setAlpha(0.5f);
        cardMusic.setAlpha(0.5f);
    }

    private CardView createCard(String text, int color) {
        CardView card = new CardView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 16, 0, 16);
        card.setLayoutParams(params);
        card.setCardBackgroundColor(color);
        card.setRadius(16);
        card.setContentPadding(32, 32, 32, 32);

        TextView tv = new TextView(this);
        tv.setText(text);
        tv.setTextSize(18);
        tv.setTextColor(Color.WHITE);

        card.addView(tv);
        return card;
    }
}