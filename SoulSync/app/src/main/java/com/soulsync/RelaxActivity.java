package com.soulsync;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;

public class RelaxActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relax);

        CardView cardBreathing = findViewById(R.id.cardBreathing);
        CardView cardMeditation = findViewById(R.id.cardMeditation);
        CardView cardSounds = findViewById(R.id.cardSounds);

        setupCardHoverEffect(cardBreathing);
        setupCardHoverEffect(cardMeditation);
        setupCardHoverEffect(cardSounds);

        cardBreathing.setOnClickListener(v -> {
            Animation pulse = AnimationUtils.loadAnimation(this, R.anim.pulse);
            v.startAnimation(pulse);
            startActivity(new Intent(this, BreathingActivity.class));
        });

        // Disable other cards for now
        cardMeditation.setEnabled(false);
        cardSounds.setEnabled(false);
        cardMeditation.setAlpha(0.6f);
        cardSounds.setAlpha(0.6f);
    }

    private void setupCardHoverEffect(CardView card) {
        card.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        v.animate().scaleX(0.95f).scaleY(0.95f).setDuration(100).start();
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        v.animate().scaleX(1f).scaleY(1f).setDuration(100).start();
                        break;
                }
                return false;
            }
        });
    }
}