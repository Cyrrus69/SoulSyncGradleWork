package com.soulsync;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ReminderAdapter extends RecyclerView.Adapter<ReminderAdapter.ViewHolder> {

    private final List<RemindersActivity.Reminder> reminders;

    public ReminderAdapter(List<RemindersActivity.Reminder> reminders) {
        this.reminders = reminders;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_reminder, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RemindersActivity.Reminder reminder = reminders.get(position);
        holder.tvTime.setText(reminder.time);
        holder.tvTask.setText(reminder.task);
        holder.tvFrequency.setText(reminder.frequency);
    }

    @Override
    public int getItemCount() {
        return reminders.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTime, tvTask, tvFrequency;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTime = itemView.findViewById(R.id.tvTime);
            tvTask = itemView.findViewById(R.id.tvTask);
            tvFrequency = itemView.findViewById(R.id.tvFrequency);
        }
    }
}