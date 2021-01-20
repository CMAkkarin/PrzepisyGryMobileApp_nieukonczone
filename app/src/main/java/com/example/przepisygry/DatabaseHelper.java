package com.example.przepisygry;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;


/*public class DatabaseHelper extends SQLiteOpenHelper{

    public DatabaseHelper(Context context) {
        super(context, "PrzepisyGry_db", null, 1);
    }
    static String content;

    @Override
    public void onCreate(SQLiteDatabase PrzepisyGry_db) {
        PrzepisyGry_db = this.getWritableDatabase();
        PrzepisyGry_db.execSQL("CREATE TABLE IF NOT EXISTS GrassLawsTbl(ID INTEGER PRIMARY KEY AUTOINCREMENT, article_name TEXT, article_content TEXT) ");
        PrzepisyGry_db.execSQL("INSERT INTO GrassLawsTbl (article_name, article_content) VALUES('wstep','zawartosc'),('Art. 1','zawartosc art 1')");

        PrzepisyGry_db.execSQL("CREATE TABLE IndoorLawsTbl (ID INTEGER PRIMARY KEY AUTOINCREMENT, article_name, article_content) ");
        PrzepisyGry_db.execSQL("INSERT INTO IndoorLawsTbl (article_name, article_content) VALUES ('wstep','zawartosc wsępu halowej'),('Art. 1','zawartosc art 1 halowej')");

        PrzepisyGry_db.execSQL("CREATE TABLE BeachLawsTbl (ID INTEGER PRIMARY KEY AUTOINCREMENT, article_name, article_content) ");
        PrzepisyGry_db.execSQL("INSERT INTO BeachLawsTbl (article_name, article_content) VALUES('wstep','zawartosc wstępu plażowej'),('Art. 1','zawartosc art 1 plażowej')");
    }



    @Override
    public void onUpgrade(SQLiteDatabase PrzepisyGry_db, int oldVersion, int newVersion) {
        PrzepisyGry_db.execSQL("DROP TABLE IF EXISTS GrassLawsTbl");
        PrzepisyGry_db.execSQL("DROP TABLE IF EXISTS BeachLawsTbl");
        PrzepisyGry_db.execSQL("DROP TABLE IF EXISTS IndoorLawsTbl");
        onCreate(PrzepisyGry_db);
    }

    public String pobierzdane (int x) {
        String table_name = "";
        if (x == 1){
            if (Start.typ_gry.contains("grass")){
                table_name = "GrassLawsTbl";
            }
            else if (Start.typ_gry.contains("beach")){
                table_name = "BeachLawsTbl";
            }
            else if (Start.typ_gry.contains("indoor")){
                table_name = "IndoorLawsTbl";
            }
        }
        else if (x == 2){
            table_name = "QuestionTbl";
        }

        SQLiteDatabase PrzepisyGry_db = this.getReadableDatabase();
        Cursor kursor;

        if (table_name.contains("QuestionTbl")){
            kursor = PrzepisyGry_db.rawQuery("SELECT ID, question FROM " + table_name,null);
            int qID = kursor.getColumnIndex("ID");
            int qCont = kursor.getColumnIndex("question");
            kursor.moveToFirst();
            content = kursor.getString(Integer.parseInt(qID + ", " + qCont));
        }
        else {
            kursor = PrzepisyGry_db.rawQuery("SELECT * FROM " + table_name,null);
            int artCont = kursor.getColumnIndex("article_content");
            kursor.moveToFirst();
            content = kursor.getString(artCont);
        }
        return content;
    }

    public void createQuestionDB(){
        Start.PrzepisyGry_db = openOrCreateDatabase ("PrzepisyGry_db", null);
        Start.PrzepisyGry_db.execSQL("CREATE TABLE IF NOT EXISTS QuestionTbl(ID INTEGER PRIMARY KEY AUTOINCREMENT, question TEXT NOT NULL, question_type TEXT NOT NULL, question_answer NOT NULL, other_answers) ");
        Start.PrzepisyGry_db.execSQL("INSERT INTO QuestionTbl (question, question_type, question_answer) VALUES" +
                "('Pytanie 1','A', 'Gr')," +
                "('Pytanie 2','B','Odpowiedz C','Odp A; Odp B; Odp D;')," +
                "('Pytanie 3','A','')," +
                "('Pytanie 4','B','Odpowiedz D','Odp A; Odp B; Odp C;')," +
                "('Pytanie 5','A','')");
    }




}*/
