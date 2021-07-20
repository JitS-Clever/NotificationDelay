package com.jitendra.notificationdelay;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.clevertap.android.sdk.CleverTapAPI;

import java.text.ParseException;
import java.util.Date;

import static android.content.Context.ALARM_SERVICE;

public class NotificationDelayCleverTap {

    public void NotifTime(Context context, Bundle Extras) {

        if(Extras.containsKey("NotifyAt")){

            String notifTime = Extras.getString("NotifyAt");
            long currentTime = System.currentTimeMillis();
            Date epoch = null;
            long time;
            try {
                epoch = new java.text.SimpleDateFormat("dd MM yyyy HH:mm:ss.SSS").parse(notifTime);
            }
            catch (ParseException e){
                e.printStackTrace();
            }

            assert epoch != null;
            time = (Long) epoch.getTime();
            Log.d("Epoch", Long.toString(time));
            Log.d("Current Time", Long.toString(currentTime));

            Intent intent = new Intent(context, NotificationBroadcast.class);
            intent.putExtra("Extra",Extras);

            PendingIntent pendingIntent = PendingIntent.getBroadcast(
                    context, 123, intent, 0);

            AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
            alarmManager.set(AlarmManager.RTC_WAKEUP, time, pendingIntent);

        }
        else{
            CleverTapAPI.createNotification(context,Extras);
        }

    }

}
