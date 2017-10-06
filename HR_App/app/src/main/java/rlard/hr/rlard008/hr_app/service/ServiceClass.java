package rlard.hr.rlard008.hr_app.service;

import android.app.AlertDialog;
import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by sudhakar on 6/28/17.
 */

public class ServiceClass extends Service {
    private Ringtone r;
    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        Toast.makeText(ServiceClass.this,"OnCreate()",Toast.LENGTH_LONG).show();
        Log.d("Testing", "Service got created");

    }

    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        Toast.makeText(ServiceClass.this,"OnBind()",Toast.LENGTH_LONG).show();
        return null;
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        Toast.makeText(ServiceClass.this,"OnDestroy()",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onStart(Intent intent, int startId) {
        // TODO Auto-generated method stub
        super.onStart(intent, startId);
        Toast.makeText(ServiceClass.this,"OnStart()",Toast.LENGTH_LONG).show();

        final Handler handler=new Handler();
        Timer timer=new Timer();
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
                        r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                        r.play();
                        AlertDialog alertDialog = new AlertDialog.Builder(getApplicationContext())
                                .setTitle("Hr_App")
                                .setMessage("Had You Submit Your Task To Server")
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                       r.stop();

                                    }
                                })
                                .create();

                        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
                        alertDialog.show();
                    }
                },1000);
            }
        };
        timer.schedule(task,0,5*1000);
//8*60*60*100,8*60*60*1000



            Log.d("Testing", "Service got started");

        }

    @Override
    public int onStartCommand(Intent intent,int flag, int startId) {
        Toast.makeText(ServiceClass.this,"OnStartCommand()",Toast.LENGTH_LONG).show();
        Calendar calendar=Calendar.getInstance();
        int AM_PM=calendar.get(Calendar.AM_PM);
        int hour=calendar.get(Calendar.HOUR);
        if(AM_PM == 1)
        {
            hour=hour+12;
        }
        int minute=calendar.get(Calendar.MINUTE);
        String time=hour+":"+minute;
        Toast.makeText(ServiceClass.this,"Time "+time,Toast.LENGTH_LONG).show();
        if(time.equals("12:5"))
        {
            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
                      Ringtone  r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                        r.play();
        }
        return super.onStartCommand(intent, flag, startId);
    }
}


