package com.soulsync;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class RemindersActivity extends Activity {

    private RecyclerView recyclerView;
    private ReminderAdapter adapter;
    private List<Reminder> reminderList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders);

        recyclerView = findViewById(R.id.rvReminders);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ReminderAdapter(reminderList);
        recyclerView.setAdapter(adapter);

        loadSampleReminders();

        FloatingActionButton fabAdd = findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(v -> showAddReminderDialog());
    }

    private void loadSampleReminders() {
        reminderList.add(new Reminder("9:00 AM", "Take medicines", "Everyday"));
        reminderList.add(new Reminder("11:00 AM", "Take eye drops", "Everyday"));
        adapter.notifyDataSetChanged();
    }

    private void showAddReminderDialog() {
        Toast.makeText(this, "Add reminder clicked", Toast.LENGTH_SHORT).show();
    }

    public static class Reminder {
        String time;
        String task;
        String frequency;

        public Reminder(String time, String task, String frequency) {
            this.time = time;
            this.task = task;
            this.frequency = frequency;
        }
    }
}