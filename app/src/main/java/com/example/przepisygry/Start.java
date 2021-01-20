package com.example.przepisygry;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Start extends AppCompatActivity {

    ImageButton imgBtn;
    static String typ_gry;
    static SQLiteDatabase PrzepisyGry_db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lo_start);
    }

    public void openLaws(View view){
        int id = view.getId();
            String imgTxt;
            imgTxt = getResources().getResourceEntryName(id);
            if (imgTxt.contains("grass")) {
                typ_gry = "grass";
            } else if (imgTxt.contains("indoor")) {
                typ_gry = "indoor";
            } else if (imgTxt.contains("beach")) {
                typ_gry = "beach";
            }
        imgBtn = (ImageButton) findViewById(id);
        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Start.this, Menu.class);
                startActivity(intent);
            }
        });
    }
}
