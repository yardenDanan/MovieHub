package com.YardenAvihai.moviehub.details;

import com.YardenAvihai.moviehub.Review;
import com.YardenAvihai.moviehub.Video;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author arun
 */
public interface MovieDetailsInteractor
{
    Observable<List<Video>> getTrailers(String id);
    Observable<List<Review>> getReviews(String id);
}
