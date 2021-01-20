package com.example.przepisygry;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Laws extends Activity{

Button btn;
static String popwindow = "domyslnie";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lo_laws);

        Start.PrzepisyGry_db = this.openOrCreateDatabase ("PrzepisyGry_db", MODE_PRIVATE, null);
        Start.PrzepisyGry_db.execSQL("DROP TABLE IF EXISTS GrassLawsTbl");
        Start.PrzepisyGry_db.execSQL("DROP TABLE IF EXISTS IndoorLawsTbl");
        Start.PrzepisyGry_db.execSQL("DROP TABLE IF EXISTS BeachLawsTbl");
        Start.PrzepisyGry_db.execSQL("CREATE TABLE IF NOT EXISTS GrassLawsTbl(ID INTEGER PRIMARY KEY AUTOINCREMENT, article_name TEXT, article_content TEXT) ");
        Start.PrzepisyGry_db.execSQL("INSERT INTO GrassLawsTbl (article_name, article_content) VALUES('Wstęp','zawartosc'),('Art. 1 - Pole gry','\b\n1. Nawierzchnia pola gry\n" +
                "\n" +
                "\tPole gry musi być w całości naturalne lub, jeżeli regulamin rozgrywek na to zezwala, w całości sztuczne, z wyjątkiem przypadków, w których regulamin rozgrywek zezwala na połączenie nawierzchni sztucznej i naturalnych materiałów (system hybrydowy).\n" +
                "\n" +
                "\tSztuczna nawierzchnia pola gry musi być koloru zielonego.\n" +
                "\n" +
                "\tW przypadku meczów reprezentacji krajowych, rozgrywanych pod auspicjami FIFA, jak i meczów w ramach międzynarodowych rozgrywek klubowych, zastosowane nawierzchnie sztuczne muszą być zgodne z Wymogami Jakościowymi dla Nawierzchni Piłkarskich FIFA lub Międzynarodowymi Standardami – chyba że odstępstwa zostaną zaakceptowane przez IFAB.\n" +
                "\n \n \n" +
                "2. Oznaczenia pola gry\n" +
                "\n" +
                "\tPole gry musi mieć kształt prostokąta i być oznaczone ciągłymi liniami, które nie mogą stanowić zagrożenia. Linie te należą do powierzchni, których są granicami.\n" +
                "\n" +
                "\tTylko linie ujęte w Artykule 1 mogą zostać wytyczone na polu gry.\n" +
                "\t\n" +
                "\tDwie dłuższe linie ograniczające pole gry nazywane są liniami bocznymi.\n" +
                "\tDwie krótsze nazywane są liniami bramkowymi.\n" +
                "\t\n" +
                "\tPole gry jest podzielone na dwie połowy linią środkową, wyznaczoną w połowie długości dwóch linii bocznych.\n" +
                "\tPunkt środkowy pola gry wyznaczony jest w połowie linii środkowej.\n" +
                "\tZ punktu środkowego wyznacza się okrąg o promieniu 9,15 m (10 jardów).\n" +
                "\t\n" +
                "\tNa zewnątrz pola gry może być wykonane oznaczenie, pod kątem prostym do linii bramkowej oraz linii bocznej, w odległości 9,15 m (10 jardów) od pola rożnego.\n" +
                "\t\n" +
                "\tWszystkie linie muszą być tej samej szerokości, jednak nie większej niż 12 cm (5 cali). Linie bramkowe muszą być tej samej szerokości, co głębokość słupków bramkowych i poprzeczki.\n" +
                "\t\n" +
                "\tNa boiskach ze sztuczną nawierzchnią dopuszczalne są także inne linie, pod warunkiem, że są one w innym kolorze i dają się jednoznacznie odróżnić od linii wykorzystywanych do meczów piłki nożnej.\n" +
                "\t\n" +
                "\tZawodnik, który dokona niedozwolonych znaków na polu gry, musi zostać napomniany za niesportowe zachowanie. Jeżeli sędzia zauważy, że takie oznaczenia dokonywane są w czasie, gdy piłka jest w grze, musi napomnieć winnego zawodnika w najbliższej przerwie w grze.\n" +
                "\n \n \n" +
                "3. Wymiary pola gry\n" +
                "\n" +
                "\tDługość linii bocznej musi być większa niż długość linii bramkowej.\n" +
                "\n" +
                "\t-  Długość (linia boczna):\n" +
                "\tminimum 90 m (100 jardów)\n" +
                "\tmaksimum 120 m (130 jardów)\n" +
                "\t\n" +
                "\t-  Szerokość (linia bramkowa):\n" +
                "\tminimum 45 m (50 jardów)\n" +
                "\tmaksimum 90m (100 jardów)\n" +
                "\n \n \n" +
                "4. Wymiary pola gry – Zawody międzynarodowe\n" +
                "\t\n" +
                "\t-  Długość (linia boczna):\n" +
                "\tminimum 100 m (100 jardów)\n" +
                "\tmaksimum 110 m (120 jardów)\n" +
                "\t\n" +
                "\t-  Szerokość (linia bramkowa):\n" +
                "\tminimum 64 m (70 jardów)\n" +
                "\tmaksimum 75 m (80 jardów)\n" +
                "\t\n" +
                "\tOrganizator rozgrywek może określać długość linii bramkowych oraz bocznych w zakresie wymiarów, które podane są powyżej.\n" +
                "\n" +
                "\t<WYMIARY NANIESIONE NA PŁYTĘ BOISKA ZNAJDZIESZ NA KOŃCU>\n" +
                "\n \n \n" +
                "5. Pole bramkowe\n" +
                "\n" +
                "\tDwie linie wytycza się pod kątem prostym do linii bramkowej, w odległości 5,5 m (6 jardów) od wewnętrznej strony każdego słupka bramkowego. \n" +
                "\n" +
                "\tTe linie rozciągają się w głąb pola gry na odległość 5,5 m (6 jardów) i ich końce połączone są linią równoległą do linii bramkowej. Powierzchnia ograniczona tymi liniami i linią bramkową jest polem bramkowym.\n" +
                "\n \n \n" +
                "6. Pole karne\n" +
                "\n" +
                "\tDwie linie wytycza się pod kątem prostym do linii bramkowej, w odległości 16,5 m (18 jardów) od wewnętrznej strony każdego słupka bramkowego.\n" +
                "\n" +
                "\tTe linie rozciągają się w głąb pola gry na odległość 16,5 m (18 jardów) i ich końce połączone są linią równoległą do linii bramkowej. Powierzchnia ograniczona tymi liniami i linią bramkową jest polem karnym.\n" +
                "\n" +
                "\tWewnątrz każdego pola karnego wyznacza się punkt karny w odległości 11 m (12 jardów) od punktu środkowego, pomiędzy słupkami bramkowymi i w równej odległości od nich.\n" +
                "\n" +
                "\tŁuk koła o promieniu 9,15 m (10 jardów), którego środkiem jest punkt karny, wyznacza się na zewnątrz każdego pola karnego.\n" +
                "\n \n \n" +
                "7. Pole rożne\n" +
                "\n" +
                "\tZ punktu umieszczenia każdej chorągiewki rożnej wyznacza się na polu gry łuk koła o promieniu 1 m (1 jard)\n" +
                "\n \n \n" +
                "8. Chorągiewki\n" +
                "\n" +
                "\tChorągiewki nieostro zakończone i o wysokości nie mniejszej niż 1,5 m (5 stóp), muszą zostać umieszczone w każdym rogu pola gry. Chorągiewki mogą być także umieszczone na przedłużeniu linii środkowej (poza polem gry), po obu stronach pola gry, nie bliżej jednak niż 1 m od linii bocznej. " +
                "\n \n \n" +
                "9. Strefa techniczna\n" +
                "\t\n" +
                "\tStrefa techniczna odnosi się do zawodów rozgrywanych na stadionach z wyznaczonym obszarem miejsc siedzących dla osób funkcyjnych  i zawodników rezerwowych. • Linia strefy technicznej przebiega w odległości 1 m (1 jarda) z każdej strony obszaru miejsc siedzących oraz w kierunku pola gry maksymalnie na odległość 1 m (1 jarda) od linii bocznej.\n" +
                "\t- Zaleca się, aby strefa techniczna była oznaczona.\n" +
                "\t- Liczba osób uprawnionych do zajmowania miejsc w strefie technicznej jest określana przez regulaminy rozgrywek.•\n" +
                "\t- Osoby przebywające w strefie technicznej:\n" +
                "\t\t\t- zostają zidentyfikowane przed rozpoczęciem zawodów,  zgodnie z regulaminami rozgrywek,\n" +
                "\t\t\t- muszą zachowywać się odpowiedzialnie,  \n" +
                "\t\t\t- muszą pozostawać w granicach strefy technicznej, z wyjątkiem szczególnych okoliczności, np. wejścia za zgodą sędziego masażysty lub lekarza na pole gry, by ocenić rozmiary kontuzji zawodnika.•  Tylko jedna osoba w danej chwili jest upoważniona do przekazywania wskazówek taktycznych ze strefy technicznej.\n" +
                "\n \n \n" +
                "10. Bramki\n" +
                "\n" +
                "\tBramki muszą być umieszczone na środku każdej linii bramkowej. \n" +
                "\n" +
                "\tBramki składają się z dwóch pionowo ustawionych słupków w jednakowej odległości od chorągiewek rożnych i są połączone u góry poziomą poprzeczką. Słupki bramkowe i poprzeczki muszą być wykonane z dozwolonego materiału. Ich kształt musi być kwadratowy, prostokątny, okrągły lub eliptyczny i nie mogą one stanowić zagrożenia dla zawodników. \n" +
                "\n" +
                "\tOdległość pomiędzy wewnętrznymi krawędziami słupków bramkowych wynosi 7,32 m (8 jardów), a odległość od dolnej krawędzi poprzeczki  do podłoża wynosi 2,44 m (8 stóp). \n" +
                "\n" +
                "\tUstawienie słupków bramkowych w stosunku do linii bramkowej musi być zgodne ze szkicami. \n" +
                "\n" +
                "\tSłupki bramkowe i poprzeczka muszą być koloru białego. Słupki bramkowe i poprzeczka mają równą szerokość i równą głębokość, które nie mogą przekroczyć 12 cm (5 cali). \n" +
                "\n" +
                "\tJeżeli poprzeczka zostanie uszkodzona lub przemieści się, gra zostaje przerwana do czasu naprawienia poprzeczki lub jej zastąpienia (nową poprzeczką). Jeżeli naprawa nie jest możliwa, zawody należy zakończyć. Użycie liny lub innych elastycznych lub niebezpiecznych materiałów do zastąpienia poprzeczki jest niedozwolone. Przerwana gra zostaje wznowiona rzutem sędziowskim. \n" +
                "\n" +
                "\tSiatki bramkowe mogą być umocowane do bramek i podłoża poza bramką, zakładając, że są one odpowiednio podparte i nie przeszkadzają bramkarzowi. \n" +
                "\n" +
                "\tWzględy bezpieczeństwa \n" +
                "\tBramki (również bramki przenośne) muszą być pewnie przytwierdzone do podłoża." +
                "\n \n \n" +
                "11. System GLT (Goal Line Technology) \n" +
                "\n" +
                "\tSystem GLT może być użyty w celu weryfikacji, czy bramka została zdobyta, by wesprzeć decyzję sędziego. W razie użycia systemu GLT, dopuszcza się zastosowanie modyfikacji  na słupkach i poprzeczce. Modyfikacje te muszą być zgodne z wymogami zawartymi w Programie Jakości FIFA dla Systemów GLT oraz z Przepisami Gry. Używanie systemu GLT musi znaleźć się w odpowiednim regulaminie rozgrywek. \n" +
                "\n" +
                "\tZasady zastosowania systemu GLT\n" +
                "\tGLT można zastosować wyłącznie na linii bramkowej w celu oceny, czy została zdobyta bramka." +
                "\n" +
                "\tInformacja, czy bramka została zdobyta, musi być natychmiastowa i automatycznie potwierdzona w ciągu jednej sekundy przez system GLT tylko do wiadomości sędziów (na zegarek sędziego – przez wibrację oraz komunikat na ekranie). \n" +
                "\n" +
                "\tWymogi i specyfikacja dla systemu GLT \n" +
                "\tW przypadku zastosowania systemu GLT w rozgrywkach mistrzowskich organizator rozgrywek musi dopilnować, aby system uzyskał jeden  z następujących certyfikatów:\n" +
                "\t- FIFA Quality PRO \n" +
                "\t- FIFA Quality \n" +
                "\t- IMS - INTERNATIONAL MATCH STANDARD\n" +
                "\n" +
                "\tNiezależny instytut musi zweryfikować dokładność i funkcjonalność różnych technologii dostarczanych do systemów zgodnie z Wytycznymi Testowania.  W sytuacji, gdy technologia nie spełnia wymagań zgodnych z Wytycznymi Testowania, sędziemu nie wolno korzystać z systemu GLT, a informację  musi zgłosić do odpowiednich władz. \n" +
                "\t\n" +
                "\tW przypadku zastosowania systemu GLT, sędzia zobowiązany jest do sprawdzenia funkcjonalności systemu przed zawodami. Takie testy muszą być ujęte w Programie Jakości FIFA dla Systemu GLT – Wytyczne Testowania. \n" +
                "\n \n \n" +
                "12. Reklama\n" +
                "\n" +
                "\tŻaden rodzaj reklamy, stałej lub świetlnej, nie może być umieszczany na polu gry, siatkach bramkowych i powierzchniach ograniczonych siatkami bramkowymi, w obrębie strefy technicznej lub w odległości od 1 metra  (1 jarda) od linii ograniczającej pole gry. Zakaz obowiązuje od momentu,  gdy drużyny wchodzą na pole gry, aż do opuszczenia przez nie pola gry  na przerwę i od czasu, gdy powracają na pole gry, aż do zakończenia zawodów. Również żadnego rodzaju materiały reklamowe nie mogą być umieszczane  na bramkach, siatkach bramkowych, drzewcach chorągiewek i ich flagach. Żadne dodatkowe wyposażenie (kamery, mikrofony, itp.) nie może  być mocowane do wyposażenia pola gry. \n" +
                "\t\n" +
                "\tPionowe reklamy muszą być umieszczone co najmniej:\n" +
                "\t- w odległości 1 metra (1 jarda) od linii bocznych pola gry, \n" +
                "\t- w tej samej odległości od linii bramkowej jak głębokość siatki bramkowej, \n" +
                "\t- w odległości 1 metra (1 jarda) od siatki bramkowej. \n" +
                "\n \n \n" +
                "13. Logo i emblematy\n" +
                "\n" +
                "\tReprodukcja, zarówno stała jak i świetlna, przedstawiająca logo lub emblematy FIFA, federacji kontynentalnych, związków narodowych, organizatorów rozgrywek, klubów lub innych organizacji jest zabroniona podczas trwania gry: na polu gry, siatkach bramkowych i powierzchniach przez nie ograniczonych, na bramkach, drzewcach chorągiewek. Są dozwolone na flagach umocowanych na drzewcach'),('Art. 2 - Piłka','zawartosc art 2'),('Art. 3 - Zawodnicy','zawartosc art 3')");

        Start.PrzepisyGry_db.execSQL("CREATE TABLE IF NOT EXISTS IndoorLawsTbl(ID INTEGER PRIMARY KEY AUTOINCREMENT, article_name, article_content) ");
        Start.PrzepisyGry_db.execSQL("INSERT INTO IndoorLawsTbl (article_name, article_content) VALUES ('wstep','zawartosc wstępu halowej'),('Art. 1','zawartosc art 1 halowej')");

        Start.PrzepisyGry_db.execSQL("CREATE TABLE IF NOT EXISTS BeachLawsTbl(ID INTEGER PRIMARY KEY AUTOINCREMENT, article_name, article_content) ");
        Start.PrzepisyGry_db.execSQL("INSERT INTO BeachLawsTbl (article_name, article_content) VALUES('wstep','zawartosc wstępu plażowej'),('Art. 1','zawartosc art 1 plażowej')");

        populateListView();
    }

    private void populateListView() {
        final String[] article = {"Wstęp", "Art. 1 - Pole gry", "Art. 2 - Piłka", "Art. 3 - Zawodnicy", "Art. 4 - Ubiór zawodników", "Art. 5 - Sędzia",
                "Art. 6 - Pozostali sędziowie", "Art. 7 - Czas trwania zawodów", "Art. 8 - Rozpoczęcie i wznowienie gry", "Art. 9 - Piłka w grze i poza grą",
                "Art. 10 - Wyłanianie zwycięzcy", "Art. 11 - Spalony", "Art. 12 - Gra niedozwolona i niewłaściwe postępowanie", "Art. 13 - Rzuty wolne",
                "Art. 14 - Rzut karny", "Art. 15 - Wrzut", "Art. 16 - Rzut od bramki", "Art. 17 - Rzut rożny", "Postanowienia PZPN", "Przepisy w j. Angielskim"};

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.row, article);

    final ListView list = (ListView) findViewById(R.id.articleLst);
    list.setAdapter(adapter);

    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            setContentView(R.layout.lo_article);
            TextView txtV = (TextView) findViewById(R.id.txtArticle);
            Toast.makeText(Laws.this, "Wczytuję " + article[position], Toast.LENGTH_SHORT).show();

            String table_name;
            if (Start.typ_gry.contains("grass")){
                table_name = "GrassLawsTbl";
            }
            else if (Start.typ_gry.contains("beach")){
                table_name = "BeachLawsTbl";
            }
            else if (Start.typ_gry.contains("indoor")){
                table_name = "IndoorLawsTbl";
            }
            else table_name = "random";

            String nArt = article[position];
            String content;
            Cursor c = Start.PrzepisyGry_db.rawQuery("SELECT article_name, article_content FROM " + table_name + " WHERE article_name LIKE '" + nArt +"'",null);
            if (c.moveToFirst()){
                content = c.getString(0);
                content += c.getString(1);
                //if(txtArticle.contains("Art. 1")){
                //    popwindow = "wymiary_pola_gry";
                //}
            }
            else {content = "Brak wartości";}
            txtV.setText(content);

            btn = (Button) findViewById(R.id.wymiaryPolaGryBtn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Laws.this, Pop.class);
                    startActivity(intent);
                }
            });

        }
    });
    }
}
