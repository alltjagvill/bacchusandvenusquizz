package com.example.korp.bacchusvenusquizz;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class DownloadActivity extends AppCompatActivity {

    File f;
    String fString;
    private static String file_url = "http://projekt.binninge.se/bovquiz/alcohol/alcohollist.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);


        ActivityCompat.requestPermissions(DownloadActivity.this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.INTERNET, Manifest.permission.ACCESS_NETWORK_STATE},
                0);

      /*  ActivityCompat.requestPermissions(DownloadActivity.this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                2);

        ActivityCompat.requestPermissions(  DownloadActivity.this,
                new String[]{Manifest.permission.INTERNET},
                3);*/






       // Intent intent = new Intent(getApplicationContext(), ActivityGenre.class);

     //   startActivity(intent);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 0: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    String bovFolder = "bovquiz";
                    String sexFolder = "sex";
                    String alcoholFolder = "alcohol";
                    String miscFolder = "misc";
                    String memesFolder = "memes";

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

                    new DownloadFileFromURL().execute(file_url);
                    /*File alcoholList = new File(Environment.getExternalStorageDirectory() + File.separator + bovFolder + File.separator + "list.txt");
                    downloadFile("http://projekt.binninge.se/bovquiz/alcohol/alcohollist.txt", alcoholList);*/

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(DownloadActivity.this, "Permission denied to write to your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }


        }
    }























   /* public void onStart(){
        super.onStart();
        String bovFolder = "bovquiz";
        File f = new File(Environment.getExternalStorageDirectory(), bovFolder);
        String fString = f.toString();
        Log.d("FOLDER", fString);
        if (!f.exists()) {
            f.mkdirs();
        }*/
       //createFolder("bovquiz");
       /* File folder = getFilesDir();
        String folderString = folder.toString();
        Log.i("DUH", folderString);
        File alcoholFolder= new File(folder, "alcohol");
        String alcofolder = alcoholFolder.toString();
        Log.d("ALCOHOLLIST", alcofolder);
        alcoholFolder.mkdir();
        File sexFolder= new File(folder, "sex");
        sexFolder.mkdir();
        File miscFolder = new File(folder, "misc");
        miscFolder.mkdir();
        File memesFolder = new File(folder, "memes");
        memesFolder.mkdir();
        File alcoholList = new File(getFilesDir().getPath() + "/" + "alcohollist.txt");
        String test = alcoholList.toString();
        Log.d("ALCOHOLLIST", test);
        Log.d("ALCOHOLLIST", folderString);
        downloadFile("https://projekt.binninge.se/bovquiz/alcohol/alcohollist.txt", alcoholList);
*/
  //  }
    /*public void createFolder(String fname){
        String myfolder=Environment.getExternalStorageDirectory()+ File.separator +fname;
        Log.d("FOLDER", myfolder);
        File f=new File(myfolder);
        f.mkdir();
        if(!f.exists())
            if(!f.mkdir()){
                Toast.makeText(this, myfolder+" can't be created.", Toast.LENGTH_LONG).show();

            }
            else
                Toast.makeText(this, myfolder+" can be created.", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, myfolder+" already exits.", Toast.LENGTH_LONG).show();
    }
*/




    private static void downloadFile(String url, File outputFile) {
        try {
            URL u = new URL(url);
            URLConnection conn = u.openConnection();
            int contentLength = conn.getContentLength();

            DataInputStream stream = new DataInputStream(u.openStream());

            byte[] buffer = new byte[contentLength];
            stream.readFully(buffer);
            stream.close();

            DataOutputStream fos = new DataOutputStream(new FileOutputStream(outputFile));
            String outFile = outputFile.toString();
            Log.d("DUH", outFile);
            fos.write(buffer);
            fos.flush();
            fos.close();
        } catch(FileNotFoundException e) {
            return; // swallow a 404
        } catch (IOException e) {
            return; // swallow a 404
        }
    }



}
