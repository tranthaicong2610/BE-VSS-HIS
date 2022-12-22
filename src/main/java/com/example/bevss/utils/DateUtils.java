package com.example.bevss.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Slf4j
public class DateUtils {
    public static final String NORMAL_DATE_TIME = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String NORMAL_DATE = "yyyy-MM-dd";

    public static String convertDateToString(Date date, String pattern) {
        if (date == null) return "";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        try {
            return formatter.format(date);
        } catch (Exception e) {
            log.error("Error when convert Date Time.", e);
            return "";
        }
    }

    public static Date convertStringToDate(String date, String pattern) {
        if (date == null || "".equals(date)) return null;
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        try {
            return formatter.parse(date);
        } catch (Exception e) {
            log.error("Error when convert Date Time.", e);
            return null;
        }
    }


    public static String convertLocalDateToString(LocalDate date, String pattern) {
        if (date == null) return "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        try {
            return date.format(formatter);
        } catch (Exception e) {
            log.error("Error when convert Date Time.", e);
            return "";
        }
    }

    public static LocalTime convertStringToLocalTime(String time, String pattern) {
        if (time == null || "".equals(time)) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        try {
            return LocalTime.parse(time, formatter);
        } catch (Exception e) {
            log.error("Error when convert Date Time.", e);
            return null;
        }
    }

    public static LocalDate convertStringToLocalDate(String date, String pattern) {
        if (date == null || "".equals(date)) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        try {
            return LocalDate.parse(date, formatter);
        } catch (Exception e) {
            log.error("Error when convert Date Time.", e);
            return null;
        }
    }

    public static String convertLocalDateTimeToString(LocalDateTime date, String pattern) {
        if (date == null) return "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        try {
            return date.format(formatter);
        } catch (Exception e) {
            log.error("Error when convert Date Time.", e);
            return "";
        }
    }

    public static LocalDateTime convertStringToLocalDateTime(String date, String pattern) {
        if (date == null || "".equals(date)) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        try {
            return LocalDateTime.parse(date, formatter);
        } catch (Exception e) {
            log.error("Error when convert Date Time.", e);
            return null;
        }
    }
}
