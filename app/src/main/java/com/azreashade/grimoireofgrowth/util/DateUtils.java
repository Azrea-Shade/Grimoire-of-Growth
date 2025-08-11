package com.azreashade.grimoireofgrowth.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public final class DateUtils {
    private static final DateTimeFormatter ISO = DateTimeFormatter.ISO_LOCAL_DATE;

    private DateUtils() {}

    public static String todayIso() {
        return LocalDate.now(ZoneId.systemDefault()).format(ISO);
    }

    public static boolean isToday(String iso) {
        if (iso == null || iso.isEmpty()) return false;
        return todayIso().equals(iso);
    }
}
