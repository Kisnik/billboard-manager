package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.manager.MovieManager;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryTest {
    private MovieRepository movieRepository = new MovieRepository();
    private MovieManager movieManager = new MovieManager(movieRepository);
    private Movie[] movies;

    //поиск по существующему id
    @Test
    void shouldFindById() {
        movies = new Movie[3];
        for (int i = 0; i < 3; i++) {
            movies[i] = new Movie();
            movies[i].setId(i);
        }

        for (int i = 0; i < 3; i++) {
            movieManager.add(movies[i]);
        }
        Movie actual = movieRepository.findById(1);
        Movie expected = movies[1];

        assertEquals(expected, actual);

    }

    //очистка репозитория
    @Test
    void shouldRemoveAll() {
        movies = new Movie[3];
        for (int i = 0; i < 3; i++) {
            movies[i] = new Movie();
        }

        for (int i = 0; i < 3; i++) {
            movieManager.add(movies[i]);
        }
        movieRepository.removeAll();
        Movie[] expected = new Movie[0];
        Movie[] actual = movieManager.getAll();

        assertArrayEquals(expected, actual);
    }

    //поиск по несуществующему id
    @Test
    void shouldFindByNotExistedId() {
        movies = new Movie[3];
        for (int i = 0; i < 3; i++) {
            movies[i] = new Movie();
            movies[i].setId(i);
        }

        for (int i = 0; i < 3; i++) {
            movieManager.add(movies[i]);
        }
        Movie actual = movieRepository.findById(5);
        Movie expected = null;

        assertEquals(expected, actual);

    }
}