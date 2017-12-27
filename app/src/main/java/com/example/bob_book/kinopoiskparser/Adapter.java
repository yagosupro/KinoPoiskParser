package com.example.bob_book.kinopoiskparser;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.example.bob_book.kinopoiskparser.R.id.url;
import static com.example.bob_book.kinopoiskparser.R.id.year;

/**
 * Created by bob-book on 12/6/2017.
 */

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<RowType> films = new ArrayList<>();



    @Override
    public int getItemViewType(int position) {


        return films.get(position).getItemViewType();
    }

    Adapter(List<Film> films) {

          Collections.sort(films, new MyComparator());

      int temp = 0;
        for (int i = 0; i < films.size(); i++) {
            if (Integer.parseInt(films.get(i).getYear()) == temp) {
                this.films.add(films.get(i));

            } else {
                temp = Integer.parseInt(films.get(i).getYear());

                this.films.add(new FilmTitle(films.get(i).getYear()));
                this.films.add(films.get(i));
                System.out.println();
            }
        }
    }


    //Создает новый элемент
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return ViewHolderFactory.create(parent, viewType);

    }

    //наполняет элемент
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        films.get(position).onBindViewHolder(holder);


    }

    @Override
    public int getItemCount() {
        return films.size();
    }
}

