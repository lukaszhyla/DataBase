package com.lhyla.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by RENT on 2017-07-04.
 */


public class MoviesDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Movies.db";
    public static final int DATABASE_VERSION = 3;
    public static final String TAG = "LH";

    public MoviesDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d(TAG,"MoviesDbHelper constructor");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG,"MoviesDbHelper onCreate()");
        db.execSQL(SQL_CREATE_MOVIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_MOVIES);
        onCreate(db);
    }

    public static final String SQL_CREATE_MOVIES =
            "CREATE TABLE " + MovieContract.MovieTable.TABLE_NAME + " (" +
                    MovieContract.MovieTable._ID + " INTEGER PRIMARY KEY," +
                    MovieContract.MovieTable.COLUMN_FILM_NAME + " TEXT," +
                    MovieContract.MovieTable.COLUMN_FILM_BUDGET + " TEXT," +
                    MovieContract.MovieTable.COLUMN_FILM_PRODUCTION_YEAR + " TEXT)";

    public static final String SQL_DELETE_MOVIES =
            "DROP TABLE " + MovieContract.MovieTable.TABLE_NAME;
}
