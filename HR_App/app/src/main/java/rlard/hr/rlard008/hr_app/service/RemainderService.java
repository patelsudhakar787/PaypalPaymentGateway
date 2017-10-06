package rlard.hr.rlard008.hr_app.service;

import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Vibrator;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class RemainderService extends Service {


    Vibrator vibrator;

    MediaPlayer mp;

    String status;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        SharedPreferences sharedPreferences = getSharedPreferences("OURINFO",MODE_PRIVATE);
        status = sharedPreferences.getString("active","");


        final Handler handler = new Handler();
        final Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        try {
                            alaramService();


                        } catch (Exception e) {
                            // error, do something
                        }
                    }
                });
            }
        };//end of timer task
        timer.schedule(task, 60 * 60000, 60 * 60000);




        return super.onStartCommand(intent, flags, startId);
    }

    void alaramService() {

        if (!status.equals("true")) {

            //Toast.makeText(this, "You are not using application since past hour", Toast.LENGTH_LONG).show();

            Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

            mp = MediaPlayer.create(this, sound);

            vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(5000);

            mp.start();

            AlertDialog alertDialog = new AlertDialog.Builder(this)
                    .setTitle("Hr_App")
                    .setMessage("You are not using application since past hour")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            vibrator.cancel();
                            mp.stop();

                        }
                    })
                    .create();

            alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
            alertDialog.show();
        }
    }
}
