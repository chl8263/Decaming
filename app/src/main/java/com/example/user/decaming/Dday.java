package com.example.user.decaming;

import java.util.GregorianCalendar;

/**
 * Created by User on 2017-05-13.
 */

public class Dday {
    public long dayy(String mday){
        if(mday==null) return 0;
        mday = mday.trim();
        int first = mday.indexOf("-");
        int last = mday.lastIndexOf("-");
        int year = Integer.parseInt(mday.substring(0,first));
        int month = Integer.parseInt(mday.substring(first+1,last));
        int day = Integer.parseInt(mday.substring(last+1,mday.length()));

        GregorianCalendar cal = new GregorianCalendar();
        long currentTime = cal.getTimeInMillis()/(1000*60*60*24);
        cal.set(year,month-1,day);
        long birthTime = cal.getTimeInMillis()/(1000*60*60*24);
        int interval = (int)(birthTime-currentTime);
        return interval;
    }
}
