package rlard008.rlard.com.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by sudhakar on 9/28/17.
 */

public class DataBase extends SQLiteOpenHelper {

    public DataBase(Context context)
    {
        super(context,"sqlitedb",null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table sqlitedata(rollno integer primary key,name text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public boolean insertData(Student student)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("rollno",student.getRollno());
        cv.put("name",student.getName());
        long result=db.insert("sqlitedata",null,cv);
        if(result == -1)
        {
            return false;
        }
        return true;

    }
    public ArrayList<Student> getData()
    {
        String query="select * from sqlitedata";
        ArrayList<Student>al=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query,null);

        Student student=null;
        while (cursor.moveToNext())
        {
            int rollno=cursor.getInt(0);
            String name=cursor.getString(1);
            student=new Student(rollno,name);
            al.add(student);
        }
        return al;
    }
    public void updateData(int rollno,String name)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",name);

        db.update("sqlitedata",cv,"rollno=?",new String[]{""+rollno});
    }

    public void deleteData(int rollno)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete("sqlitedata","rollno=?",new String[]{""+rollno});
    }

}
