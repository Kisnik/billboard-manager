package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    private MovieRepository movieRepository = new MovieRepository();
    private MovieManager movieManager = new MovieManager(movieRepository);
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

    @Test
    public void shouldRemoveById() {
        movies = new Movie[3];
        for (int i = 0; i < 3; i++) {
            movies[i] = new Movie();
            movies[i].setId(i);
        }
        Movie[] expected = new Movie[]{movies[2], movies[0]};
        for (int i = 0; i < 3; i++) {
            movieManager.add(movies[i]);
        }
        movieManager.removeById(1);
        Movie[] actual = movieManager.getAll();

        assertArrayEquals(expected, actual);


    }

}