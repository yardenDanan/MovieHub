package com.YardenAvihai.moviehub.listing;

import com.YardenAvihai.moviehub.Movie;

import java.util.List;

/**
 * @author arun
 */
interface MoviesListingView
{
    void showMovies(List<Movie> movies);
    void loadingStarted();
    void loadingFailed(String errorMessage);
    void onMovieClicked(Movie movie);
}
