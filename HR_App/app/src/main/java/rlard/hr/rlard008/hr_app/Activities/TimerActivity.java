package rlard.hr.rlard008.hr_app.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import rlard.hr.rlard008.hr_app.Api.Api;
import rlard.hr.rlard008.hr_app.Fragments.DailyReportFragment;
import rlard.hr.rlard008.hr_app.Fragments.ManualEntryFragment;
import rlard.hr.rlard008.hr_app.Fragments.MonthlyReportFragment;
import rlard.hr.rlard008.hr_app.Fragments.RolesFragment;
import rlard.hr.rlard008.hr_app.Fragments.TaskListFragment;
import rlard.hr.rlard008.hr_app.Fragments.WeeklyReportFragment;
import rlard.hr.rlard008.hr_app.Pojo.SaveData;
import rlard.hr.rlard008.hr_app.R;
import rlard.hr.rlard008.hr_app.localdb.DataBaseHelper;

public class TimerActivity extends AppCompatActivity {

    private Spinner spinnercompanies;
    private EditText ettaskname;
    private ListView listViewTask;
    private Button fab;
    private LinearLayout linearLayout;
    private ArrayList<SaveData>arrayListTask;
    private SharedPreferences sharedPreferences;
    private DataBaseHelper db;
    private static final String currenttimeurl="http://139.59.78.52:8080/HR_Application/ServerTimeServlet";
    private String submitrequesturl="";
    private ArrayList<String>arrayListspinnerdata;
    private String taskname="";
    private String status=null;
    String task_state = null;
    private static String starttime=null;
    private static String stoptime=null;
    private static String pausetime=null;
    private static String resumetime=null;
    private static int checktime=0;

    private static boolean flag=false;
    private SharedPreferences sharedPreferencesnotes;
    private ArrayList<String>alcompanies=null;
    private SharedPreferences sfr=null;





    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        //initializing ui
        ettaskname=(EditText)findViewById(R.id.edittexttask);
        listViewTask=(ListView)findViewById(R.id.listviewtasks);
        fab=(Button)findViewById(R.id.fab);

        spinnercompanies=(Spinner)findViewById(R.id.spinnercompanies);

        linearLayout=(LinearLayout)findViewById(R.id.linearcompanies);
        //local DataBase
        sharedPreferences=this.getSharedPreferences("roledata",MODE_PRIVATE);
        sharedPreferencesnotes=this.getSharedPreferences("note",MODE_PRIVATE);
        sfr=this.getSharedPreferences("flagrole",MODE_PRIVATE);
        //arraylist
        arrayListTask=new ArrayList<>();
        arrayListspinnerdata=new ArrayList<>();


        //setting companies spinner
        setCompaniesSpinner();


        String date=Api.getCurrentdate();
        Log.e("CurrentDate",""+date);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#33b5e5")));

        //    arrayListtimer=new ArrayList<>();
        //creating object of DataBaseHelper
        db=new DataBaseHelper(this);


        //getting data from arraylist
        arrayListTask=db.getData();


        //setting data into Spinner
        settingSpinnerAdapter();

        //calling Adapter class
        ListViewAdapter adapter=new ListViewAdapter();
        listViewTask.setAdapter(adapter);




        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 boolean checkduplicate=false;
                //getting taskname
                taskname=ettaskname.getText().toString();
                String companyname=spinnercompanies.getSelectedItem().toString();

                //getting role
                String rolename=sharedPreferences.getString("rolename","");


