package com.example.przepisygry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;


public class Test extends Activity {
    Button btnS, btnH;
    private int nrPytania;
    static String popwindow = "test_help";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lo_start_test);
    }

    public void actions(){
        btnS = (Button) findViewById(R.id.btnStartTest);
        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.lo_test_abc);
            }
        });
        btnH = (Button) findViewById(R.id.testHelpBtn);
        btnH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Test.this, Pop.class);
                startActivity(intent);
            }
        });
    }

}
