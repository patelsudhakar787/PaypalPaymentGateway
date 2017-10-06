package rlard.hr.rlard008.hr_app.localdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import rlard.hr.rlard008.hr_app.Pojo.SaveData;

/**
 * Created by sudhakar on 5/11/17.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    public DataBaseHelper(Context context) {
        super(context,"rlard.sqlite",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query="create table reportdata(taskname text primary key,role text,starttime text,pausetime text,resumetime text,stoptime text,timetaken integer,status text,checkbtn text,process text,startcolor text,stopcolor text,note text,companyname text)";
        db.execSQL(query);
        Log.e("DB","created");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public boolean insertTaskData(SaveData saveData)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("taskname",saveData.getTaskname());
        contentValues.put("role",saveData.getRole());
        contentValues.put("starttime",saveData.getStarttime());
        contentValues.put("pausetime",saveData.getPausetime());
        contentValues.put("resumetime",saveData.getResumetime());
        contentValues.put("stoptime",saveData.getStoptime());
        contentValues.put("timetaken",saveData.getTimetaken());
        contentValues.put("status",saveData.getStatus());
        contentValues.put("checkbtn",saveData.getCheckbutton());
        contentValues.put("process",saveData.getProcessstatus());
        contentValues.put("startcolor",saveData.getStartcolor());
        contentValues.put("stopcolor",saveData.getStopcolor());
        contentValues.put("note",saveData.getNote());
        contentValues.put("companyname",saveData.getCompanyname());

        long result=sqLiteDatabase.insert("reportdata",null,contentValues);
        if(result==-1)
        {
            return false;
        }
        return true;
    }


    //update sqlite database
    public boolean updateData(SaveData saveData)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("taskname",saveData.getTaskname());
        contentValues.put("role",saveData.getRole());
        contentValues.put("starttime",saveData.getStarttime());
        contentValues.put("pausetime",saveData.getPausetime());
        contentValues.put("resumetime",saveData.getResumetime());
        contentValues.put("stoptime",saveData.getStoptime());
        contentValues.put("timetaken",saveData.getTimetaken());
        contentValues.put("status",saveData.getStatus());
        contentValues.put("checkbtn",saveData.getCheckbutton());
        contentValues.put("process",saveData.getProcessstatus());
        contentValues.put("startcolor",saveData.getStartcolor());
        contentValues.put("stopcolor",saveData.getStopcolor());
        contentValues.put("note",saveData.getNote());
        contentValues.put("companyname",saveData.getCompanyname());
        sqLiteDatabase.update("reportdata",contentValues,"taskname=?",new String[]{saveData.getTaskname()});
        return true;
    }



    public ArrayList<SaveData> getData()
    {
        ArrayList<SaveData>arrayListsave=new ArrayList<>();

        String selectquery="select * from reportdata";
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery(selectquery,null);


        SaveData saveData=null;
        if(cursor.moveToFirst()){
            do {
                String taskname=cursor.getString(0);
                String role=cursor.getString(1);
                String starttime=cursor.getString(2);
                String pausetime=cursor.getString(3);
                String resumetime=cursor.getString(4);
                String stoptime=cursor.getString(5);
                int timetaken=cursor.getInt(6);
                String status=cursor.getString(7);
                String checkbtn=cursor.getString(8);
                String process=cursor.getString(9);
                String startcolor=cursor.getString(10);
                String stopcolor=cursor.getString(11);
                String note=cursor.getString(12);
                String companyname=cursor.getString(13);
                saveData=new SaveData(taskname,role,starttime,pausetime,resumetime,stoptime,timetaken,status,checkbtn,process,startcolor,stopcolor,note,companyname);
                arrayListsave.add(saveData);

            }
            while (cursor.moveToNext());
        }
        cursor.close();
        sqLiteDatabase.close();
        return arrayListsave;
    }





    public Integer timeTaken(String taskname)
    {
        int ttaken=0;

        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select timetaken from reportdata where taskname=?",new String[]{taskname});

        if(cursor.moveToFirst())
        {
            do{
                ttaken=cursor.getInt(0);

            }
            while (cursor.moveToNext());
        }


        return ttaken;
    }


    public String checkBtn(String taskname)
    {
        String check="";
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select checkbtn from reportdata where taskname=?",new String[]{taskname});

        if(cursor.moveToFirst())
        {
            do{
                check=cursor.getString(0);

            }
            while (cursor.moveToNext());
        }

        return check;

    }



    public Integer deleteData(String taskname)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete("reportdata","taskname=?",new String[]{taskname});


    }

    public String getStartTime() {

        String start_t="";

        String selectquery="select starttime from reportdata";
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery(selectquery,null);


        if(cursor.moveToFirst())
        {
            do{
                start_t=cursor.getString(0);

            }
            while (cursor.moveToNext());
        }

        return start_t;
    }








}
