package com.blikoon.rooster;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.blikoon.rooster.constant.SharedPreferencesConstant;
import com.blikoon.rooster.util.AppPreferences;

/**
 * Created by User on 23/9/2016.
 */
public class BootCompletedReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//        Intent startServiceIntent = new Intent(context, MyService.class);
//        context.startService(startServiceIntent);

//        Log.d(TAG,"saveCredentialsAndLogin() called.");
        Toast.makeText(context, "BootCompletedReceiver!!!", Toast.LENGTH_LONG).show();

        boolean loggedIn = AppPreferences.getBoolean(context, SharedPreferencesConstant.PREF_LOGGED_IN, false);

        if (loggedIn) {
            //Start the service
            Intent i1 = new Intent(context, RoosterConnectionService.class);
            context.startService(i1);
        }
    }
}
