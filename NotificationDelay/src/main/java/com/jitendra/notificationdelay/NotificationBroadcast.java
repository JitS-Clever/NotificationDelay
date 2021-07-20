package com.jitendra.notificationdelay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.clevertap.android.sdk.CleverTapAPI;

public class NotificationBroadcast {

@Override
    public void onReceive(Context context, Intent intent) {

        Bundle extras = intent.getBundleExtra("Extra");
        Log.d("123", "4");
        CleverTapAPI.createNotification(context, extras);
    }
}
