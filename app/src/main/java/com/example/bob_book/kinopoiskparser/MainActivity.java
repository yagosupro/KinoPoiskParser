package com.example.bob_book.kinopoiskparser;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Film> films = new ArrayList<>();
    private RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        rv = (RecyclerView) findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        new NewThread().execute();
        initializeData();
    }

    private void initializeData() {
    }

    private class NewThread extends AsyncTask<String, Void, String>

    {
        @Override
        protected String doInBackground(String... params) {
            Document doc;
            Elements nameRu;
            Elements nameEng;
            Elements ratio;
            Elements src;
            String year;

            String nameRuSub;
            int place = 1;
            int temp;
            try {
                //определеляем откуда будем парсить
                doc = Jsoup.connect("https://www.kinopoisk.ru/top/").get();

                for (; place <= 5; place++) {
                    nameRu = doc.select("#top250_place_" + place + " td a.all");
                    nameEng = doc.select("#top250_place_" + place + " td span.text-grey");
                    ratio = doc.select("#top250_place_" + place + " td div a.continue");
                    src = doc.select("#top250_place_" + place + " td a.href");

                    temp = nameRu.text().length();
                    year = nameRu.text().substring(temp - 5, temp - 1);
                    nameRuSub = nameRu.text().substring(0, temp - 6);

                    films.add(new Film(nameRuSub, nameEng.text(), ratio.text(), "https://www.kinopoisk.ru" + nameRu.attr("href"), year));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            // после запроса обновляем листвью
            initializeAdapter();
        }
    }

    private void initializeAdapter() {
        Adapter adapter = new Adapter(films);
        rv.setAdapter(adapter);
    }
}
