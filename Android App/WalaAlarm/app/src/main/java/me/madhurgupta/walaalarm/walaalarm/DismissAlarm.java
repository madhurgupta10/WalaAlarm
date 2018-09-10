package me.madhurgupta.walaalarm.walaalarm;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONException;
import org.json.JSONObject;

public class DismissAlarm extends AppCompatActivity {

    final String IP = ""+"/?type=leave";
    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dismiss_alarm);

        mPlayer = MediaPlayer.create(this, R.raw.calm);
        mPlayer.setLooping(true);
        mPlayer.start();

        Ion.with(this).load(IP).asString().setCallback(new FutureCallback<String>() {
            @Override
            public void onCompleted(Exception e, String result) {
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    int status = jsonObject.optInt("status");
                    if (status == 1) {
                        mPlayer.stop();
                    }
                } catch (JSONException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
