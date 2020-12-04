package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    private MovieManager movieManager = new MovieManager();
    private Movie[] movies;

    //добавление фильма в ленту
    @Test
    public void shouldAdd() {
        movies = new Movie[3];
        for (int i = 0; i < 3; i++) {
            movies[i] = new Movie();
        }
        for (int i = 0; i < 3; i++) {
            movieManager.add(movies[i]);
        }
        Movie[] actual = movieManager.getAll();
        Movie[] expected = new Movie[]{movies[2], movies[1], movies[0]};

        assertArrayEquals(expected, actual);

    }

    //получить последние 10 фильмов, если их в ленте меньше 10
    @Test
    public void shouldGetLessTen() {
        movies = new Movie[3];
        for (int i = 0; i < 3; i++) {
            movies[i] = new Movie();
        }
        for (int i = 0; i < 3; i++) {
            movieManager.add(movies[i]);
        }
        Movie[] actual = movieManager.getMovies();
        Movie[] expected = new Movie[]{movies[2], movies[1], movies[0]};

        assertArrayEquals(expected, actual);

    }

    //получить последние 10 фильмов, если их в ленте больше 10
    @Test
    public void shouldGetIfMoreTen() {
        movies = new Movie[12];
        for (int i = 0; i < 12; i++) {
            movies[i] = new Movie();
        }
        for (int i = 0; i < 12; i++) {
            movieManager.add(movies[i]);
        }
        Movie[] actual = movieManager.getMovies();
        Movie[] expected = new Movie[10];
        for (int i = 0; i < 10; i++) {
            expected[i] = movies[11 - i];
        }
        assertArrayEquals(expected, actual);
    }

    //получить произвольное число фильмов, которое больше, чем фильмов в ленте
    @Test
    public void shouldGetMoreThanInBillboard() {
        movies = new Movie[3];
        for (int i = 0; i < 3; i++) {
            movies[i] = new Movie();
        }
        for (int i = 0; i < 3; i++) {
            movieManager.add(movies[i]);
        }
        Movie[] actual = movieManager.getMovies(5);
        Movie[] expected = new Movie[3];
        for (int i = 0; i < 3; i++) {
            expected[i] = movies[2 - i];
        }
        assertArrayEquals(expected, actual);
    }

    //получить произвольное число фильмов, которое меньше, чем фильмов в ленте
    @Test
    public void shouldGetLessThanInBillboard() {
        movies = new Movie[3];
        for (int i = 0; i < 3; i++) {
            movies[i] = new Movie();
        }
        for (int i = 0; i < 3; i++) {
            movieManager.add(movies[i]);
        }
        Movie[] actual = movieManager.getMovies(2);
        Movie[] expected = new Movie[2];
        for (int i = 0; i < 2; i++) {
            expected[i] = movies[2 - i];
        }
        assertArrayEquals(expected, actual);
    }

}