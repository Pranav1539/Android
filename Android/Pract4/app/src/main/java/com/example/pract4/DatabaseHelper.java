package com.example.pract4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DatabaseHelper extends SQLiteOpenHelper {
    public static String databaseName="db_pranav_12.db";
    public DatabaseHelper(Context context) {
        super(context,databaseName,null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE student");
        db.execSQL("create table student(Name varchar(30)," + "RollNo numeric(20) primary key," + "email varchar(50)," + "Course varchar(20))");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { db.execSQL("DROP TABLE IF EXISTS student");
        onCreate(db);
    }
    public boolean insertData(String[] data){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("Name",data[0]);
        values.put("RollNo",Integer.parseInt(data[1]));
        values.put("email",data[2]);
        values.put("Course",data[3]);
        Long result=db.insert("student",null,values);
        if(result==-1){
            return false;
        }
        return true;
    }
    public Cursor showData(){
        SQLiteDatabase db=this.getReadableDatabase();
        String query = "select * from student";
        Cursor res = db.rawQuery(query,null);
        return res;
    }
    public boolean deleteData(int r){
        SQLiteDatabase db=this.getWritableDatabase(); int res = db.delete("student","RollNo="+r+"",null); if(res==-1){
            return false;
        }
        return true;
    }
    public boolean updateData(int r, String name){ SQLiteDatabase db= this.getWritableDatabase(); ContentValues data= new ContentValues();
        data.put("Name",name);
        int res= db.update("student",data,"RollNo='"+r+"'",null); if(res==-1){
            return false;
        }
        return true;
    }
}