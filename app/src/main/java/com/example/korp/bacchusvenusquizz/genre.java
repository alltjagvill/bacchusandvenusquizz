package com.example.korp.bacchusvenusquizz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class genre extends AppCompatActivity {

    private String folderpath;
    /*final String MYPREFERENCES = "MYPREFERENCES";
    final String NAME_KEY = "namekey";

    EditText namefield = findViewById(R.id.teamName);
    SharedPreferences sharedPref;*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);

        /*sharedPref = getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);
        String savedName = sharedPref.getString(NAME_KEY, null);

        if (savedName != null) {
            namefield.setText(savedName);
        }*/

        }



    public void startSex(View sexView) {
       /* if (namefield == null) {

            setName();
        }*/

       /* else {*/
            //saveName();

            Intent sex = new Intent(getApplicationContext(), ListQuizActivity.class);
            String title = getString(R.string.headline_sex);
            folderpath = getString(R.string.sex_folder);
            sex.putExtra("CATEGORY", folderpath);
            sex.putExtra("HEADLINE", title);

            startActivity(sex);
        }
    //}

    public void startMemes(View memesView) {
       /* if (namefield == null) {

            setName();
        }

        else {*/
            //saveName();
            Intent memes = new Intent(getApplicationContext(), ListQuizActivity.class);
            String title = getString(R.string.headline_memes);
            folderpath = getString(R.string.memes_folder);
            memes.putExtra("CATEGORY", folderpath);
            memes.putExtra("HEADLINE", title);
            startActivity(memes);
        }
   // }

    public void startAlcohol(View alcoholView) {
        /*if (namefield == null) {

            setName();
        }

        else {
            saveName();*/

            Intent alcohol = new Intent(getApplicationContext(), ListQuizActivity.class);
            String title = getString(R.string.headline_alcohol);
            folderpath = getString(R.string.alcohol_folder);
            alcohol.putExtra("CATEGORY", folderpath);
            alcohol.putExtra("HEADLINE", title);
            startActivity(alcohol);
        }
    //}

    public void startMisc(View miscView) {

      /*  if (namefield == null) {

            setName();
        }

        else {
            saveName();*/

            Intent misc = new Intent(getApplicationContext(), ListQuizActivity.class);
            String title = getString(R.string.headline_misc);
            folderpath = getString(R.string.misc_folder);
            misc.putExtra("CATEGORY", folderpath);
            misc.putExtra("HEADLINE", title);
            startActivity(misc);
        }
    //}


    /*public void saveName() {

        String name = namefield.getText().toString();




        SharedPreferences.Editor editPref = sharedPref.edit();

        editPref.putString(NAME_KEY, name);
        editPref.commit();
    }

    public void setName() {

        String toastText = getString(R.string.enter_name);
        Toast.makeText(getApplicationContext(), toastText, Toast.LENGTH_SHORT);
    }*/

}
