package com.example.rlard008.hr_app;

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
import android.widget.Toast;

import com.example.rlard008.hr_app.localdb.DataBaseHelper;

import java.util.Timer;
import java.util.TimerTask;

public class RemainderService extends Service {

 //   DataBaseHelper db=new DataBaseHelper(this);

    Vibrator vibrator;

    MediaPlayer mp;

    String status;
    // = MediaPlayer.create(this,)
//    SharedPreferences sharedPreferences = getSharedPreferences("OURINFO",MODE_PRIVATE);
//    String status = sharedPreferences.getString("active","");

//    ProgressDialog dialog = new ProgressDialog(this);

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

       // String time=db.getStartTime();

        SharedPreferences sharedPreferences = getSharedPreferences("OURINFO",MODE_PRIVATE);
        status = sharedPreferences.getString("active","");

        //Toast.makeText(this, "In Service_time"+time, Toast.LENGTH_LONG).show();


        final Handler handler = new Handler();
        final Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        try {
                            // hitRandomServlet();
                            alaramService();


                        } catch (Exception e) {
                            // error, do something
                        }
                    }
                });
            }
        };//end of timer task
        timer.schedule(task, 60 * 60000, 60 * 60000);




//        if (!status.equals("true")) {
//
//            //Toast.makeText(this, "You are not using application since past hour", Toast.LENGTH_LONG).show();
//
//            Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//
//            mp = MediaPlayer.create(this,sound);
//
//            vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
//            vibrator.vibrate(5000);
//
//            mp.start();
//
////
//            AlertDialog alertDialog = new AlertDialog.Builder(this)
//                    .setTitle("Hr_App")
//                    .setMessage("You are not using application since past hour")
//                    .setPositiveButton("OK",new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog,int id) {
//                            // if this button is clicked, close
//                            // current activity
//                        //MainActivity.this.finish();
//                            vibrator.cancel();
//                            mp.stop();
//
//                        }
//                    })
//                    .create();
//
//            alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
//            alertDialog.show();
//
////            NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
////                   // .setWhen(System.currentTimeMillis())
////                    .setVibrate(new long[]{5000,5000})
////                    .setContentTitle("HR_App")
////                    .setContentText("You are not using application since past hour");
////
////            Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
////                    builder.setSound(sound);
////
////            Notification note = builder.build();
//////            note.defaults |= Notification.DEFAULT_VIBRATE;
//////            note.defaults |= Notification.DEFAULT_SOUND;
////
////            NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
////            manager.notify(0,note);
//
//        }
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
                            // if this button is clicked, close
                            // current activity
                            //MainActivity.this.finish();
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
