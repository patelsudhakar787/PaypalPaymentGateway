package rlard.hr.rlard008.hr_app.Fragments;


import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;

import rlard.hr.rlard008.hr_app.Api.Api;
import rlard.hr.rlard008.hr_app.Pojo.SaveData;
import rlard.hr.rlard008.hr_app.R;
import rlard.hr.rlard008.hr_app.localdb.DataBaseHelper;

import static android.content.Context.MODE_PRIVATE;
import static rlard.hr.rlard008.hr_app.R.id.spinnerstatus;

/**
 * Created by sudhakar on 5/22/17.
 */

public class ManualEntryFragment extends Fragment {
    private Spinner spinnercompanies;
    private EditText ettaskname;
    private EditText etdate;
    private Button btn_date;
    private Spinner spinnerrole;
    private Spinner et1hour;
    private Spinner et2hour;
    private Spinner et1minute;
    private Spinner et2minute;
    private Spinner spinner;
    private Button btn_submit;
    private Button btn_notes;
    private DataBaseHelper db;
    private ArrayList<String>arrayListstatus;
    private ArrayList<String>arrayListroles;
    private LinearLayout ll1;
    private LinearLayout ll2;
    private DatePicker datePicker;
    private Button btn_done;
    private String date;
    private ArrayList<String>alcompanies=null;
    private SaveData saveData=null;
    private String text="No Notes";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View itemView=inflater.inflate(R.layout.manualentry_layout,container,false);

        ll1=(LinearLayout)itemView.findViewById(R.id.linear1);
        ll2=(LinearLayout)itemView.findViewById(R.id.linear2);
        spinnercompanies=(Spinner)itemView.findViewById(R.id.spinnercompanies);
        ettaskname=(EditText)itemView.findViewById(R.id.ettaskname);
        etdate=(EditText)itemView.findViewById(R.id.etdate);
        spinnerrole=(Spinner)itemView.findViewById(R.id.rolespinner);
        et1hour=(Spinner) itemView.findViewById(R.id.spinnerhour1);
        et1minute=(Spinner) itemView.findViewById(R.id.spinnerminute1);
        et2hour=(Spinner) itemView.findViewById(R.id.spinnerhour2);
        et2minute=(Spinner) itemView.findViewById(R.id.spinnerminute2);
        spinner=(Spinner)itemView.findViewById(spinnerstatus);
        btn_submit=(Button)itemView.findViewById(R.id.btn_submit);
        btn_notes=(Button)itemView.findViewById(R.id.btn_note);
        btn_date=(Button)itemView.findViewById(R.id.btndate);
        datePicker=(DatePicker)itemView.findViewById(R.id.datepicker);
        btn_done=(Button)itemView.findViewById(R.id.btn_Done);


        ll2.setVisibility(View.GONE);
        db=new DataBaseHelper(getContext());
        arrayListstatus=new ArrayList<>();
        arrayListroles=new ArrayList<>();

        etdate.setVisibility(View.GONE);

        //calling send Request Function
        sendRequest();

