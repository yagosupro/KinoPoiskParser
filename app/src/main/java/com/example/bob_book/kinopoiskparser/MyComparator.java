package com.example.bob_book.kinopoiskparser;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Comparator;

/**
 * Created by bob-book on 12/13/2017.
 */

public class MyComparator implements Comparator<Film> {
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int compare(Film o1, Film o2) {
        return Integer.compare(Integer.parseInt(o1.getYear()),Integer.parseInt(o2.getYear()));

    }

}
