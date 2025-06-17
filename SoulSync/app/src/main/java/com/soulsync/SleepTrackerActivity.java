package com.soulsync;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import com.google.android.material.snackbar.Snackbar;

public class SleepTrackerActivity extends Activity {

    private RadioGroup sleepQualityGroup;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_tracker);

        prefs = getSharedPreferences("SleepPrefs", MODE_PRIVATE);
        sleepQualityGroup = findViewById(R.id.sleepQualityGroup);

        findViewById(R.id.btnSubmit).setOnClickListener(v -> {
            int selectedId = sleepQualityGroup.getCheckedRadioButtonId();
            
            if (selectedId == -1) {
                Snackbar.make(v, "Please select sleep quality", Snackbar.LENGTH_SHORT).show();
                return;
            }

            saveSleepData(selectedId);
            finish();
        });
    }

    private void saveSleepData(int selectedId) {
        String sleepQuality = "";
        
        switch (selectedId) {
            case R.id.option7Hours:
                sleepQuality = "7_hours";
                break;
            case R.id.optionAdequate:
                sleepQuality = "adequate";
                break;
            case R.id.option9Hours:
                sleepQuality = "9_hours";
                break;
            case R.id.optionNotWell:
                sleepQuality = "not_well";
                break;
        }

        prefs.edit()
            .putString("last_sleep_quality", sleepQuality)
            .putLong("last_sleep_timestamp", System.currentTimeMillis())
            .apply();
    }
}