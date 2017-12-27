package com.example.bob_book.kinopoiskparser;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by bob-book on 12/5/2017.
 */

public class Film implements RowType {

    String nameRu;
    String nameEng;
    String ratio;
    String year;
    String description;
    String img;
    String url;




    public View.OnClickListener getOnClickListener(final Context context) {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println(nameEng);
                Intent i = new Intent(context, InfoActivity.class);
                i.putExtra("url", url);
                i.putExtra("year", year);
                context.startActivity(i);
            }


        };
    }


    public String getUrl() {
        return url;
    }

    public void setSrc(String url) {
        this.url = url;
    }


    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public String getNameEng() {
        return nameEng;
    }

    public void setNameEng(String nameEng) {
        this.nameEng = nameEng;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


    Film(String nameRu, String nameEng, String ratio, String url, String year) {
        this.nameRu = nameRu;
        this.nameEng = nameEng;
        this.ratio = ratio;
        this.url = url;
        this.year = year;
    }


    @Override
    public int getItemViewType() {
        return RowType.FILM_ROW_TYPE;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder) {
        ViewHolderFactory.FilmViewHolder filmViewHolder = (ViewHolderFactory.FilmViewHolder) viewHolder;
        filmViewHolder.nameRu.setText(nameRu);
        filmViewHolder.nameEng.setText(nameEng);
        filmViewHolder.ratio.setText(ratio);
        filmViewHolder.url.setText(url);
        filmViewHolder.year.setText(year);

        Context context = filmViewHolder.itemView.getContext();
        filmViewHolder.itemView.setOnClickListener(getOnClickListener(context));


    }
}
