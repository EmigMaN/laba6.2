package com.example.laba6serega;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.laba6serega.databinding.ActivityMainBinding;
import com.yandex.mapkit.geometry.Point;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import model.Sight;
import model.User;

public class MainActivity extends AppCompatActivity {

    User user;

    List<Sight> sights = Arrays.asList(new Sight(
            new Point(55.749475, 37.629421),"Парящий мост", "Знаменитый мост-бумеранг был построен недавно, но уже успел стать одной из визитных карточек Москвы. Оригинальное архитектурное сооружение идеально вписалось в облик исторического центра города. За характерную форму москвичи любовно называют его «скрепкой».\n" +
                    "\n" +
                    "Бетонная консоль не имеет утилитарного значения, ведь она не соединяет берега реки, а «возвращается» обратно. Сооружение длиной почти 250 м и весом 3,7 тысячи тонн элегантно «парит» над водной гладью реки. Мост удерживает прочная опора из бетона и металла. Внутри установлен лифт и специальные датчики, которые следят за нагрузкой.\n" +
                    "\n" +
                    "Живописное место располагает к романтическим прогулкам, неспешному созерцанию и, как магнит, притягивает любителей красивых фото. Территория парка и мост открыты круглосуточно, поэтому туристы приходят сюда полюбоваться панорамой Кремля и набережными днем и вечером.",
                    "bridge1"),
            new Sight(new Point(55.752507, 37.623150),"Собор Покрова Пресвятой Богородицы на Рву", "Храм Васи́лия Блаже́нного, официально собо́р Покрова́ Пресвято́й Богоро́дицы, что на Рву (также Покро́вский собо́р, собо́р Покрова́ на Рву) — православный храм на Красной площади в Москве, памятник русской архитектуры. Построен в 1555—1561 годах",
                    "temple", "11:00 - 17:00"),
            new Sight(new Point(55.742770, 37.610162), "Патриарший мост", "пешеходный мост через Москву-реку. Соединяет территорию Храма Христа Спасителя и Пречистенскую, Берсеневскую и Якиманскую набережные. Открыт в 2004 году",
                    "bridge2"),
            new Sight(new Point(55.752004, 37.617734), "Кремль", "крепость в центре Москвы и древнейшая её часть, главный общественно-политический и историко-художественный комплекс города, официальная резиденция Президента Российской Федерации, вплоть до распада СССР в декабре 1991 года была официальной резиденцией Генерального секретаря ЦК КПСС (в 1990—1991 годах — Президента СССР). Одно из самых известных архитектурных сооружений в мире.\n" +
                    "\n" +
                    "Расположен на высоком левом берегу Москвы-реки — Боровицком холме, при впадении в неё реки Неглинной. В плане Кремль — неправильный треугольник площадью 27,5 гектара. Южная стена обращена к Москве-реке, северо-западная — к Александровскому саду, восточная — к Красной площади[2].",
                    "kremlin")
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = new User(getIntent().getStringExtra("user_log"),
                getIntent().getStringExtra("user_pass"),
                getIntent().getStringExtra("user_email"));

        ((TextView)findViewById(R.id.helloText)).setText("Привет, "+ user.getLogin()+"!");
        ListView listView = (ListView)findViewById(R.id.list);
        FillList(listView);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(getApplicationContext(), MapActivity.class);
            Sight s = (Sight) listView.getAdapter().getItem(position);
            intent.putExtra("sight_name", s.getName());
            intent.putExtra("sight_text", s.getDescription());
            intent.putExtra("sight_times", s.getDates());
            intent.putExtra("sight_x", s.getPoint().getLatitude());
            intent.putExtra("sight_y", s.getPoint().getLongitude());
            startActivity(intent);
        });

    }

    private void FillList(ListView listView)
    {
        ListAdapter adapter = new CustomAdapter(this, R.layout.list_layout, sights);
        listView.setAdapter(adapter);
    }

}