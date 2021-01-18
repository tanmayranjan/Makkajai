package com.makkajai;

import java.util.Date;

public class Schedule {
    private Date startTime;
    private int durationInMinutes;
    private String title;

    public Schedule(Date startTime, String title, int durationInMinutes){
        this.startTime = startTime;
        this.title = title;
        this.durationInMinutes = durationInMinutes;
    }

    public Date getStartTime() {
        return startTime;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public String getTitle() {
        return title;
    }

}
