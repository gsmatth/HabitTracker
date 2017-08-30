package com.example.android.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by djp on 8/28/17.
 */

public final class HabitContract {
    //empty constructor prevents the initializing of an instance of HabitContract class
    private HabitContract(){}

    //inner class for "habits" table
    public static final class HabitEntry implements BaseColumns{
        public static final String TABLE_NAME = "habits";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_HABIT_NAME = "name";
        public static final String COLUMN_HABIT_CATEGORY = "category";
        public static final String COLUMN_HABIT_DURATION = "duration";

        public static final String SQL_CREATE_HABITS_TABLE =
                "CREATE TABLE " + HabitEntry.TABLE_NAME + "( " +
                        HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        HabitEntry.COLUMN_HABIT_NAME + " TEXT NOT NULL," +
                        HabitEntry.COLUMN_HABIT_CATEGORY + " TEXT NOT NULL," +
                        HabitEntry.COLUMN_HABIT_DURATION + " INTEGER NOT NULL DEFAULT 0)";

        public static final String SQL_DELETE_HABITS_TABLE =
                "DROP TABLE IF EXISTS " + HabitEntry.TABLE_NAME;


    }
}
