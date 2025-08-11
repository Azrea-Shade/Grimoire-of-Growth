package com.azreashade.grimoireofgrowth.domain;

import com.azreashade.grimoireofgrowth.util.DateUtils;

import org.json.JSONException;
import org.json.JSONObject;

public class Habit {
    public long id;
    public String name;
    /** ISO-8601 yyyy-MM-dd of the last completion (local). Empty if never. */
    public String lastDoneIso;

    public Habit(long id, String name) {
        this.id = id;
        this.name = name;
        this.lastDoneIso = "";
    }

    public boolean isDoneToday() {
        return DateUtils.isToday(lastDoneIso);
    }

    public void setDoneToday(boolean done) {
        this.lastDoneIso = done ? DateUtils.todayIso() : "";
    }

    public JSONObject toJson() throws JSONException {
        JSONObject o = new JSONObject();
        o.put("id", id);
        o.put("name", name);
        o.put("lastDoneIso", lastDoneIso == null ? "" : lastDoneIso);
        return o;
    }

    public static Habit fromJson(JSONObject o) throws JSONException {
        Habit h = new Habit(o.getLong("id"), o.getString("name"));
        h.lastDoneIso = o.optString("lastDoneIso", "");
        return h;
    }
}
