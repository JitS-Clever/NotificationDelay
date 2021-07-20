package com.jitendra.notificationdelay;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.text.ParseException;
import java.util.Date;

import static android.content.Context.ALARM_SERVICE;

public class NotificationDelayCleverTap {

    public void NotifTime(Context context, Bundle Extras) {

        String notifTime = Extras.getString("Notif");
        Long currentTime = System.currentTimeMillis();
        Date epoch = null;
        Long time;
        try {
            epoch = new java.text.SimpleDateFormat("dd MM yyyy HH:mm:ss.SSS").parse(notifTime);
        }
        catch (ParseException e){
            e.printStackTrace();
        }

        time = (Long) epoch.getTime();
        Log.d("Epoch", time.toString());
        Log.d("Current Time", currentTime.toString());

        Intent intent = new Intent(context, NotificationBroadcast.class);
        intent.putExtra("Extra",Extras);
        Log.d("123", "1");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                context, 123, intent, 0);
        Log.d("123", "2");
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, time, pendingIntent);
        Log.d("123", "3");
    }
}
