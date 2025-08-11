package com.azreashade.grimoireofgrowth.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.azreashade.grimoireofgrowth.domain.Habit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PrefsStore {
    private static final String PREF_NAME = "gog_prefs_v1";
    private static final String KEY_DATA = "data";
    private static final String KEY_HABITS = "habits";

    private final SharedPreferences prefs;

    public PrefsStore(Context ctx) {
        prefs = ctx.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public List<Habit> getHabits() {
        List<Habit> list = new ArrayList<>();
        try {
            JSONObject root = getRoot();
            JSONArray arr = root.optJSONArray(KEY_HABITS);
            if (arr != null) {
                for (int i = 0; i < arr.length(); i++) {
                    list.add(Habit.fromJson(arr.getJSONObject(i)));
                }
            }
        } catch (JSONException e) {
            // ignore corrupt; start fresh
        }
        return list;
    }

    public void saveHabits(List<Habit> habits) {
        try {
            JSONObject root = getRoot();
            JSONArray arr = new JSONArray();
            for (Habit h : habits) {
                arr.put(h.toJson());
            }
            root.put(KEY_HABITS, arr);
            prefs.edit().putString(KEY_DATA, root.toString()).apply();
        } catch (JSONException e) {
            // ignore
        }
    }

    public Habit addHabit(String name) {
        List<Habit> list = getHabits();
        long id = System.currentTimeMillis();
        Habit h = new Habit(id, name);
        list.add(0, h);
        saveHabits(list);
        return h;
    }

    public void renameHabit(long id, String newName) {
        List<Habit> list = getHabits();
        for (Habit h : list) {
            if (h.id == id) { h.name = newName; break; }
        }
        saveHabits(list);
    }

    public void deleteHabit(long id) {
        List<Habit> list = getHabits();
        for (int i = list.size()-1; i >= 0; i--) {
            if (list.get(i).id == id) list.remove(i);
        }
        saveHabits(list);
    }

    public void setDoneToday(long id, boolean done) {
        List<Habit> list = getHabits();
        for (Habit h : list) {
            if (h.id == id) { h.setDoneToday(done); break; }
        }
        saveHabits(list);
    }

    private JSONObject getRoot() throws JSONException {
        String raw = prefs.getString(KEY_DATA, "{}");
        return new JSONObject(raw);
    }
}
