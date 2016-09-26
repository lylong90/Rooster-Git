package com.blikoon.rooster;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

import com.blikoon.rooster.constant.SharedPreferencesConstant;
import com.blikoon.rooster.util.AppPreferences;

/**
 * Created by lylong on 21/08/2016.
 */
public class MessageReceiver extends WakefulBroadcastReceiver {

    private final static String TAG = "MessageReceiver";

    public MessageReceiver() {}

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        switch (action)
        {
            case RoosterConnectionService.NEW_MESSAGE:
                String from = intent.getStringExtra(RoosterConnectionService.BUNDLE_FROM_JID);
                String body = intent.getStringExtra(RoosterConnectionService.BUNDLE_MESSAGE_BODY);
                Log.d(TAG, "from: " + from + ", body: " + body);

                AppPreferences appPreferences = new AppPreferences(context, SharedPreferencesConstant.PREF);
                appPreferences.putString(SharedPreferencesConstant.PREF_MESSAGES, body);

//                if ( from.equals(contactJid))
//                {
//                    mChatView.receiveMessage(body);
//                }
//                else
//                {
//                    Log.d(TAG,"Got a message from jid :"+from);
//                }


        }
    }
}
