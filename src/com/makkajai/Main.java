package com.makkajai;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Talk> talkList = ReadTalks.readTalks(ConferenceConfig.TALKS_INPUT_FILE);

        OutputTalks.printTalks(talkList);
        System.out.println("**************");

        List<List<Schedule>> scheduleList = ProcessTalks.createSchedule(talkList);
        System.out.println("**************");

        OutputTalks.printSchedule(scheduleList);
    }
}
