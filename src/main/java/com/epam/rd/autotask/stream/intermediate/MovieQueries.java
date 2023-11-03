package com.epam.rd.autotask.stream.intermediate;

import com.epam.rd.autotask.stream.intermediate.model.Genre;
import com.epam.rd.autotask.stream.intermediate.model.Movie;
import com.epam.rd.autotask.stream.intermediate.model.Person;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MovieQueries {
    List<Movie> movies;

    public MovieQueries(List<Movie> movies) {
        if (movies == null) throw new IllegalArgumentException();
        this.movies = movies;
    }


    public boolean checkGenreOfAllMovies(Genre genre) {
        return movies.stream()
                .allMatch(movie -> movie.getGenres().contains(genre));

    }

    public boolean checkGenreOfAnyMovies(Genre genre) {
        return movies.stream()
                .anyMatch(movie -> movie.getGenres().contains(genre));
    }

    public boolean checkMovieIsDirectedBy(Person person) {
        return movies.stream()
                .flatMap(movie -> movie.getDirectors().stream())
                .anyMatch(d -> d.equals(person));

    }

    public int calculateTotalLength() {
        return movies.stream()
                .mapToInt(Movie::getLength)
                .reduce(0, Integer::sum);
    }

    public long moviesLongerThan(int minutes) {
        return movies.stream()
                .filter(movie -> movie.getLength() > minutes)
                .count();
    }

    public List<Person> listOfWriters() {
        return movies.stream()
                .flatMap(movie -> movie.getWriters().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public String[] movieTitlesWrittenBy(Person person) {
        Object[] array = movies.stream()
                .filter(movie -> movie.getWriters().stream()
                        .anyMatch(writer -> writer.getName().equals(person.getName())))
                .map(Movie::getTitle)
                .toArray();
        return (String[]) array;
    }

    public List<Integer> listOfLength() {
        return movies.stream()
                .map(Movie::getLength)
                .collect(Collectors.toList());
    }

    public Movie longestMovie() {
        if (movies.isEmpty()) throw new IllegalArgumentException();

        var sorted = movies.stream()
                .sorted(Comparator.comparing(Movie::getLength).reversed())
                .collect(Collectors.toList());
        return sorted.get(0);

    }

    public Movie oldestMovie() {
        if (movies.isEmpty()) throw new IllegalArgumentException();
        var sorted = movies.stream()
                .sorted(Comparator.comparing(Movie::getReleaseYear))
                .collect(Collectors.toList());
        return sorted.get(0);
    }

    public List<Movie> sortedListOfMoviesBasedOnReleaseYear() {
        return movies.stream()
                .sorted(Comparator.comparing(Movie::getReleaseYear))
                .collect(Collectors.toList());
    }

    public List<Movie> sortedListOfMoviesBasedOnTheDateOfBirthOfOldestDirectorsOfMovies() {
        return movies.stream()
                .sorted(Comparator.comparing(movie -> movie.getDirectors().stream()
                        .map(Person::getDateOfBirth)
                        .min(Comparator.naturalOrder())
                        .orElse(null)))
                .collect(Collectors.toList());
    }

    public List<Movie> moviesReleasedEarlierThan(int releaseYear) {
        return movies.stream()
                .filter(movie -> movie.getReleaseYear() <= releaseYear)
                .collect(Collectors.toList());
    }
}
