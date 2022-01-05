package ru.netology.manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;
import ru.netology.manager.MovieManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
class MovieManagerTestNonEmpty {

    MovieManager manager = new MovieManager();
    private MovieItem first = new MovieItem(1, 1, "Namefirst", "1", 1);
    private MovieItem second = new MovieItem(2, 2, "Namesecond", "2", 1);
    private MovieItem third = new MovieItem(3, 3, "Namethird", "3", 1);
    private MovieItem fourth = new MovieItem(4, 4, "Name4", "1", 1);
    private MovieItem fifth = new MovieItem(5, 5, "Name5", "2", 1);
    private MovieItem sixth = new MovieItem(6, 6, "Name6", "3", 1);
    private MovieItem seventh = new MovieItem(7, 7, "Names7", "1", 1);
    private MovieItem eighth = new MovieItem(8, 8, "Name8", "2", 1);
    private MovieItem ninth = new MovieItem(9, 9, "Name9", "3", 1);
    private MovieItem tenth = new MovieItem(10, 10, "Name10", "3", 1);

//    @BeforeEach
    //   public void setUp() {
    //           }

    @Test
    public void shouldWorkGetLastTen() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

        MovieItem[] actual = manager.getLastTen();
        MovieItem[] expected = new MovieItem[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetUnderLimit() {
        manager.add(first);
        manager.add(second);
        manager.add(third);

        MovieItem[] actual = manager.getLastTen();
        MovieItem[] expected = new MovieItem[]{third, second, first};
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldGetEmpty() {
        MovieItem[] actual = manager.getLastTen();
        MovieItem[] expeсted = new MovieItem[0];
        assertArrayEquals(expeсted, actual);
    }


    @Test
    public void shouldMoviesAboveLimit() {
        MovieManager manager = new MovieManager(11);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

        MovieItem[] actual = manager.getLastTen();
        MovieItem[] expeсted = new MovieItem[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expeсted, actual);

    }
    @Test
    public void shouldMoviesBelowLimit() {
        MovieManager manager = new MovieManager(9);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

        MovieItem[] actual = manager.getLastTen();
        MovieItem[] expeсted = new MovieItem[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expeсted, actual);

    }
}
