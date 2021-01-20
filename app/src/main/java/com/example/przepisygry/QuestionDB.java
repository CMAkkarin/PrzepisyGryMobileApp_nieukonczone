package com.example.przepisygry;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;


public class QuestionDB extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lo_question_db);

        Start.PrzepisyGry_db = this.openOrCreateDatabase("PrzepisyGry_db", MODE_PRIVATE, null);
        Start.PrzepisyGry_db.execSQL("CREATE TABLE IF NOT EXISTS QuestionTbl(ID INTEGER PRIMARY KEY AUTOINCREMENT, question TEXT NOT NULL, question_type TEXT NOT NULL, question_answer NOT NULL, other_answers) ");
        Start.PrzepisyGry_db.execSQL("INSERT INTO QuestionTbl (question, question_type, question_answer, other_answers) VALUES" +
                "('Pytanie 1','A', 'Gr','')," +
                "('Pytanie 2','B','Odpowiedz C','Odp A; Odp B; Odp D;')," +
                "('Pytanie 3','A','','')," +
                "('Pytanie 4','B','Odpowiedz D','Odp A; Odp B; Odp C;')," +
                "('Pytanie 5','A','','')");

        TextView txtV = (TextView) findViewById(R.id.questionDBTxt);
        String content;

        /*Cursor cB = Start.PrzepisyGry_db.rawQuery ("SELECT COUNT(ID) FROM QuestionTbl",null);
        cB.moveToFirst();
        int iloscWierszy = Integer.parseInt(cB.getString(0));*/
        //Wartość iloscWierszy przyjumje za duza wartosc; poki co ilosc wierszy ustawiana manualnie

            Cursor c = Start.PrzepisyGry_db.rawQuery ("SELECT ID, question FROM QuestionTbl",null);
            if (c.moveToFirst()){
                content = c.getString(0) + ". " + c.getString(1);
                for (int n = 1; n<5 /*iloscWierszy*/; n++){
                    c.moveToNext();
                    content += '\n';
                    content += '\n';
                    content += c.getString(0) + ". " + c.getString(1);
                }
            }
            else {content = "Brak wartości";}
            txtV.setText(content);
    }

}
