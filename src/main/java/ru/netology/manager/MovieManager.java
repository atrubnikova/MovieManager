package ru.netology.manager;

import ru.netology.domain.MovieItem;


public class MovieManager {

    private MovieItem[] items = new MovieItem[0];
    private int movieCounter = 10;

    public MovieManager() {
    }

    public MovieManager(int movieCounter) {
        this.movieCounter = movieCounter;
    }

    public void add(MovieItem item) {
        int length = items.length + 1;
        MovieItem[] tmp = new MovieItem[length];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public MovieItem[] getAll() {
        MovieItem[] result = new MovieItem[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public MovieItem[] getLastTen() {
        int resultLength;
        MovieItem[] movie = new MovieItem[items.length];
        if (movie.length > movieCounter) {
            resultLength = movieCounter;
        } else {
            resultLength = movie.length;
        }
        MovieItem[] result = new MovieItem[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}