                if(taskname.equals("")) {
                    Toast.makeText(TimerActivity.this,"Please Write Your Tasks",Toast.LENGTH_LONG).show();


                }
                else {
                    //creating contructor of savedata
                    SaveData saveData = new SaveData();
                    saveData.setTaskname(taskname);
                    saveData.setRole(rolename);
                    saveData.setStarttime("");
                    saveData.setPausetime("");
                    saveData.setResumetime("");
                    saveData.setStoptime("");
                    saveData.setTimetaken(0);
                    saveData.setStatus("Pending");
                    saveData.setCheckbutton("Start");
                    saveData.setProcessstatus("NotRunning");
                    saveData.setStartcolor("#33b5e5");
                    saveData.setStopcolor("#33b5e5");
                    saveData.setNote("No Notes");
                    saveData.setCompanyname(companyname);


                    Log.e("Save data","save"+saveData);
                    for(SaveData saveData1:arrayListTask)
                    {
                        if(saveData1.getTaskname().equals(taskname))
                        {
                            Toast.makeText(TimerActivity.this,"Your Already added This Task",Toast.LENGTH_LONG).show();
                            checkduplicate=true;
                        }

                    }

                    if(!checkduplicate) {
                        arrayListTask.add(saveData);

                        //inserting data to local dataBase
                        db.insertTaskData(saveData);
                        ArrayList<SaveData>al=db.getData();
                        Log.e("al","al"+al);
                    }
                    //setting adapter
                    ListViewAdapter adapter=new ListViewAdapter();
                    listViewTask.setAdapter(adapter);
                    ettaskname.setText("");
                    Log.e("under","under");
                }

            }
        });
    }


    //disabling onBack Pressed
    @Override
    public void onBackPressed() {
        SharedPreferences.Editor editor=sfr.edit();
        editor.putString("flag","y");
        editor.commit();
        Intent intent=new Intent(TimerActivity.this,DrawerActivity.class);
        startActivity(intent);
    }

    //ListView Adapter Function
    class ListViewAdapter extends ArrayAdapter<SaveData>
    {
        Boolean isExpand = false;
        public ListViewAdapter() {
            super(TimerActivity.this, R.layout.textlistviewlayout,arrayListTask);
        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable final View convertView, @NonNull final ViewGroup parent) {

            LayoutInflater inflater=getLayoutInflater();
            View itemview=inflater.inflate(R.layout.textlistviewlayout,null);

            final TextView textViewst=(TextView)itemview.findViewById(R.id.tvstatus);
            TextView textview=(TextView)itemview.findViewById(R.id.text);
            Button btndelete=(Button)itemview.findViewById(R.id.btn_del);
            final Button btnstart=(Button)itemview.findViewById(R.id.btn_start);
            final Button btnstop=(Button)itemview.findViewById(R.id.btn_stop);
            Button btn_note=(Button)itemview.findViewById(R.id.btn_note);
            final Button btn_ex_col=(Button)itemview.findViewById(R.id.btn_ex_colapse);
            final Spinner spinnerstatus=(Spinner)itemview.findViewById(R.id.spinnerstatus);

            final LinearLayout linearLayout=(LinearLayout)itemview.findViewById(R.id.linear);
            final SaveData tasklist=arrayListTask.get(position);
            btnstart.setText(""+tasklist.getCheckbutton());
            btnstop.setText("Stop");
            btndelete.setText("Delete");

            textViewst.setText("Time : "+tasklist.getTimetaken()); /////////////////

            linearLayout.setVisibility(View.GONE);
            try {
                btnstart.setBackgroundColor(Color.parseColor(tasklist.getStartcolor()));
                btnstop.setBackgroundColor(Color.parseColor(tasklist.getStopcolor()));
            }
            catch (Exception e) {}

            textview.setText(""+tasklist.getTaskname());
            taskname=tasklist.getTaskname();



            ArrayAdapter<String>adapter=new ArrayAdapter<String>(TimerActivity.this,android.R.layout.simple_list_item_1,arrayListspinnerdata);
            spinnerstatus.setAdapter(adapter);



            //click Listener on Button
            btndelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    SaveData saveData=arrayListTask.get(position);
                    Log.e("save data",""+saveData);
                    db.deleteData(saveData.getTaskname());
                    arrayListTask.remove(position);
                    ListViewAdapter adapter=new ListViewAdapter();
                    listViewTask.setAdapter(adapter);
                }
            });

            //click listener on button notes
            btn_note.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SaveData saveData=arrayListTask.get(position);
                    alertDialogBox(saveData);
