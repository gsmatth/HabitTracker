package com.example.android.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.android.habittracker.data.HabitContract.HabitEntry;
import com.example.android.habittracker.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {

    private HabitDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper = new HabitDbHelper(this);
        insertHabit();
        readHabit();
    }

    private void insertHabit() {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_HABIT_NAME, "run");
        values.put(HabitEntry.COLUMN_HABIT_CATEGORY, "exercise");
        values.put(HabitEntry.COLUMN_HABIT_DURATION, 60);

        long newRowId = db.insert(HabitEntry.TABLE_NAME, null, values);
    }

    private void readHabit() {

        SQLiteDatabase db = mDbHelper.getReadableDatabase();

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

        cursor.moveToFirst();
        int idColumnIndex = cursor.getColumnIndex(HabitEntry._ID);
        int nameColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_NAME);

        int currentId = cursor.getInt(idColumnIndex);
        String currentName = cursor.getString(nameColumnIndex);

        Log.v("MainActivity", "value of row 1 id in habit table: " + currentId);
        Log.v("MainActivity", "value of row 1 name in habit table: " + currentName);


    }
}
