package com.makkajai;

import java.util.*;

public class ProcessTalks  {
    private static Object Comparator;

    public static List<List<Schedule>> createSchedule(List<Talk> talkList){
        List<Schedule> schedules = new ArrayList<>();
        List<List<Schedule>> days = new ArrayList<>();
        int numberOfDays = 0;
        Collections.sort(talkList,new TalkComparator());
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, ConferenceConfig.MORNING_START_TIME);
        calendar.set(Calendar.MINUTE, 0);
        int time = 0;
        List<Integer> sessions = new ArrayList<>();
        sessions.add(ConferenceConfig.MORNING_SLOT_DURATION_MINUTES);
        sessions.add(ConferenceConfig.AFTERNOON_SLOT_DURATION_MINUTES);
        List<String> breaks = new ArrayList<>();
        breaks.add(ConferenceConfig.LUNCH_BREAK);
        breaks.add(ConferenceConfig.NETWORKING_BREAK);
        int c = 0;
        Talk talk = null;
        for (ListIterator<Talk> talksIterator = talkList.listIterator(); ;) {
            talk = talksIterator.hasNext() ? talksIterator.next() : null;
            if(c > 1 || talk == null){
                calendar.add(Calendar.MINUTE,  (sessions.get(c) - time));
                schedules.add(new Schedule(calendar.getTime(),breaks.get(1),60));
                calendar.add(Calendar.MINUTE, 60);
                days.add(numberOfDays++,schedules);
                break;
            }
            if(time <= sessions.get(c) && remainingTime(sessions.get(c) , time , talk.getDurationInMinutes())) {
                schedules.add(new Schedule(calendar.getTime(),talk.getTitle(),talk.getDurationInMinutes()));
                calendar.add(Calendar.MINUTE, talk.getDurationInMinutes());
                time = time + talk.getDurationInMinutes();
            }
            else {

                calendar.add(Calendar.MINUTE,  (sessions.get(c) - time));
                schedules.add(new Schedule(calendar.getTime(),breaks.get(c),60));
                calendar.add(Calendar.MINUTE, 60);
                c++;
                if(breaks.get(c-1).equals(ConferenceConfig.NETWORKING_BREAK)){
                    days.add(numberOfDays++,schedules);
                    c = 0;
                    schedules = new ArrayList<>();
                    calendar.set(Calendar.HOUR_OF_DAY, ConferenceConfig.MORNING_START_TIME);
                    calendar.set(Calendar.MINUTE, 0);
                }
                time = 0;
                talk = talksIterator.previous();
            }
        }


        return days;
    }

    private static List<Schedule> clearList(List<Schedule> schedules) {
        for(int i = 0 ; i < schedules.size() ; i++){
            schedules.remove(i);
        }
        return schedules;
    }

    private static boolean remainingTime(Integer totalTime, int processedTime, int talkDuration) {
        if(talkDuration <=(totalTime - processedTime)){
            return true;
        }
        return false;
    }

}
