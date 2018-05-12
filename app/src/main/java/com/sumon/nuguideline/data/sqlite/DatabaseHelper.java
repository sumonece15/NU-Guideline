package com.sumon.nuguideline.data.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sumon on 5/11/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = DatabaseHelper.class.getName();


    private static DatabaseHelper dbHelper = null;

    public static DatabaseHelper getInstance(Context context) {
        if(dbHelper == null) {
            dbHelper =  new DatabaseHelper(context);
        }
        return dbHelper;
    }

    public DatabaseHelper(Context context) {
        super(context, DbConstants.DATABASE_NAME, null, DbConstants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(DbConstants.CREATE_TABLE_HISTORY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + DbConstants.TABLE_HISTORY);

        // create new tables
        onCreate(db);
    }
}
