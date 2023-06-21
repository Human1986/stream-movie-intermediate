package com.epam.rd.autotask.stream.intermediate;

import com.epam.rd.autotask.stream.intermediate.model.Genre;
import com.epam.rd.autotask.stream.intermediate.model.Movie;
import com.epam.rd.autotask.stream.intermediate.model.Person;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MovieQueries {

    public MovieQueries(List<Movie> movies) {
    }


    public boolean checkGenreOfAllMovies(Genre genre) {
        return false;
    }

    public boolean checkGenreOfAnyMovies(Genre genre) {
        return false;
    }

    public boolean checkMovieIsDirectedBy(Person person) {
        return false;

    }

    public int calculateTotalLength() {
        return 0;
    }

    public long moviesLongerThan(int minutes) {
        return 0;
    }

    public List<Person> listOfWriters() {
        return null;
    }

    public String[] movieTitlesWrittenBy(Person person) {
        return null;
    }

    public List<Integer> listOfLength() {
        return null;
    }

    public Movie longestMovie() {
        return null;
    }

    public Movie oldestMovie() {
        return null;
    }

    public List<Movie> sortedListOfMoviesBasedOnReleaseYear() {
        return null;
    }

    public List<Movie> sortedListOfMoviesBasedOnTheDateOfBirthOfOldestDirectorsOfMovies() {
        return null;
    }

    public List<Movie> moviesReleasedEarlierThan(int releaseYear) {
        return null;
    }
}
