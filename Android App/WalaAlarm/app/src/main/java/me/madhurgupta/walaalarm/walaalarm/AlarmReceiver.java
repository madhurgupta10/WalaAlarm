package me.madhurgupta.walaalarm.walaalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Alarm", "Alarm just fired");
        Toast.makeText(context, "Wake Up" + "", Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(context, DismissAlarm.class);
        context.startActivity(intent1);
    }
}