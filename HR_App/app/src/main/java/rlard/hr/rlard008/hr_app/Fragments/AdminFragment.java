package rlard.hr.rlard008.hr_app.Fragments;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import rlard.hr.rlard008.hr_app.Pojo.Pojo;
import rlard.hr.rlard008.hr_app.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminFragment extends Fragment {


    public AdminFragment() {
        // Required empty public constructor
    }


   Spinner spinnerempname;
    Spinner spinnerReportType;
    Button buttonSubmit;
    private Button btn_generatereport;
    private Button btn_confirm;
    private EditText et_confirm;
    private LinearLayout ll1;
    private CardView cv1;
    private ArrayList<String>arrayListempname;
    private ArrayList<Pojo>al=null;

    private ArrayList<String> arrayListReportType;
    private String requesturl=null;
    private String empname=null;
    File myFile;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View itemview=inflater.inflate(R.layout.fragment_admin,container,false);

        spinnerempname=(Spinner)itemview.findViewById(R.id.spinnerempname);
        spinnerReportType = (Spinner) itemview.findViewById(R.id.spinnerAdminReport);
        buttonSubmit = (Button) itemview.findViewById(R.id.buttonAdminSubmit);
btn_generatereport=(Button)itemview.findViewById(R.id.buttongenreport);
        btn_confirm=(Button)itemview.findViewById(R.id.btn_confirm);
        et_confirm=(EditText)itemview.findViewById(R.id.etadminpw);
        ll1=(LinearLayout)itemview.findViewById(R.id.linear1);
        cv1=(CardView) itemview.findViewById(R.id.check);
        ll1.setVisibility(View.GONE);


        arrayListReportType = new ArrayList<>();
        arrayListempname=new ArrayList<>();

        setReportTypeAdapter();

        setPermission();
        //calling request function
        sendRequest();
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getdata();

            }
        });



        btn_generatereport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    empname = spinnerempname.getSelectedItem().toString();
                }
                catch (NullPointerException e)
                {
                    Toast.makeText(getContext(),"Please Check Your Internet",Toast.LENGTH_LONG).show();
                }
                if(empname !=null) {
                    requesturl = "http://139.59.78.52:8080/HR_Application/PdfServlet?table=" + empname;
                    Log.e("url",""+requesturl);
                    sendReportRequest();
                }


                Calendar calendar=Calendar.getInstance();
                int mname=calendar.get(Calendar.MONTH);
                final int year=calendar.get(Calendar.YEAR);

                final String monthname=getMonthName(mname);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        saveExcelFile(getContext(),empname+"_Report"+monthname+"_"+year);
                    }
                },2000);


            }
        });

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pw=et_confirm.getText().toString();
                if(TextUtils.isEmpty(pw))
                {
                    et_confirm.setError("This Field id Required");
                }
                else if(pw.equals("rlard123"))
                {
                    cv1.setVisibility(View.GONE);
                    ll1.setVisibility(View.VISIBLE);
                }
                else
                {
                    et_confirm.setError("You don't have Authority");
                }
            }
        });

        return itemview;
    }

    void getdata() {

        String empName="";
        String reportType="";
        try {
            empName = spinnerempname.getSelectedItem().toString();
            reportType = spinnerReportType.getSelectedItem().toString();
        }
        catch (NullPointerException e)
        {
            Toast.makeText(getContext(),"Please Check Your Internet",Toast.LENGTH_LONG).show();
        }
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("AdminData", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("empName",empName);
        editor.commit();

        if (reportType.equals("Daily Report")) {

            loadAdminDailyReportFragment();
        }
        if (reportType.equals("Weekly Report")) {

            loadAdminWeeklyReportFragment();
        }
        if (reportType.equals("Monthly Report")) {

            loadAdminMonthlyReportFragment();
        }
    }

    void setReportTypeAdapter() {

        arrayListReportType.add("Daily Report");
        arrayListReportType.add("Weekly Report");
        arrayListReportType.add("Monthly Report");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,arrayListReportType);
        spinnerReportType.setAdapter(adapter);
    }

    void loadAdminDailyReportFragment () {

        AdminDailyReportFragment frg=new AdminDailyReportFragment();
        android.support.v4.app.FragmentManager fm=getFragmentManager();
        android.support.v4.app.FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.adminContainer,frg);
        ft.commit();
    }

    void loadAdminWeeklyReportFragment () {

        AdminWeeklyReportFragment frg=new AdminWeeklyReportFragment();
        android.support.v4.app.FragmentManager fm=getFragmentManager();
        android.support.v4.app.FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.adminContainer,frg);
        ft.commit();
    }
    void loadAdminMonthlyReportFragment () {

        AdminMonthlyReportFragment frg=new AdminMonthlyReportFragment();
        android.support.v4.app.FragmentManager fm=getFragmentManager();
        android.support.v4.app.FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.adminContainer,frg);
        ft.commit();
    }

    public void sendRequest() {

        String requesturl = "http://139.59.78.52:8080/HR_Application/ValidateEmpServlet";
        Log.e("mainAct_requesturl",""+requesturl);
        StringRequest stringRequest = new StringRequest(requesturl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Response", "" + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    JSONObject jsonObject1=null;

                  for(int i=0;i<jsonArray.length();i++)
                  {
                      jsonObject1=jsonArray.getJSONObject(i);
                      String empname=jsonObject1.getString("empname");
                      arrayListempname.add(empname);
                  }

                    setemployeespinner();


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

    public void setemployeespinner()
    {
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,arrayListempname);
        spinnerempname.setAdapter(adapter);
    }

    public void sendReportRequest()
    {   al=new ArrayList<>();
        Pojo pojo=new Pojo("Date","CompanyName","Role","task","Note","Start_Time","Stop_Time","total_Time","Status");
        al.add(pojo);
        StringRequest stringRequest=new StringRequest(requesturl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Response",""+response);
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonArray=jsonObject.getJSONArray("data");
                    JSONObject jsonObject1=null;

                    Pojo pojo=null;

                    for(int i=0;i<jsonArray.length();i++)
                    {
                        jsonObject1=jsonArray.getJSONObject(i);
                        String date=jsonObject1.getString("date");
                        String role=jsonObject1.getString("role");
                        role=role.replace("_"," ");
                        String task=jsonObject1.getString("task");
                        task=task.replace("_"," ");
                        String start_time=jsonObject1.getString("start_time");
                        String stop_time=jsonObject1.getString("stop_time");
                        String total_time=jsonObject1.getString("total_time");
                        String status=jsonObject1.getString("status");
                        String note=jsonObject1.getString("note");
                        note=note.replace("_"," ");
                        String cname=jsonObject1.getString("companyname");
                        pojo=new Pojo(date,role,task,start_time,stop_time,total_time,status,note,cname);
                        al.add(pojo);

                    }

                    //createPdf();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error",""+error);
            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }





    public String getMonthName(int month)
    {
      String monthname="";
        if(month == 0)
        {
            monthname="January";
        }
        if(month == 1)
        {
            monthname="February";
        }
        if(month == 2)
        {
            monthname="March";
        }
        if(month == 3)
        {
            monthname="April";
        }
        if(month == 4)
        {
            monthname="May";
        }
        if(month == 5)
        {
            monthname="June";
        }
        if(month == 6)
        {
            monthname="July";
        }
        if(month == 7)
        {
            monthname="August";
        }
        if(month == 8)
        {
            monthname="September";
        }
        if(month == 9)
        {
            monthname="October";
        }
        if(month == 10)
        {
            monthname="November";
        }
        if(month == 11)
        {
            monthname="December";
        }
        return monthname;

    }



    private boolean checkIfAlreadyhavePermission() {
        int result = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }
    private void requestForSpecificPermission() {
        Toast.makeText(getContext(),"Click on Allow for generating Report",Toast.LENGTH_LONG).show();
        ActivityCompat.requestPermissions((Activity) getContext(), new String[]{Manifest.permission.GET_ACCOUNTS, Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_SMS, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 101);

    }

    public void setPermission()
    {
        int MyVersion = Build.VERSION.SDK_INT;
        if (MyVersion > Build.VERSION_CODES.LOLLIPOP_MR1) {
            if (!checkIfAlreadyhavePermission()) {
                requestForSpecificPermission();
            }
        }
    }


    private  void saveExcelFile(Context context, String fileName) {

        // check if available and not read only
        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {

            return;
        }

        Log.e("aldata","aldata"+al);
        if(al.size()>1)
        {
            //New Workbook
            Workbook wb = new HSSFWorkbook();

            Cell c = null;
            Row row=null;
            Pojo pojo=null;

            //New Sheet
            org.apache.poi.ss.usermodel.Sheet sheet1 = null;
            sheet1 =  wb.createSheet(fileName);

            // Generate column headings







           Row rowdefault = sheet1.createRow(0);
            c=rowdefault.createCell(0);
            c.setCellValue("Date");

            c=rowdefault.createCell(1);
            c.setCellValue("Company Name");


            c=rowdefault.createCell(2);
            c.setCellValue("Role");


            c=rowdefault.createCell(3);
            c.setCellValue("Task name");

            c=rowdefault.createCell(4);
            c.setCellValue("Note");

            c=rowdefault.createCell(5);
            c.setCellValue("Start Time");
            c=rowdefault.createCell(6);
            c.setCellValue("Stop Time");
            c=rowdefault.createCell(7);
            c.setCellValue("Total Time");
            c=rowdefault.createCell(8);
            c.setCellValue("Status");


            for(int i=1;i<al.size();i++) {
                row = sheet1.createRow(i);

               pojo=al.get(i);

                c=row.createCell(0);
                c.setCellValue(pojo.getData());

                c=row.createCell(1);
                c.setCellValue(pojo.getCompanyname());

               String  rolename=pojo.getRole();
                rolename=rolename.replace("_"," ");
                c=row.createCell(2);
                c.setCellValue(rolename);

                String taskname=pojo.getTask();
                taskname=taskname.replace("_"," ");
                c=row.createCell(3);
                c.setCellValue(taskname);

                c=row.createCell(4);
                c.setCellValue(pojo.getNote());

                c=row.createCell(5);
                c.setCellValue(pojo.getStart_time());
                c=row.createCell(6);
                c.setCellValue(pojo.getStop_time());
                c=row.createCell(7);
                c.setCellValue(pojo.getTotal_time());
                c=row.createCell(8);
                c.setCellValue(pojo.getStatus());

            }
            //
            //  c.setCellStyle(cs);

            sheet1.setColumnWidth(0, (15 * 300));
            sheet1.setColumnWidth(1, (15 * 300));
            sheet1.setColumnWidth(2, (15 * 300));
            sheet1.setColumnWidth(3, (15 * 1000));
            sheet1.setColumnWidth(4, (15 * 1000));
            sheet1.setColumnWidth(5, (15 * 300));
            sheet1.setColumnWidth(6, (15 * 300));
            sheet1.setColumnWidth(7, (15 * 150));
            sheet1.setColumnWidth(8, (15 * 300));


            // Create a path where we will place our List of objects on external storage
            File file = new File(Environment.getExternalStorageDirectory(), fileName+".xls");
            FileOutputStream os = null;

            try {
                os = new FileOutputStream(file);
                wb.write(os);
                Log.w("FileUtils", "Writing file" + file);
                //   success = true;
            } catch (IOException e) {
                Log.w("FileUtils", "Error writing " + file, e);
                Toast.makeText(getContext(), "Week Connection", Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Log.w("FileUtils", "Failed to save file", e);
                Toast.makeText(getContext(), "Week Connection", Toast.LENGTH_LONG).show();
            } finally {

                try {
                    if (null != os)
                        os.close();
                } catch (Exception ex) {
                }
            }

            Toast.makeText(getContext(),"Report Generated",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getContext(), "Connection Problem,Unable to Generate Report", Toast.LENGTH_LONG).show();
        }

          }

    public static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    public static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }
}
