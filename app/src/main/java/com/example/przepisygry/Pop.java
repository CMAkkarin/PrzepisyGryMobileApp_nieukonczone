package com.example.przepisygry;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.widget.ImageView;


public class Pop extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //if (Laws.popwindow.contains("wymiary_pola_gry")){
            setContentView(R.layout.pw_wymiary_pola_gry);
            ImageView imgView = (ImageView) findViewById(R.id.poleGryView);
            imgView.setImageResource(R.drawable.wymiary_pola_gry);
        /*}
        else if (Laws.popwindow.contains("test_help")){
            setContentView(R.layout.pw_test_help);
        }
        else {
            setContentView(R.layout.pw_error);
        }*/

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.9));

}
}