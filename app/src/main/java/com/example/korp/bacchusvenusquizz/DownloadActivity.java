package com.example.korp.bacchusvenusquizz;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DownloadActivity extends AppCompatActivity {

    File f;
    String fString;
    private String file_url;
    private String fileDir;
    private String categoryList;
    private String website;

    String bovFolder;
    String sexFolder;
    String alcoholFolder;
    String miscFolder;
    String memesFolder;
    TextView t;
    ArrayList<String> urls = new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        website = "http://projekt.binninge.se/";
        bovFolder = "bovquiz/";
        sexFolder = "sex/";
        alcoholFolder = "alcohol/";
        miscFolder = "misc/";
        memesFolder = "memes/";
        t=(TextView)findViewById(R.id.testTextView);



        ActivityCompat.requestPermissions(DownloadActivity.this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.INTERNET},
                0);

    }




    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 0: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {



                    File bov = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), bovFolder);
                    File sex = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + bovFolder, sexFolder);
                    File alcohol = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + bovFolder, alcoholFolder);
                    File misc = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + bovFolder, miscFolder);
                    File memes = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + bovFolder, memesFolder);
                    //String fString = f.toString();
                    // Log.d("FOLDER", fString);
                    if (!bov.exists()) {
                        bov.mkdirs();
                    }

                    if (!sex.exists()) {
                        sex.mkdirs();
                    }

                    if (!alcohol.exists()) {
                        alcohol.mkdirs();
                    }

                    if (!misc.exists()) {
                        misc.mkdirs();
                    }

                    if (!memes.exists()) {
                        memes.mkdirs();
                    }



                 //   String alcoList = "http://projekt.binninge.se/bovquiz/alcohol/niclasbinninge/2019-02-21-13-21_alcohol.json";
                    readList(alcoholFolder, "http://projekt.binninge.se/bovquiz/alcohol/alcohollist.txt");
                    readList(sexFolder, "http://projekt.binninge.se/bovquiz/sex/sexlist.txt");
                    readList(memesFolder, "http://projekt.binninge.se/bovquiz/memes/memeslist.txt");
                    readList(miscFolder, "http://projekt.binninge.se/bovquiz/misc/misclist.txt");
                //    new DownloadFile().execute(alcoList, alcoholFolder);


                   /* Intent intent = new Intent(getApplicationContext(), Download2Activity.class);
                    startActivity(intent);*/
                 ;



                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(DownloadActivity.this, "Permission denied to write to your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }


        }
    }

    public void readList(final String category, final String url) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                //to read each line
                //TextView t; //to show the result, please declare and find it inside onCreate()


                try {
                    // Create a URL for the desired page
                    URL ur = new URL(url); //My text file location
                    //First open the connection
                    HttpURLConnection conn = (HttpURLConnection) ur.openConnection();
                    conn.setConnectTimeout(60000); // timing out in a minute

                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    // ideally do this in onCreate()
                    String str;
                    while ((str = in.readLine()) != null) {
                        urls.add(str);
                    }
                    in.close();
                } catch (Exception e) {
                    Log.d("MyTag", e.toString());
                }




                //since we are in background thread, to post results we have to go back to ui thread. do the following for that

                DownloadActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        for (int i = 0; i < urls.size(); i++) {
                          //  Log.d("David", urls.get(i));
                            new DownloadFile().execute(urls.get(i), category);
                            t.setText(urls.get(i));

                        }
                    }
                });
            }
        });

    }

    private class DownloadFile extends AsyncTask<String, String, String> {


        private ProgressDialog progressDialog;
        private String fileName;
        private String folder;
        //private boolean isDownloaded;


        /**
         * Before starting background thread
         * Show Progress Bar Dialog
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            this.progressDialog = new ProgressDialog(DownloadActivity.this);
            this.progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            this.progressDialog.setCancelable(false);
            this.progressDialog.show();
        }

        /**
         * Downloading file in background thread
         */
        @Override
        protected String doInBackground(String... f_url) {
            int count;

            try {
                String targetDir = bovFolder + f_url[1];

                Log.d("David", targetDir);
                Log.d("David", f_url[0]);


                URL url = new URL(f_url[0]);
                URLConnection connection = url.openConnection();
                connection.connect();
                // getting file length
                int lengthOfFile = connection.getContentLength();


                // input stream to read file - with 8k buffer
                InputStream input = new BufferedInputStream(url.openStream(), 8192);

              //  String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

                //Extract file name from URL
                fileName = f_url[0].substring(f_url[0].lastIndexOf('/') + 1, f_url[0].length());








                //External directory path to save file
                folder = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + targetDir;
                Log.d("David", folder);

                Log.d("DUH", folder);
                // Output stream to write file
                OutputStream output = new FileOutputStream(folder + fileName);

                byte data[] = new byte[1024];

                long total = 0;

                while ((count = input.read(data)) != -1) {
                    total += count;
                    // publishing the progress....
                    // After this onProgressUpdate will be called
                    publishProgress("" + (int) ((total * 100) / lengthOfFile));


                    // writing data to file
                    output.write(data, 0, count);
                }

                // flushing output
                output.flush();

                // closing streams
                output.close();
                input.close();
                return "Downloaded at: " + targetDir;

            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }


            return "Something went wrong";
        }

        /**
         * Updating progress bar
         */
        protected void onProgressUpdate(String... progress) {
            // setting progress percentage
            progressDialog.setProgress(Integer.parseInt(progress[0]));
        }


        @Override
        protected void onPostExecute(String message) {
            // dismiss the dialog after the file was downloaded
            this.progressDialog.dismiss();

            // Display File path after downloading
            Toast.makeText(getApplicationContext(),
                    message, Toast.LENGTH_LONG).show();
        }
    }






}


