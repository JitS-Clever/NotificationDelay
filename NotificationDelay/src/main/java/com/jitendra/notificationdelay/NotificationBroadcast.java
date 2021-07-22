package com.jitendra.notificationdelay;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.pushtemplates.TemplateRenderer;
import com.clevertap.pushtemplates.Utils;

public class NotificationBroadcast extends BroadcastReceiver {

@Override
    public void onReceive(Context context, Intent intent) {

        Bundle extras = intent.getBundleExtra("Extra");
        Log.d("123", "4");
        if (Utils.isForPushTemplates(extras)) {
            TemplateRenderer.createNotification(context, extras);
            //TemplateRenderer.createNotification(context, extras, config);
        } else {
            CleverTapAPI.createNotification(context, extras);
        }

    }
}
