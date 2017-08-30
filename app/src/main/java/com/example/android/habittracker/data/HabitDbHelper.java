package com.example.android.habittracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.example.android.habittracker.data.HabitContract.HabitEntry.SQL_CREATE_HABITS_TABLE;
import static com.example.android.habittracker.data.HabitContract.HabitEntry;

/**
 * Created by djp on 8/28/17.
 */

public class HabitDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "HabitEntry.db";

    public HabitDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_HABITS_TABLE);
    }
    //placeholder for required implemented methods for SQLiteOpenHelper subclass
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
    }
    public Cursor readHabits() {
        SQLiteDatabase db = this.getReadableDatabase();
            String[] projection = {
                    HabitEntry._ID,
                    HabitEntry.COLUMN_HABIT_NAME,
                    HabitEntry.COLUMN_HABIT_CATEGORY,
                    HabitEntry.COLUMN_HABIT_DURATION
            };

            Cursor cursor = db.query(
                    HabitEntry.TABLE_NAME,
                    projection,
                    null,
                    null,
                    null,
                    null,
                    null
            );
            return cursor;
    }
    public void insertHabit() {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_HABIT_NAME, "run");
        values.put(HabitEntry.COLUMN_HABIT_CATEGORY, "exercise");
        values.put(HabitEntry.COLUMN_HABIT_DURATION, 60);

        long newRowId = db.insert(HabitEntry.TABLE_NAME, null, values);
        Log.v("MainActivity", "value of newRowId in insertHabit method: " + newRowId);
    }

}
