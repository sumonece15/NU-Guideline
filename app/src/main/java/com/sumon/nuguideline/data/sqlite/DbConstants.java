package com.sumon.nuguideline.data.sqlite;

/**
 * Created by sumon on 5/11/2018.
 */

public class DbConstants {

    // Database Version
    public static final int DATABASE_VERSION = 1;

    // Database Name
    public static final String DATABASE_NAME = "resultHistoryDB";

    // Table Names
    public static final String TABLE_HISTORY = "table_history";


    // Common column names
    public static final String KEY_ID              = "id";
    public static final String KEY_STUDENT_NAME    = "student_name";
    public static final String KEY_STUDENT_CGPA  = "student_cgpa";
    public static final String KEY_STUDENT_SEMESTER      = "student_semester";




    // WISH table create statement
    public static final String CREATE_TABLE_HISTORY = "CREATE TABLE "+ TABLE_HISTORY + "("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_STUDENT_NAME + " TEXT,"
            + KEY_STUDENT_CGPA + " TEXT,"
            + KEY_STUDENT_SEMESTER + " TEXT )";

}
