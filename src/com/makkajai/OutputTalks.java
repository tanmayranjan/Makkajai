package com.makkajai;

import java.text.SimpleDateFormat;
import java.util.List;

public class OutputTalks {
    public static void printTalks(List<Talk> talkList) {
        for (Talk talk : talkList) {
            System.out.println(talk.getTitle() + " " + talk.getDurationInMinutes());
        }
    }

    public static void printSchedule(List<List<Schedule>> scheduleList) {
        SimpleDateFormat sdf = ConferenceConfig.DATE_FORMAT;
        for (int i = 0; i < scheduleList.size(); i++) {
            System.out.println("Track " + (i+1) + ":");
            for (Schedule schedule : scheduleList.get(i)) {
                System.out.println(sdf.format(schedule.getStartTime()) + " " + schedule.getTitle() + " " + schedule.getDurationInMinutes());
            }
        }
    }
}