//                    String ndata=sharedPreferencesnotes.getString("notedata","");
//                    SaveData saveData=arrayListTask.get(position);
//                    saveData.setNote(ndata);
//                    db.updateData(saveData);
                }
            });

            //click listener on expand and collapse buttons
            btn_ex_col.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    if (isExpand == true) {
                        linearLayout.setVisibility(View.GONE);
                        isExpand = false;
                        btn_ex_col.setCompoundDrawablesWithIntrinsicBounds(
                                0, 0, 0, 0);
                        // expandButton.setCompoundDrawablesWithIntrinsicBounds(
                        //       R.drawable.expand1, 0, 0, 0);
                    }
                    else {
                        linearLayout.setVisibility(View.VISIBLE);
                        isExpand = true;
                        btn_ex_col.setCompoundDrawablesWithIntrinsicBounds(
                                0, 0, 0, 0);
                        btn_ex_col.setCompoundDrawablesWithIntrinsicBounds(
                                R.drawable.collapse1, 0, 0, 0);
                    }

                }
            });

            btnstart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    try {
                    Calendar cal = Calendar.getInstance();

                    //getting savedata object
                    SaveData saveData = arrayListTask.get(position);
                    status = spinnerstatus.getSelectedItem().toString();
                    try {
                        btnstart.setBackgroundColor(Color.parseColor(saveData.getStartcolor()));
                    } catch(Exception e) {

                        Toast.makeText(TimerActivity.this,"Manually entered task is already completed",Toast.LENGTH_LONG).show();
                    }
                    task_state = saveData.getProcessstatus();
                    Log.e("task_state check",""+task_state);

                    if (saveData.getStatus().equals("Stop")) {
                        Toast.makeText(TimerActivity.this, "This Task has been Stopped.", Toast.LENGTH_LONG).show();
                    }

                    if (saveData.getCheckbutton().equals("Start") && saveData.getStatus().equals("Pending") && saveData.getProcessstatus().equals("NotRunning")) {
                        checktime = 1;
                        //getting current time from server
                       // getCurrentTimeRequest();

                        /////////////////////////////////////////////////////////////////////
                        Log.e("start check",""+starttime);
                        Log.e("start status check",""+saveData.getStatus());

                       // Calendar cal = Calendar.getInstance();
                        int hour = cal.get(Calendar.HOUR);

                        int minute = cal.get(Calendar.MINUTE);

                        int second = cal.get(Calendar.SECOND);

                        int AM_PM = cal.get(Calendar.AM_PM);

                        if(AM_PM == 1)
                        {
                            hour = hour+12;
                        }
                        int date=cal.get(Calendar.DATE);
                        int month=cal.get(Calendar.MONTH);
                        int year=cal.get(Calendar.YEAR);

                        String totaltime = date+":"+month+":"+year+":"+hour+":"+minute+":"+second;

                        starttime = totaltime;

                      //  Log.e("starttime",""+starttime);

                        /////////////////////////////////////////////////////////////////////



                        //setting starttime to save data object
                        saveData.setStarttime(starttime);
                        Log.e("starttime", "" +starttime);
                        //checking for starttime
                        if (saveData.getStarttime() == null || saveData.getStarttime().equals("null")) {
                            Toast.makeText(TimerActivity.this, "Click Again", Toast.LENGTH_LONG).show();
                        } else {
                            if (saveData.getProcessstatus().equals("NotRunning")) {
                                saveData.setProcessstatus("Running");
                                saveData.setStartcolor("#24ca32");
                                btnstart.setBackgroundColor(Color.GREEN);
                               // saveData.setStatus("Started");
                                db.updateData(saveData);
                                Toast.makeText(TimerActivity.this, "Time Started", Toast.LENGTH_LONG).show();

                            }
                        }
                    }

                    //checking for check button and status
                    if (saveData.getCheckbutton().equals("Start") && status.equals("Onhold") && saveData.getProcessstatus().equals("Running")) {

                        int time2 = db.timeTaken(saveData.getTaskname());
                        Log.e("time2",""+time2);
                        checktime = 3;
                       // getCurrentTimeRequest();

                        /////////////////////////////////////////////////////////////////////


                        int hour = cal.get(Calendar.HOUR);

                        int minute = cal.get(Calendar.MINUTE);

                        int second = cal.get(Calendar.SECOND);

                        int AM_PM = cal.get(Calendar.AM_PM);
                        if(AM_PM == 1)
                        {
                            hour = hour+12;
                        }
                        int date=cal.get(Calendar.DATE);
                        int month=cal.get(Calendar.MONTH);
                        int year=cal.get(Calendar.YEAR);

                        String totaltime = date+":"+month+":"+year+":"+hour+":"+minute+":"+second;




                        pausetime = totaltime;
                        Log.e("pausetime",""+pausetime);


                        /////////////////////////////////////////////////////////////////////

                        //Log.e("checktime = 3 pausetime", ""+pausetime);
                        saveData.setPausetime(pausetime);
                        if (saveData.getPausetime() == null || saveData.getPausetime().equals("null")) {
                            Toast.makeText(TimerActivity.this, "Click Again", Toast.LENGTH_LONG).show();
                        } else {
                            Log.e("underpause", "yes");
                            saveData.setCheckbutton("Paused");
                            btnstart.setText("Paused");
                            saveData.setStatus(status);
                            saveData.setProcessstatus("NotRunning");
                            try {
                                Log.e("saveData.getStarttime()", "" +saveData.getStarttime());
                                Log.e("saveData.getPausetime()", "" +saveData.getPausetime());

                                int time = (int) Api.calculatetime(saveData.getStarttime(), saveData.getPausetime());
                                time2 = time2 + time;
                                Log.e("TimeTaken", "" + time2);
                                saveData.setTimetaken(time2);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }

                            db.updateData(saveData);
                            Toast.makeText(TimerActivity.this, "Time Stoped", Toast.LENGTH_LONG).show();

                        }
                    }

                    //checking for check button and status
                    if (saveData.getCheckbutton().equals("Paused") && status.equals("Working") && saveData.getProcessstatus().equals("NotRunning")) {

                        checktime = 4;
                        //getCurrentTimeRequest();

                        //////////////////////////////////////////////////////////////////////////

                       // Calendar cal = Calendar.getInstance();


                        int hour = cal.get(Calendar.HOUR);

                        int minute = cal.get(Calendar.MINUTE);

                        int second = cal.get(Calendar.SECOND);

                        int AM_PM = cal.get(Calendar.AM_PM);

                        if(AM_PM == 1)
                        {
                            hour = hour+12;
                        }
                        int date=cal.get(Calendar.DATE);
                        int month=cal.get(Calendar.MONTH);
                        int year=cal.get(Calendar.YEAR);

                        String totaltime = date+":"+month+":"+year+":"+hour+":"+minute+":"+second;
                        resumetime = totaltime;

                        Log.e("resumetime",""+resumetime);


                        /////////////////////////////////////////////////////////////////////////


                        saveData.setResumetime(resumetime);

                        if (saveData.getResumetime() == null || saveData.getResumetime().equals("null")) {
                            Toast.makeText(TimerActivity.this, "ClickAgain", Toast.LENGTH_LONG).show();
                        } else {
                            saveData.setCheckbutton("Resumed");
                            btnstart.setText("Resumed");
                            saveData.setStatus(status);
                            saveData.setProcessstatus("Running");

                            db.updateData(saveData);
                            Toast.makeText(TimerActivity.this, "Time Started", Toast.LENGTH_LONG).show();

                        }

                    }

                    //checking for check button and status
                    if (saveData.getCheckbutton().equals("Resumed") && status.equals("Onhold") && saveData.getProcessstatus().equals("Running")) {

                        int time = db.timeTaken(saveData.getTaskname());
                        checktime = 3;
                       // getCurrentTimeRequest();
                        /////////////////////////////////////////////////////////////////////
                        //Calendar cal = Calendar.getInstance();

                        int hour = cal.get(Calendar.HOUR);

                        int minute = cal.get(Calendar.MINUTE);

                        int second = cal.get(Calendar.SECOND);

                        int AM_PM = cal.get(Calendar.AM_PM);

                        if(AM_PM == 1)
                        {
                            hour = hour+12;
                        }

                        int date=cal.get(Calendar.DATE);
                        int month=cal.get(Calendar.MONTH);
                        int year=cal.get(Calendar.YEAR);

                        String totaltime = date+":"+month+":"+year+":"+hour+":"+minute+":"+second;

                        pausetime = totaltime;
                        Log.e("pausetime",""+pausetime);
                        /////////////////////////////////////////////////////////////////////
                        saveData.setPausetime(pausetime);
                        if (saveData.getPausetime() == null || saveData.getPausetime().equals("null")) {
                            Toast.makeText(TimerActivity.this, "Click Again", Toast.LENGTH_LONG).show();
                        } else {
                            saveData.setCheckbutton("Paused");
                            btnstart.setText("Paused");
                            saveData.setStatus(status);
                            saveData.setProcessstatus("NotRunning");
                            try {

                                Log.e("saveDatgetResumetime()", " "+saveData.getResumetime());
                                Log.e("saveData.getPausetime()", "" +saveData.getPausetime());
                                int time2 = (int) Api.calculatetime(saveData.getResumetime(), saveData.getPausetime());
                                time2 = time2 + time;
                                Log.e("time2", "" + time2);
                                saveData.setTimetaken(time2);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            db.updateData(saveData);
                            Toast.makeText(TimerActivity.this, "Time Stoped", Toast.LENGTH_LONG).show();
                        }


                    }

                    textViewst.setText("Time : " + saveData.getTimetaken()); //////////////////



//
//                    final Handler handler = new Handler();
//                    final Timer timer = new Timer();
//                    TimerTask task = new TimerTask() {
//                        @Override
//                        public void run() {
//                            handler.post(new Runnable() {
//                                public void run() {
//                                    SaveData saveData1 = arrayListTask.get(position);
//                                    int time = db.timeTaken(saveData1.getTaskname());
//                                    textViewst.setText("Time :" + saveData1.getTimetaken());
//                                    time++;
//                                    saveData1.setTimetaken(time);
//                                    db.updateData(saveData1);
//
//
//                                    clearList(arrayListTask);
//
//
//                                    //setting adapter
//                                    ListViewAdapter adapter = new ListViewAdapter();
//                                    listViewTask.setAdapter(adapter);
//
//                                    arrayListTask = db.getData();
//                                }
//                            });
//                        }
//                    };//end of timer task
//                    timer.schedule(task, 0, 60 * 1000); //calling schduler function to schdule the time interval

                    } catch(Exception e) {

                        Toast.makeText(TimerActivity.this,"Manually entered task is already completed",Toast.LENGTH_LONG).show();
                    }

                }





            });
            btnstop.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void onClick(View v) {
                    try {
                        SaveData saveData = arrayListTask.get(position);
                        int time = db.timeTaken(saveData.getTaskname());
                        Log.e("check 2 main_time ", "" + time);

                        if (saveData.getProcessstatus().equals("NotRunning")) {
                            Toast.makeText(TimerActivity.this, "You did't Start This Task", Toast.LENGTH_LONG).show();
                        } else {
                            checktime = 2;
                            //getting current time from the server
                            // getCurrentTimeRequest();
                            ///////////////////////////////////////////////////////////////////////////////////
                            Calendar cal = Calendar.getInstance();
                            int hour = cal.get(Calendar.HOUR);

                            int minute = cal.get(Calendar.MINUTE);

                            int second = cal.get(Calendar.SECOND);

                            int AM_PM = cal.get(Calendar.AM_PM);

                            if (AM_PM == 1) {
                                hour = hour + 12;
                            }

                            int date=cal.get(Calendar.DATE);
                            int month=cal.get(Calendar.MONTH);
                            int year=cal.get(Calendar.YEAR);

                            String totaltime = date+":"+month+":"+year+":"+hour+":"+minute+":"+second;

                            stoptime = totaltime;

                            Log.e("stoptime", "" + stoptime);

                            ////////////////////////////////////////////////////////////////////////////////

                            //setting starttime to save data object
                            saveData.setStoptime(stoptime);
                            Log.e("TaskDetails", "" + saveData);

                            //checking
                            if (saveData.getStoptime() == null || saveData.getStoptime().equals("null")) {

                                Toast.makeText(TimerActivity.this, "Click Again", Toast.LENGTH_LONG).show();
                            } else {

                                //finding status
                                status = spinnerstatus.getSelectedItem().toString();
                                saveData.setStatus(status);
                                if (status.equals("Done")) {
                                    saveData.setStartcolor("#33b5e5");
                                    saveData.setStopcolor("#ed070b");
                                    btnstop.setBackgroundColor(Color.parseColor(saveData.getStopcolor()));
                                    btnstart.setBackgroundColor(Color.parseColor(saveData.getStartcolor()));
                                    if (saveData.getCheckbutton().equals("Start")) {

                                        if (saveData.getStoptime() == null || saveData.getStoptime().equals("null")) {
                                            Toast.makeText(TimerActivity.this, "Click Again", Toast.LENGTH_LONG).show();
                                        } else {
                                            Log.e("underpause", "yes");
                                            //   saveData.setCheckbutton("Stop");
                                            saveData.setStatus(status);
                                            saveData.setProcessstatus("NotRunning");
                                            try {
                                                Log.e("saveData.getStarttime()", "" + saveData.getStarttime());
                                                Log.e("saveData.getStoptime()", "" + saveData.getStoptime());
                                                int timetaken = (int) Api.calculatetime(saveData.getStarttime(), saveData.getStoptime());
                                                time = time + timetaken;
                                                Log.e("time", "" + time);

                                                saveData.setTimetaken(time);
                                            } catch (ParseException e) {
                                                e.printStackTrace();
                                            }

                                            db.updateData(saveData);
                                            Toast.makeText(TimerActivity.this, "Time Stoped", Toast.LENGTH_LONG).show();

                                        }

                                    }


                                    if (saveData.getCheckbutton().equals("Resumed")) {

                                        Log.e("check 2 ", "Resumed");

                                        if (saveData.getStoptime() == null || saveData.getStoptime().equals("null")) {
                                            Toast.makeText(TimerActivity.this, "Click Again", Toast.LENGTH_LONG).show();
                                        } else {
                                            Log.e("underpause", "yes");
                                            // saveData.setCheckbutton("Stop");
                                            saveData.setStatus(status);
                                            saveData.setProcessstatus("NotRunning");
                                            try {
                                                int timetaken = (int) Api.calculatetime(saveData.getResumetime(), saveData.getStoptime());
                                                time = time + timetaken;

                                                Log.e("saveDResumetime()", "" + saveData.getResumetime());
                                                Log.e("saveData.getStoptime()", "" + saveData.getStoptime());

                                                saveData.setTimetaken(time);
                                            } catch (ParseException e) {
                                                e.printStackTrace();
                                            }

                                            db.updateData(saveData);
                                            Toast.makeText(TimerActivity.this, "Time Stoped", Toast.LENGTH_LONG).show();

                                        }

                                    }

                                    if (saveData.getCheckbutton().equals("Paused")) {

                                        if (saveData.getStoptime() == null || saveData.getStoptime().equals("null")) {
                                            Toast.makeText(TimerActivity.this, "Click Again", Toast.LENGTH_LONG).show();
                                        } else {
                                            Log.e("underpause", "yes");
                                            //    saveData.setCheckbutton("Stop");
                                            saveData.setStatus(status);
                                            saveData.setProcessstatus("NotRunning");
                                            try {
                                                int timetaken = (int) Api.calculatetime(saveData.getPausetime(), saveData.getStoptime());
                                                time = time + timetaken;

                                                Log.e("saveDgetPausetime()", "" + saveData.getPausetime());
                                                Log.e("saveData.getStoptime()", "" + saveData.getStoptime());


                                                saveData.setTimetaken(time);
                                            } catch (ParseException e) {
                                                e.printStackTrace();
                                            }

                                            db.updateData(saveData);
                                            Toast.makeText(TimerActivity.this, "Time Stoped", Toast.LENGTH_LONG).show();

                                        }
                                    }
                                } else {
                                    Toast.makeText(TimerActivity.this, "Please Check Your Working Status", Toast.LENGTH_LONG).show();
                                }

                            }

                        }
                        textViewst.setText("Time :" + saveData.getTimetaken()); //////////////////////////
                    } catch (Exception e) {

                        Toast.makeText(TimerActivity.this,"Manually entered task is already completed",Toast.LENGTH_LONG).show();
                    }

                }

            });


            return itemview;
        }
    }




    public void getCurrentTimeRequest()
    {
//        StringRequest stringRequest=new StringRequest(currenttimeurl, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                try {
//                    JSONObject jsonObject=new JSONObject(response);


        Calendar cal = Calendar.getInstance();

                    if(checktime == 1) {
                    //    starttime = jsonObject.getString("data");

                        Toast.makeText(TimerActivity.this,"checktime == 1",Toast.LENGTH_LONG).show();

                        int hour = cal.get(Calendar.HOUR);

                        int minute = cal.get(Calendar.MINUTE);

                        int second = cal.get(Calendar.SECOND);

                        int AM_PM = cal.get(Calendar.AM_PM);

                        if(AM_PM == 1)
                        {
                            hour = hour+12;
                        }

                        String totaltime = hour+":"+minute+":"+second;

                        starttime = totaltime;

                        Log.e("starttime",""+starttime);
                    }
                    if(checktime==2)
                    {
                     //   stoptime=jsonObject.getString("data");

                        Toast.makeText(TimerActivity.this,"checktime == 2",Toast.LENGTH_LONG).show();

                        int hour = cal.get(Calendar.HOUR);

                        int minute = cal.get(Calendar.MINUTE);

                        int second = cal.get(Calendar.SECOND);

                        int AM_PM = cal.get(Calendar.AM_PM);

                        if(AM_PM == 1)
                        {
                            hour = hour+12;
                        }

                        String totaltime = hour+":"+minute+":"+second;

                        stoptime = totaltime;

                        Log.e("stoptime",""+stoptime);
                    }
                    if(checktime==3)
                    {
                      //  pausetime=jsonObject.getString("data");

                        Toast.makeText(TimerActivity.this,"checktime == 3",Toast.LENGTH_LONG).show();

                        int hour = cal.get(Calendar.HOUR);

                        int minute = cal.get(Calendar.MINUTE);

                        int second = cal.get(Calendar.SECOND);

                        int AM_PM = cal.get(Calendar.AM_PM);

                        if(AM_PM == 1)
                        {
                            hour = hour+12;
                        }

                        String totaltime = hour+":"+minute+":"+second;

                        pausetime = totaltime;
                        Log.e("pausetime",""+pausetime);
                    }
                    if(checktime==4)
                    {
         //               resumetime=jsonObject.getString("data");

                        Toast.makeText(TimerActivity.this,"checktime == 4",Toast.LENGTH_LONG).show();

                        int hour = cal.get(Calendar.HOUR);

                        Toast.makeText(TimerActivity.this,"Hour "+hour,Toast.LENGTH_LONG).show();

                        int minute = cal.get(Calendar.MINUTE);

                        int second = cal.get(Calendar.SECOND);

                        int AM_PM = cal.get(Calendar.AM_PM);

                        if(AM_PM == 1)
                        {
                            hour = hour+12;
                        }

                        String totaltime = hour+":"+minute+":"+second;

                        resumetime = totaltime;

                        Log.e("resumetime",""+resumetime);

                    }

//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e("Error",""+error);
//            }
//        });
//        RequestQueue requestQueue=Volley.newRequestQueue(this);
//        requestQueue.add(stringRequest);
    }




    public void settingSpinnerAdapter()
    {
        arrayListspinnerdata.add("Pending");
        arrayListspinnerdata.add("Done");
        arrayListspinnerdata.add("Onhold");
        arrayListspinnerdata.add("Working");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.report,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.daily:
                linearLayout.setVisibility(View.GONE);
                fab.setVisibility(View.GONE);
                ettaskname.setVisibility(View.GONE);
                //     destroydailyreportfragment();
                loadingDailyReportFragment();
                Toast.makeText(TimerActivity.this,"Daily Report",Toast.LENGTH_LONG).show();
                break;
            case R.id.weekly:
                linearLayout.setVisibility(View.GONE);
                fab.setVisibility(View.GONE);
                ettaskname.setVisibility(View.GONE);
                //   destroytasklistFragment();
                loadingWeeklyReportFragment();
                Toast.makeText(TimerActivity.this,"Weekly Report",Toast.LENGTH_LONG).show();
                break;

            case R.id.monthly:
                linearLayout.setVisibility(View.GONE);
                fab.setVisibility(View.GONE);
                ettaskname.setVisibility(View.GONE);
                loadingMonthlyReportFragment();
                Toast.makeText(TimerActivity.this,"Monthly Report",Toast.LENGTH_LONG).show();
                break;

            case R.id.tasklist:
                linearLayout.setVisibility(View.GONE);
                fab.setVisibility(View.GONE);
                ettaskname.setVisibility(View.GONE);
                loadingTaskListFragment();
                break;
            case R.id.manualentry:
                linearLayout.setVisibility(View.GONE);
                fab.setVisibility(View.GONE);
                ettaskname.setVisibility(View.GONE);
                loadingManualEntryFragment();
                break;
            case R.id.roles:
                linearLayout.setVisibility(View.GONE);
                fab.setVisibility(View.GONE);
                ettaskname.setVisibility(View.GONE);
                loadingRolesFragment();
                break;


        }
        return super.onOptionsItemSelected(item);
    }


    //loading fragments
    public void loadingDailyReportFragment()
    {
        DailyReportFragment dailyreportFragment=new DailyReportFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.container,dailyreportFragment);
        ft.commit();
    }

    public void loadingWeeklyReportFragment()
    {
        WeeklyReportFragment weeklyReportFragment=new WeeklyReportFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.container,weeklyReportFragment);
        ft.commit();
    }

    public void loadingMonthlyReportFragment()
    {
        MonthlyReportFragment monthlyReportFragment=new MonthlyReportFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.container,monthlyReportFragment);
        ft.commit();
    }

    public void loadingTaskListFragment()
    {
        TaskListFragment taskListFragment=new TaskListFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.container,taskListFragment);
        ft.commit();
    }

    public void loadingManualEntryFragment()
    {
        ManualEntryFragment manualEntryFragment=new ManualEntryFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.container,manualEntryFragment);
        ft.commit();

    }

    public void loadingRolesFragment()
    {
        RolesFragment rolesFragment=new RolesFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.container,rolesFragment);
        ft.commit();
    }


    @Override
    protected void onStart() {
        super.onStart();

        // Store our shared preference
        SharedPreferences sp = getSharedPreferences("OURINFO", MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString("active", "true");
        ed.commit();
    }


    public void alertDialog()
    {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Are You Sure You Want to Stop Your Task");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    flag=true;
                        Log.e("setflag","true");
                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        flag=false;
                        dialog.cancel();

                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }



    public void clearList(ArrayList<SaveData>arrayListTask)
    {
        for(int i=0;i<arrayListTask.size();i++)
        {
            arrayListTask.clear();
        }
    }

public void alertDialogBox(final SaveData save)
{

    final AlertDialog.Builder alertBuilder=new AlertDialog.Builder(TimerActivity.this);
    alertBuilder.setTitle("Enter Task Note");
    final EditText etnotes=new EditText(TimerActivity.this);
    LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
    etnotes.setLayoutParams(lp);
    etnotes.setLines(5);
    alertBuilder.setView(etnotes);
    alertBuilder.setIcon(R.drawable.noteicon);
    alertBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
     String  text=etnotes.getText().toString();
            if(text.isEmpty() )
            {
                text="No Notes";
            }
            save.setNote(text);
//           SharedPreferences.Editor editor=sharedPreferencesnotes.edit();
//            editor.putString("notedata", text);
//            editor.commit();

            db.updateData(save);
        }
    });

    alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
        }
    });
    alertBuilder.show();

}



public void setCompaniesSpinner()
{
    alcompanies=new ArrayList<>();
    alcompanies.add("Ergoptix");
    alcompanies.add("Amled");
    alcompanies.add("Rlard");
    alcompanies.add("Stbi");
    alcompanies.add("Engitech");
    alcompanies.add("Vibescope");
    alcompanies.add("Edge");
    ArrayAdapter<String>adapter=new ArrayAdapter<String>(TimerActivity.this,android.R.layout.simple_list_item_1,alcompanies);
    spinnercompanies.setAdapter(adapter);
}





}
