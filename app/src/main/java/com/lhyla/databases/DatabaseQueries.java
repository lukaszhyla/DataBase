package com.lhyla.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.util.ArrayList;

import static com.lhyla.databases.MoviesDbHelper.SQL_DELETE_MOVIES;

public class DatabaseQueries {
    private SQLiteDatabase db;
    private MoviesDbHelper moviesDbHelper;
    public static final String TAG = "LH";


    public ArrayList<MovieModel> getAllRecords() {

        Log.d(TAG,"DatabaseQueries getAllRecords() before openTheReding()");
        db = this.openTheReading();
        Cursor cursor = db.query(MovieContract.MovieTable.TABLE_NAME,
                null, null, null, null, null, null, null);
        ArrayList<MovieModel> movieModelsList = new ArrayList<>();
        MovieModel movieModel;
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                movieModel = new MovieModel();
                movieModel.setFilmID(cursor.getString(0));
                movieModel.setFilmName(cursor.getString(1));
                movieModel.setFilmBudget(cursor.getString(2));
                movieModel.setFilmProductionYear(cursor.getString(3));
                movieModelsList.add(movieModel);
            }
        }
        Log.d(TAG,"DatabaseQueries getAllRecords() after openTheReding()");
        cursor.close();
        db.close();
        return movieModelsList;
    }

    public void dropTable(){
        Log.d(TAG,"DatabaseQueries dropTable()");
        db.execSQL(SQL_DELETE_MOVIES);
    }

    public DatabaseQueries(Context context) {
        moviesDbHelper = new MoviesDbHelper(context);
    }

    public void openTheWriting() {
        db = moviesDbHelper.getWritableDatabase();
    }

    public SQLiteDatabase openTheReading() {
        return db = moviesDbHelper.getReadableDatabase();
    }

    public void close() {
        db.close();
    }

    public long addToDataBase(String filmName, String budget, String productionYear) {

        ContentValues values = new ContentValues();
        Log.d(TAG, "MainActivity onCreate() before create values.put()");
        values.put(MovieContract.MovieTable.COLUMN_FILM_NAME, filmName);
        values.put(MovieContract.MovieTable.COLUMN_FILM_BUDGET, budget);
        values.put(MovieContract.MovieTable.COLUMN_FILM_PRODUCTION_YEAR, productionYear);

        Log.d(TAG, "MainActivity onCreate() before create long newRowId");
        long newRowId = db.insert(MovieContract.MovieTable.TABLE_NAME, null, values);
        return newRowId;

//        Log.d(TAG, "MainActivity onCreate() definig String[] projection");
//        String[] projection = {
//                MovieContract.MovieTable._ID,
//                MovieContract.MovieTable.COLUMN_FILM_NAME,
//                MovieContract.MovieTable.COLUMN_FILM_PRODUCTION_YEAR,
//                MovieContract.MovieTable.COLUMN_FILM_BUDGET
//        };
//        Cursor cursor = db.query(MovieContract.MovieTable.TABLE_NAME, projection,
//                null, null, null, null, null, null);
//
//        List movieList = new ArrayList<>();
//        while (cursor.moveToNext()) {
//            long itemId = cursor.getLong(
//                    cursor.getColumnIndex(MovieContract.MovieTable._ID));
//            movieList.add(itemId);
//        }
//        cursor.close();
    }
}

