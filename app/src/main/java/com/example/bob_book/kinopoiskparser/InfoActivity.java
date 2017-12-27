package com.example.bob_book.kinopoiskparser;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class InfoActivity extends AppCompatActivity implements View.OnClickListener {
    String url = "url";
    TextView titleNameRu;
    TextView nameEng;
    TextView ratio;
    TextView year;
    TextView discription;
    TextView raiting;
    ImageView imageTitle;

    String imageTitleUrl;
    String titleNameRuTmp;
    String nameEngTmp;
    String ratioTmp;
    String yearTmp = "year";
    String discriptionTmp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        url = getIntent().getExtras().getString("url");
        yearTmp = getIntent().getExtras().getString("year");


        titleNameRu = (TextView) findViewById(R.id.titleNameRu);
        nameEng = (TextView) findViewById(R.id.infoNameEng);
        ratio = (TextView) findViewById(R.id.infoRatio);
        year = (TextView) findViewById(R.id.infoYear);
        discription = (TextView) findViewById(R.id.infoDiscription);
        imageTitle = (ImageView) findViewById(R.id.imageTitle);
        raiting= (TextView) findViewById(R.id.raiting);
        new NewThread1().execute();
    }

    @Override
    public void onClick(View v) {
    }

    private class NewThread1 extends AsyncTask<String, Void, String>

    {
        @Override
        protected String doInBackground(String... params) {
            Document doc;

            Elements elNameRu;
            Elements elNameEng;
            Elements elRatio;
            Elements elYear;
            Elements elDiscription;
            Elements elImageTitleUrl;

            try {
                //определеляем откуда будем парсить
                doc = Jsoup.connect(url)
                        .userAgent("Mozilla")
                        .get();


                elNameRu = doc.select("#headerFilm h1.moviename-big");
                elNameEng = doc.select("#headerFilm span");
                elRatio = doc.select("#block_rating div div a span.rating_ball");
                elDiscription = doc.select("#syn tbody tr td table tbody tr td span div.brand_words.film-synopsys");

                //Work version
//              elImageTitleUrl=doc.select("img[src$=.jpg]");
//              imageTitleUrl=elImageTitleUrl.first().attr("src");

                elImageTitleUrl = doc.select("img[src$=.jpg]");
                imageTitleUrl = elImageTitleUrl.first().attr("src");

                titleNameRuTmp = elNameRu.text();
                nameEngTmp = elNameEng.text();
                ratioTmp = elRatio.text();

                discriptionTmp = elDiscription.text();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {


            Picasso.with(InfoActivity.this)
                    .load(imageTitleUrl)
                    .into(imageTitle, new com.squareup.picasso.Callback() {
                        @Override
                        public void onSuccess() {
                            titleNameRu.setText(titleNameRuTmp);
                            nameEng.setText(nameEngTmp);
                            ratio.setText(ratioTmp);
                            year.setText("Год: " + yearTmp);
                            discription.setText(discriptionTmp);
                            raiting.setText("Рейтинг: ");
                            // successfully
                        }

                        @Override
                        public void onError() {
                            // error
                        }
                    });
        }
    }
}
