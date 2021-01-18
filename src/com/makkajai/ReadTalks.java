package com.makkajai;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadTalks {
    public static List<Talk> readTalks(String fileName) {
        FileInputStream fstream = null;
        BufferedReader br = null;
        List<Talk> talkList = new ArrayList<>();

        try {
            fstream = new FileInputStream(fileName);
            br = new BufferedReader(new InputStreamReader(fstream));

            String strLine;
            int intMinutes;
            while ((strLine = br.readLine()) != null) {
                if (strLine.contains("//") || strLine.isEmpty())
                    continue;

                String title = strLine.substring(0, strLine.lastIndexOf(" "));
                String minutesString = strLine.substring(strLine.lastIndexOf(" ") + 1);
                String minutes = strLine.replaceAll("\\D+", "");
                if (ConferenceConfig.LIGHTNING_TALK.equals(minutesString)) {
                    intMinutes = ConferenceConfig.LIGHTNING_TALK_DURATION_MINUTES;
                } else {
                    try {
                        intMinutes = Integer.parseInt(minutes);
                    } catch (NumberFormatException e) {
                        System.err.println("Could not parse the line : " + strLine);
                        throw e;
                    }
                }
                Talk singleTalk = new Talk(title, intMinutes);
                talkList.add(singleTalk);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fstream.close();
                br.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        return talkList;
    }
}
