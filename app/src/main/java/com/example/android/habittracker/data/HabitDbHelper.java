package com.example.android.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.example.android.habittracker.data.HabitContract.HabitEntry.SQL_CREATE_HABITS_TABLE;
import static com.example.android.habittracker.data.HabitContract.HabitEntry.SQL_DELETE_HABITS_TABLE;

/**
 * Created by djp on 8/28/17.
 */

public class HabitDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "HabitEntry.db";

    public HabitDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.v("HabitDbHelper", "creating instance of HabitDbHelper");
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_HABITS_TABLE);
        Log.v("HabitDbHelper", "onCreate executed and habits table created");
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(SQL_DELETE_HABITS_TABLE);
        onCreate(db);
        Log.v("HabitDbHelper", "Upgraded version of table");
    }

}
