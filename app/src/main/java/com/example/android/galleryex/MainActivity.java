package com.example.android.galleryex;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private static String[] mURls;
private String[] mPostersPaths;
    GridView gridview = (GridView) findViewById(R.id.gridview);

    static {
        mURls = new String[]{

                "https://api.themoviedb.org/3/discover/movie?api_key=01a844fdf284bf000e57f284487770ef&sort_by=popularity.desc",
                "https://api.themoviedb.org/3/discover/movie?api_key=01a844fdf284bf000e57f284487770ef&sort_by=vote_average.desc&vote_count.gte=150",
                "https://api.themoviedb.org/3/discover/movie?api_key=01a844fdf284bf000e57f284487770ef&primary_release_year=2015&sort_by=vote_average.desc&vote_count.gte=150"
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
           NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
       if (networkInfo != null && networkInfo.isConnected()) {

        new DownloadTask().execute(mURls[2]);
        // gotta use DownloadTAsk here


        } else {
            Toast.makeText(MainActivity.this, "Get some Internet first!", Toast.LENGTH_LONG).show();// display error
        }



        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }




}