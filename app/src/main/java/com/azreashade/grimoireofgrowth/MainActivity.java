package com.azreashade.grimoireofgrowth;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.azreashade.grimoireofgrowth.data.PrefsStore;
import com.azreashade.grimoireofgrowth.domain.Habit;
import com.azreashade.grimoireofgrowth.ui.HabitsAdapter;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements HabitsAdapter.Listener {

    private PrefsStore store;
    private HabitsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        store = new PrefsStore(this);

        MaterialToolbar bar = findViewById(R.id.topAppBar);
        setSupportActionBar(bar);

        RecyclerView rv = findViewById(R.id.habitsRecycler);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new HabitsAdapter(this, this);
        rv.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.fabAdd);
        fab.setOnClickListener(v -> showAddDialog(null));

        refresh();
    }

    private void refresh() {
        List<Habit> list = store.getHabits();
        adapter.setItems(list);
    }

    private void showAddDialog(Habit toRename) {
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_add_habit, null, false);
        EditText edit = view.findViewById(R.id.editName);
        if (toRename != null) edit.setText(toRename.name);

        AlertDialog dlg = new AlertDialog.Builder(this)
                .setTitle(toRename == null ? R.string.add_habit : R.string.rename)
                .setView(view)
                .setNegativeButton(R.string.cancel, (d, w) -> {})
                .setPositiveButton(R.string.save, (d, w) -> {
                    String name = edit.getText() == null ? "" : edit.getText().toString().trim();
                    if (TextUtils.isEmpty(name)) return;
                    if (toRename == null) {
                        store.addHabit(name);
                    } else {
                        store.renameHabit(toRename.id, name);
                    }
                    refresh();
                })
                .create();
        dlg.show();
    }

    @Override
    public void onToggle(Habit h, boolean done) {
        store.setDoneToday(h.id, done);
        refresh();
    }

    @Override
    public void onRename(Habit h) {
        showAddDialog(h);
    }

    @Override
    public void onDelete(Habit h) {
        new AlertDialog.Builder(this)
                .setTitle(R.string.confirm_delete)
                .setNegativeButton(R.string.no, (d, w) -> {})
                .setPositiveButton(R.string.yes_delete, (d, w) -> {
                    store.deleteHabit(h.id);
                    refresh();
                })
                .show();
    }
}
