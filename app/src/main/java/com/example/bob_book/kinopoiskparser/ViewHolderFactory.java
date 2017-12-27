package com.example.bob_book.kinopoiskparser;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by bob-book on 12/19/2017.
 */

public class ViewHolderFactory {

    public static class FilmTitleViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewTitleYear;

        public FilmTitleViewHolder(View itemView) {
            super(itemView);
            textViewTitleYear = (TextView) itemView.findViewById(R.id.textViewTitleYear);
        }
    }


    public static class FilmViewHolder extends RecyclerView.ViewHolder {
        public TextView nameRu;
        public TextView nameEng;
        public TextView ratio;
        public TextView url;
        public TextView year;
        public Context context;

        public FilmViewHolder(View itemView) {
            super(itemView);
            nameRu = (TextView) itemView.findViewById(R.id.nameRu);
            nameEng = (TextView) itemView.findViewById(R.id.nameEng);
            ratio = (TextView) itemView.findViewById(R.id.ratio);
            url = (TextView) itemView.findViewById(R.id.url);
            year = (TextView) itemView.findViewById(R.id.year);
            context = itemView.getContext();
        }


    }

    public static RecyclerView.ViewHolder create(ViewGroup parent, int viewType) {
        switch (viewType) {
            case RowType.TITLE_FILM_ROW:
                View filmTitleTypeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.title_year, parent, false);
                return new ViewHolderFactory.FilmTitleViewHolder(filmTitleTypeView);

            case RowType.FILM_ROW_TYPE:
                View filmTypeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
                return new ViewHolderFactory.FilmViewHolder(filmTypeView);
            default:
                return null;
        }
    }

}
