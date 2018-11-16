package com.YardenAvihai.moviehub.details;

import com.YardenAvihai.moviehub.Movie;
import com.YardenAvihai.moviehub.Review;
import com.YardenAvihai.moviehub.Video;

import java.util.List;

/**
 * @author arun
 */
interface MovieDetailsView
{
    void showDetails(Movie movie);
    void showTrailers(List<Video> trailers);
    void showReviews(List<Review> reviews);
    void showFavorited();
    void showUnFavorited();
}
