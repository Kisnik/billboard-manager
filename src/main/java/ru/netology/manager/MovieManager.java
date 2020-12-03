package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {
  private Movie[] movies = new Movie[0];


  public void add(Movie item) {
    // создаём новый массив размером на единицу больше
    int length = movies.length + 1;
    Movie[] tmp = new Movie[length];
    System.arraycopy(movies, 0, tmp, 0, movies.length);
    // кладём последним наш элемент
    int lastIndex = tmp.length - 1;
    tmp[lastIndex] = item;
    movies = tmp;

  }

  public Movie[] getAll() {
    Movie[] result = new Movie[movies.length];
    // перебираем массив в прямом порядке
    // но кладём в результаты в обратном
    for (int i = 0; i < result.length; i++) {
      int index = movies.length - i - 1;
      result[i] = movies[index];
    }
    return result;
  }

  public Movie[] getMovies() {
    int numToShow = Math.min(movies.length, 10);
    Movie[] result = new Movie[numToShow];
    // перебираем массив в прямом порядке
    // но кладём в результаты в обратном
    for (int i = 0; i < result.length; i++) {
      int index = numToShow - i - 1;
      result[i] = movies[index];
    }
    return result;
  }

  public Movie[] getMovies(int numOfMovies) {
    Movie[] result;
    //получить фильмов больше, чем есть в ленте
    if(numOfMovies > movies.length) {
      result = new Movie[movies.length];
      // перебираем массив в прямом порядке
      // но кладём в результаты в обратном
      for (int i = 0; i < result.length; i++) {
        int index = movies.length - i - 1;
        result[i] = movies[index];
      }
    }
    //получить фильмов меньше, чем есть в ленте
    else {
      result = new Movie[numOfMovies];
    // перебираем массив в прямом порядке
    // но кладём в результаты в обратном
    for (int i = 0; i < result.length; i++) {
      int index = numOfMovies - i - 1;
      result[i] = movies[index];
    }

    }
    return result;
  }
/*  // наивная реализация
  public void removeById(int id) {
    int length = items.length - 1;
    Movie[] tmp = new Movie[length];
    int index = 0;
    for (Movie item : items) {
      if (item.getId() != id) {
        tmp[index] = item;
        index++;
      }
    }
    // меняем наши элементы
    items = tmp;
  }*/
}
