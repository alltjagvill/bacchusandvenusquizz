package com.example.korp.bacchusvenusquizz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityGenre extends AppCompatActivity {

    private String folderpath;
    final String MYPREFERENCES = "MYPREFERENCES";
    final String NAME_KEY = "namekey";

    EditText namefield;
    TextView displayNameField;
    String checkNameField;

    SharedPreferences sharedPref;
    String savedName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);

        namefield = (EditText)findViewById(R.id.teamName);
        displayNameField = findViewById(R.id.teamNameTextField);

        sharedPref = getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);

        savedName = sharedPref.getString(NAME_KEY, null);







        if (savedName != null) {
            displayNameField.setText(savedName);
        }

    }



    public void startSex(View sexView) {


        if (savedName == null) {

            if (namefield.getText().toString().equals(""))
                setName();

            else
                saveName();
        }

        else {
        checkNewName();
        Intent sex = new Intent(getApplicationContext(), ListQuizActivity.class);
        String title = getString(R.string.headline_sex);
        folderpath = getString(R.string.sex_folder);
        sex.putExtra("CATEGORY", folderpath);
        sex.putExtra("HEADLINE", title);

        startActivity(sex);
    }
    }

    public void startMemes(View memesView) {

        if (savedName == null) {

            if (namefield.getText().toString().equals(""))
                setName();

            else
                saveName();
        }

        else {
        checkNewName();

        Intent memes = new Intent(getApplicationContext(), ListQuizActivity.class);
        String title = getString(R.string.headline_memes);
        folderpath = getString(R.string.memes_folder);
        memes.putExtra("CATEGORY", folderpath);
        memes.putExtra("HEADLINE", title);
        startActivity(memes);
    }
     }

    public void startAlcohol(View alcoholView) {

        if (savedName == null) {

            if (namefield.getText().toString().equals(""))
                setName();

            else
                saveName();
        }

        else {
        checkNewName();
        Intent alcohol = new Intent(getApplicationContext(), ListQuizActivity.class);
        String title = getString(R.string.headline_alcohol);
        folderpath = getString(R.string.alcohol_folder);
        alcohol.putExtra("CATEGORY", folderpath);
        alcohol.putExtra("HEADLINE", title);
        startActivity(alcohol);
    }
    }

    public void startMisc(View miscView) {




        if (savedName == null) {

            if (namefield.getText().toString().equals(""))
                setName();

            else
                saveName();
        }

        else {
        checkNewName();
        Intent misc = new Intent(getApplicationContext(), ListQuizActivity.class);
        String title = getString(R.string.headline_misc);
        folderpath = getString(R.string.misc_folder);
        misc.putExtra("CATEGORY", folderpath);
        misc.putExtra("HEADLINE", title);
        startActivity(misc);
    }
    }


    public void saveName() {



        String name = namefield.getText().toString();
        SharedPreferences.Editor editPref = sharedPref.edit();

        editPref.putString(NAME_KEY, name);
        editPref.commit();
        savedName = sharedPref.getString(NAME_KEY, null);
        displayNameField.setText(savedName);


    }

    public void setName() {

        String toastText = getString(R.string.enter_name);
        Toast.makeText(getApplicationContext(), toastText, Toast.LENGTH_SHORT).show();
    }

    private boolean nameFieldEmtpy(EditText namefield) {
        if (namefield.getText().toString().trim().length() > 0)
            return false;

        return true;
    }

    public void checkNewName() {
        String oldName = displayNameField.getText().toString();
        String newName = namefield.getText().toString();
        boolean isNotEmpty = namefield.getText().toString().equals("");

        if (!newName.equals(oldName) && !isNotEmpty ) {
            Log.d("NAME", oldName);
            Log.d("NAME", newName);
            saveName();
        }
    }

}