        setCompaniesSpinner();
        setSpinners();
        setStatusAdapter();

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    manualData();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });


        btn_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               alertDialogBox();
            }
        });

        btn_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etdate.setVisibility(View.VISIBLE);

                ll2.setVisibility(View.VISIBLE);
                ll1.setVisibility(View.GONE);

            }
        });


        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll2.setVisibility(View.GONE);
                ll1.setVisibility(View.VISIBLE);
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth() + 1;
                int year = datePicker.getYear();
                date=day+":"+month+":"+year;
                etdate.setText(day+"-"+month+"-"+year);
            }
        });

        return itemView;
    }

    public void manualData() throws ParseException {
        int timetaken=0;
        String taskname=ettaskname.getText().toString();

        String companyname=spinnercompanies.getSelectedItem().toString();
        String rolename="";
        //getting rolename from spinner
        try {
            rolename = spinnerrole.getSelectedItem().toString();
        }
        catch (NullPointerException e)
        {
            Toast.makeText(getContext(),"No Role,Please Check Your Internet",Toast.LENGTH_LONG).show();
        }
        String hour1=et1hour.getSelectedItem().toString();
        hour1=hour1.replace(" ","");


        String minute1=et1minute.getSelectedItem().toString();
        minute1=minute1.replace(" ","");


        String starttime = date+":"+hour1+":"+minute1+":"+"00";
        Log.e("SatrtTiem",starttime);
        String hour2=et2hour.getSelectedItem().toString();
        hour2=hour2.replace(" ","");

        String minute2=et2minute.getSelectedItem().toString();
        minute2=minute2.replace(" ","");

        String stoptime=date+":"+hour2+":"+minute2+":"+"00";

        String status=spinner.getSelectedItem().toString();

        if(TextUtils.isEmpty(taskname))
        {
            ettaskname.setError("Enter Task");
        }
        else if(TextUtils.isEmpty(date))
        {
            Toast.makeText(getContext(),"Select Date",Toast.LENGTH_LONG).show();
        }
        else if(TextUtils.isEmpty(rolename))
        {
            Toast.makeText(getContext(),"Please Connect to Internet and Choose Role",Toast.LENGTH_LONG).show();
        }
        else if (TextUtils.isEmpty(taskname)){

            ettaskname .setError(getString(R.string.error_field_required));
        }
        else {



                timetaken = (int) Api.calculatetime(starttime, stoptime);

                saveData = new SaveData(taskname, rolename, starttime, stoptime, timetaken, status, "Play",text,companyname);
                boolean check = db.insertTaskData(saveData);

                if (check == true) {
                    Toast.makeText(getContext(), "Added To TaskList", Toast.LENGTH_LONG).show();
                    ettaskname.setText("");

                }

        }
//        SaveData saveData=new SaveData(taskname,rolename,starttime,stoptime,timetaken,status,"Play");
//        boolean check=db.insertTaskData(saveData);
//
//        if(check==true)
//        {
//            Toast.makeText(getContext(),"Added To TaskList",Toast.LENGTH_LONG).show();
//            ettaskname.setText("");
//            etrole.setText("");
//            ethour1.setText("");
//            ethour2.setText("");
//            etminute1.setText("");
//            etminute2.setText("");
//
//        }


    }



    public void setStatusAdapter()
    {
        arrayListstatus.add("Working");
        arrayListstatus.add("Pending");
        arrayListstatus.add("OnHold");
        arrayListstatus.add("Done");
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,arrayListstatus);
        spinner.setAdapter(arrayAdapter);
    }


    public void setRoleSpinner()
    {
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,arrayListroles);
        spinnerrole.setAdapter(adapter);
    }


    public void sendRequest() {

        SharedPreferences sharedPreferences1 =getContext().getSharedPreferences("data",MODE_PRIVATE);

        String empID = sharedPreferences1.getString("empId","");

        Log.e("mainAct_EmpID",""+empID);

        String requesturl = "http://139.59.78.52:8080/HR_Application/SelectRoleServlet?empid="+empID;//+13;
        Log.e("mainAct_requesturl",""+requesturl);
        StringRequest stringRequest = new StringRequest(requesturl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Response", "" + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    JSONObject jsonObject1 = jsonArray.getJSONObject(0);

                    //role1
                    String role1=jsonObject1.getString("role1");
                    if(!role1.isEmpty())
                    {
                        arrayListroles.add(role1);
                    }

                    //role2
                    String role2=jsonObject1.getString("role2");
                    if(!role2.isEmpty())
                    {
                        arrayListroles.add(role2);
                    }

                    //role3
                    String role3=jsonObject1.getString("role3");
                    if(!role3.isEmpty())
                    {
                        arrayListroles.add(role3);
                    }




                    //role4
                    String role4=jsonObject1.getString("role4");
                    if(!role4.isEmpty())
                    {
                        arrayListroles.add(role4);
                    }


                    //role5
                    String role5=jsonObject1.getString("role5");
                    if(!role5.isEmpty())
                    {
                        arrayListroles.add(role5);
                    }

                    //role6
                    String role6=jsonObject1.getString("role6");
                    if(!role6.isEmpty())
                    {
                        arrayListroles.add(role6);
                    }


                    //role7
                    String role7=jsonObject1.getString("role7");
                    if(!role7.isEmpty())
                    {
                        arrayListroles.add(role7);
                    }


                    //role8
                    String role8=jsonObject1.getString("role8");
                    if(!role8.isEmpty())
                    {
                        arrayListroles.add(role8);
                    }


                    //role9
                    String role9=jsonObject1.getString("role9");
                    if(!role9.isEmpty())
                    {
                        arrayListroles.add(role9);
                    }


                    //role10
                    String role10=jsonObject1.getString("role10");
                    if(!role10.isEmpty())
                    {
                        arrayListroles.add(role10);
                    }


                    //role11
                    String role11=jsonObject1.getString("role11");
                    if(!role11.isEmpty())
                    {
                        arrayListroles.add(role11);
                    }


                    //role2
                    String role12=jsonObject1.getString("role12");
                    if(!role12.isEmpty())
                    {
                        arrayListroles.add(role12);
                    }


                    //role13
                    String role13=jsonObject1.getString("role13");
                    if(!role13.isEmpty())
                    {
                        arrayListroles.add(role13);
                    }



                    //role14
                    String role14=jsonObject1.getString("role14");
                    if(!role14.isEmpty())
                    {
                        arrayListroles.add(role14);
                    }


                    //role15
                    String role15=jsonObject1.getString("role15");
                    if(!role15.isEmpty())
                    {
                        arrayListroles.add(role15);
                    }


                    //role16
                    String role16=jsonObject1.getString("role16");
                    if(!role16.isEmpty())
                    {
                        arrayListroles.add(role16);
                    }



                    Log.e("arraylist","al"+arrayListroles);
                    setRoleSpinner();
                } catch (Exception e) {

                    e.printStackTrace();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error_MainActivity", "" + error);
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
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

        ArrayAdapter<String>adapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,alcompanies);
        spinnercompanies.setAdapter(adapter);
    }


    public void alertDialogBox()
    {

        final AlertDialog.Builder alertBuilder=new AlertDialog.Builder(getContext());
        alertBuilder.setTitle("Enter Task Note");
        final EditText etnotes=new EditText(getContext());
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        etnotes.setLayoutParams(lp);
        etnotes.setLines(5);
        alertBuilder.setView(etnotes);
        alertBuilder.setIcon(R.drawable.noteicon);
        alertBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                text=etnotes.getText().toString();
                if(text.isEmpty() )
                {
                    text="No Notes";
                }


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


    public void setSpinners()
    {
        ArrayList<String>alhour=Api.getHour();
        Log.e("Al data","al"+alhour);
        ArrayAdapter<String>adapter1=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,alhour);
        et1hour.setAdapter(adapter1);
        et2hour.setAdapter(adapter1);


        ArrayList<String>alminute=Api.getMinute();
        ArrayAdapter<String>adapter2=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,alminute);
        et1minute.setAdapter(adapter2);
        et2minute.setAdapter(adapter2);
    }
}