package com.selfpractise.webwallet.utils;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatting {

    public static String formatDate(OffsetDateTime dateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd:MM:yyyy");
        return dateTime.format(formatter);
    }
}
