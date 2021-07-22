package com.jitendra.notificationdelay;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


import com.clevertap.android.sdk.CleverTapAPI;

public class NotificationBroadcast extends BroadcastReceiver {

@Override
    public void onReceive(Context context, Intent intent) {

        Bundle extras = intent.getBundleExtra("Extra");
        CleverTapAPI.createNotification(context, extras);

    }
}
