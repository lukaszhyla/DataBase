package com.lhyla.databases;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "LH";
    private DatabaseQueries databaseQueries;

    @BindView(R.id.main_act_film_name_edit_text)
    EditText filmNameEditText;

    @BindView(R.id.main_act_film_budget_edit_text)
    EditText filmBudgetEditText;

    @BindView(R.id.main_act_film_year_creation_edit_text)
    EditText creationYearEditText;

    @BindView(R.id.main_act_film_database_text_view)
    TextView databaseTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Log.d(TAG, "MainActivity onCreate()");
        databaseQueries = new DatabaseQueries(MainActivity.this);
        databaseQueries.openTheWriting();
    }

    @OnClick(R.id.main_act_create_film_btn)
    public void createFilmOnClick() {

        String filmName = filmNameEditText.getText().toString();
        String filmBudget = filmBudgetEditText.getText().toString();
        String creationYear = creationYearEditText.getText().toString();

        Log.d(TAG, "MainActivity createFilmOnClick() before addToDatabase");
        long idLong = databaseQueries.addToDataBase(filmName, filmBudget, creationYear);

        String id = String.valueOf(idLong);
        databaseTextView.setText(id);
        Log.d(TAG, "MainActivity createFilmOnClick() after addToDatabase");
    }

    @Override
    protected void onDestroy() {
        databaseQueries.close();
        super.onDestroy();
    }

    @OnClick(R.id.main_act_get_all_records_btn)
    public void allRecordsOnClick() {
        List<MovieModel> movieModelList = databaseQueries.getAllRecords();

        StringBuilder stringBuilder = new StringBuilder();
        String movies ="";
        for (MovieModel movieModel : movieModelList) {

            String filmID = movieModel.getFilmID();
            String filmName = movieModel.getFilmName();
            String filmBudget = movieModel.getFilmBudget();
            String filmProductionYear = movieModel.getFilmProductionYear();

            stringBuilder.append(filmID + " " + filmName + " " + filmBudget + " " + filmProductionYear + "\n");
            movies = stringBuilder.toString();
            databaseTextView.setText(movies);
        }
    }

    @OnClick(R.id.main_act_drop_table_btn)
    public void dropTableOnClick(){
        databaseQueries.dropTable();
    }
}