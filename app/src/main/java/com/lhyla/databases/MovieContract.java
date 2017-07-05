package com.lhyla.databases;

import android.provider.BaseColumns;

/**
 * Created by RENT on 2017-07-04.
 */

public class MovieContract {
    public static final String TAG = "LH";
    private MovieContract() {
    }

    public static class MovieTable implements BaseColumns {
        public static final String TABLE_NAME = "movies";
        public static final String COLUMN_FILM_NAME = "film_name";
        public static final String COLUMN_FILM_BUDGET = "film_budget";
        public static final String COLUMN_FILM_PRODUCTION_YEAR = "film_production_year";
    }
}
