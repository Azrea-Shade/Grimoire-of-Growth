package com.azreashade.grimoireofgrowth.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azreashade.grimoireofgrowth.R;
import com.azreashade.grimoireofgrowth.domain.Habit;

import java.util.ArrayList;
import java.util.List;

public class HabitsAdapter extends RecyclerView.Adapter<HabitsAdapter.VH> {

    public interface Listener {
        void onToggle(Habit h, boolean done);
        void onRename(Habit h);
        void onDelete(Habit h);
    }

    private final LayoutInflater inflater;
    private final Listener listener;
    private final List<Habit> items = new ArrayList<>();

    public HabitsAdapter(Context ctx, Listener listener) {
        this.inflater = LayoutInflater.from(ctx);
        this.listener = listener;
    }

    public void setItems(List<Habit> list) {
        items.clear();
        if (list != null) items.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_habit, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH h, int position) {
        Habit item = items.get(position);
        h.name.setText(item.name);
        h.check.setChecked(item.isDoneToday());
        h.check.setOnClickListener(v -> {
            boolean now = h.check.isChecked();
            listener.onToggle(item, now);
        });
        h.more.setOnClickListener(v -> showMenu(h.more, item));
        h.itemView.setOnClickListener(v -> {
            // toggle on row tap for convenience
            h.check.performClick();
        });
    }

    private void showMenu(View anchor, Habit item) {
        PopupMenu m = new PopupMenu(anchor.getContext(), anchor);
        m.getMenu().add(0, 1, 0, R.string.rename);
        m.getMenu().add(0, 2, 1, R.string.delete);
        m.setOnMenuItemClickListener((MenuItem it) -> {
            if (it.getItemId() == 1) listener.onRename(item);
            else if (it.getItemId() == 2) listener.onDelete(item);
            return true;
        });
        m.show();
    }

    @Override
    public int getItemCount() { return items.size(); }

    static class VH extends RecyclerView.ViewHolder {
        CheckBox check;
        TextView name;
        ImageButton more;
        VH(@NonNull View itemView) {
            super(itemView);
            check = itemView.findViewById(R.id.checkDone);
            name = itemView.findViewById(R.id.textName);
            more = itemView.findViewById(R.id.buttonMore);
        }
    }
}
