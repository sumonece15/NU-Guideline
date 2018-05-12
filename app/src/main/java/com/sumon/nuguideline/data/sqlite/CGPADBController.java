package com.sumon.nuguideline.data.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.sumon.nuguideline.model.ResultHistory;

import java.util.ArrayList;

/**
 * Created by sumon on 5/11/2018.
 */

public class CGPADBController {

    private DatabaseHelper dbHelper;
    private Context mContext;
    private SQLiteDatabase database;

    public CGPADBController(Context context) {
        mContext = context;
    }

    public CGPADBController open() throws SQLException {
        dbHelper = new DatabaseHelper(mContext);
        database = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dbHelper.close();
    }

    public long insertResultHistoryItem(String studentName, String studentCGPA, String semesterName) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DbConstants.KEY_STUDENT_NAME, studentName);
        contentValue.put(DbConstants.KEY_STUDENT_CGPA, studentCGPA);
        contentValue.put(DbConstants.KEY_STUDENT_SEMESTER, semesterName);

        return database.insert(DbConstants.TABLE_HISTORY, null, contentValue);
    }

    public ArrayList<ResultHistory> getAllHistoryResultData()
    {
        ArrayList<ResultHistory> resultHistoryList = new ArrayList<>();

        Cursor cursor = database.rawQuery("select * from "+DbConstants.TABLE_HISTORY, null);
        if (cursor != null && cursor.getCount() > 0) {
            try {
                cursor.moveToFirst();
                while (cursor.isAfterLast() == false) {

                    String studentName   = cursor.getString(cursor.getColumnIndex(DbConstants.KEY_STUDENT_NAME));
                    String studentCGPA   = cursor.getString(cursor.getColumnIndex(DbConstants.KEY_STUDENT_CGPA));
                    String studentSemester   = cursor.getString(cursor.getColumnIndex(DbConstants.KEY_STUDENT_SEMESTER));

                    if (!studentCGPA.equals("0.00")) {
                        resultHistoryList.add(new ResultHistory(studentName, studentCGPA, studentSemester));
                    }
                    cursor.moveToNext();
                }
            } catch (Exception ex) {
            }
        }
        return resultHistoryList;
    }

    public void deleteHistoryItemById(long keyId) {
        database.delete(DbConstants.TABLE_HISTORY, DbConstants.KEY_ID + "=" + keyId, null);
    }

}
