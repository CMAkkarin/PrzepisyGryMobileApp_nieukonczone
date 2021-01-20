package com.example.przepisygry;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class Menu extends Activity {

    Button btn;
    VideoView videov;
    MediaController mediaC;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lo_menu);

        btn = (Button) findViewById(R.id.btnPlay);
        videov = (VideoView) findViewById(R.id.videoView);
        mediaC = new MediaController(this);
    }

    public void videoplay (View v){
        String videopath = "android.resource://com.example.adamszczuko.przepisygry/" + R.raw.filmpromocyjny;
        Uri uri = Uri.parse(videopath);
        videov.setVideoURI(uri);
        videov.setMediaController(mediaC);
        mediaC.setAnchorView(videov);
        videov.start();
    }

    public void action(View view) {
        int id = view.getId();
        String imgTxt;
        imgTxt = getResources().getResourceEntryName(id);
        if (imgTxt.contains("laws")) {
            btn = (Button) findViewById(R.id.lawsBtn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Menu.this, Laws.class);
                    startActivity(intent);
                }
            });
        } else if (imgTxt.contains("test")) {
            btn = (Button) findViewById(R.id.testBtn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Menu.this, "Dostępne wkrótce!", Toast.LENGTH_LONG).show();
                    //Intent intent = new Intent(Menu.this, Test.class);
                    //startActivity(intent);
                }
            });
        } else if (imgTxt.contains("database")) {
            btn = (Button) findViewById(R.id.databaseBtn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Menu.this, QuestionDB.class);
                    startActivity(intent);
                }
            });
        } else if (imgTxt.contains("clip")) {
            btn = (Button) findViewById(R.id.clipBtn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Menu.this, "Dostępne wkrótce!", Toast.LENGTH_LONG).show();
                    //Intent intent = new Intent(Menu.this, Clips.class);
                    //startActivity(intent)
                }
            });
        } else {
            Log.i("Blad", "Błąd");
        }

    }
}
