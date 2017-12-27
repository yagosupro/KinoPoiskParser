package com.example.bob_book.kinopoiskparser;

import android.support.v7.widget.RecyclerView;

/**
 * Created by bob-book on 12/19/2017.
 */

public interface RowType {
    int FILM_ROW_TYPE=0;
    int TITLE_FILM_ROW=1;

    int getItemViewType();

    void onBindViewHolder(RecyclerView.ViewHolder viewHolder);
}
