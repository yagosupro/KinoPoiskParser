package com.example.bob_book.kinopoiskparser;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by bob-book on 12/19/2017.
 */

public class FilmTitle implements RowType {

    String textViewTitleYear;

    public String getTextViewTitleYear() {
        return textViewTitleYear;
    }

    public void setTextViewTitleYear(String textViewTitleYear) {
        this.textViewTitleYear = textViewTitleYear;
    }



    public FilmTitle(String textViewTitleYear) {
        this.textViewTitleYear = textViewTitleYear;
    }

    @Override
    public int getItemViewType() {
        return RowType.TITLE_FILM_ROW;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder) {
        ViewHolderFactory.FilmTitleViewHolder filmTitleViewHolder= (ViewHolderFactory.FilmTitleViewHolder) viewHolder;
        filmTitleViewHolder.textViewTitleYear.setText(textViewTitleYear);
    }
}
