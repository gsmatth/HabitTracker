package com.example.android.habittracker;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.android.habittracker.data.HabitContract.HabitEntry;
import com.example.android.habittracker.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {

    private HabitDbHelper mDbHelper;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper = new HabitDbHelper(this);
        mDbHelper.insertHabit();
        cursor = mDbHelper.readHabits();
        logHabits();
    }


    private void logHabits() {
        cursor.moveToFirst();
        int idColumnIndex = cursor.getColumnIndex(HabitEntry._ID);
        int nameColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_NAME);

        int currentId = cursor.getInt(idColumnIndex);
        String currentName = cursor.getString(nameColumnIndex);

        Log.v("MainActivity", "value of row 1 id in habit table: " + currentId);
        Log.v("MainActivity", "value of row 1 name in habit table: " + currentName);


    }
}
