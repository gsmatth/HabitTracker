package com.example.android.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.MenuPopupWindow;
import android.util.Log;

import com.example.android.habittracker.data.HabitContract;
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
        Log.v("MainActivity", "insertHabit new row id is: " + newRowId);
    }

    private void readHabit() {
        Log.v("MainActivity", "entered readhabit method");

        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        Log.v("MainActivity", "value of readable databse returned in readHabit method: " + db);

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
        Log.v("MainActivity", "value of returned cursor:  " + cursor);

        cursor.moveToFirst();
        int idColumnIndex = cursor.getColumnIndex(HabitEntry._ID);
        int nameColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_NAME);

        int currentId = cursor.getInt(idColumnIndex);
        String currentName = cursor.getString(nameColumnIndex);

        Log.v("MainActivity", "value of row 1 id in habit table: " + currentId);
        Log.v("MainActivity", "value of row 1 name in habit table: " + currentName);


    }
}
