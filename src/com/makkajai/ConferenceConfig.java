package com.makkajai;

import java.text.SimpleDateFormat;

public class ConferenceConfig {
    public static final String TALKS_INPUT_FILE = "input-talks.txt";
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("hh:mm a");

    public static final String LIGHTNING_TALK = "lightning";

    public static final int MORNING_SLOT_DURATION_MINUTES = 180;
    public static final int AFTERNOON_SLOT_DURATION_MINUTES = 240;

    public static final int LIGHTNING_TALK_DURATION_MINUTES = 5;

    public static final int MORNING_START_TIME = 9;
    public static final int LUNCH_START_TIME = 12;
    public static final int AFTERNOON_START_TIME = 13;
    public static final int NETWORKING_START_TIME = 17;

    public static final int LUNCH_DURATION_MINUTES = 60;
    public static final int NETWORKING_DURATION_MINUTES = 60;

    public static final String LUNCH_BREAK = "Lunch - ";
    public static final String NETWORKING_BREAK = "Networking Event - ";
}
