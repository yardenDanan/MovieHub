package com.YardenAvihai.moviehub.details;

import com.YardenAvihai.moviehub.Review;
import com.YardenAvihai.moviehub.ReviewsWrapper;
import com.YardenAvihai.moviehub.Video;
import com.YardenAvihai.moviehub.VideoWrapper;
import com.YardenAvihai.moviehub.network.TmdbWebService;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author arun
 */
class MovieDetailsInteractorImpl implements MovieDetailsInteractor {

    private TmdbWebService tmdbWebService;

    MovieDetailsInteractorImpl(TmdbWebService tmdbWebService) {
        this.tmdbWebService = tmdbWebService;
    }

    @Override
    public Observable<List<Video>> getTrailers(final String id) {
        return tmdbWebService.trailers(id).map(VideoWrapper::getVideos);
    }

    @Override
    public Observable<List<Review>> getReviews(final String id) {
        return tmdbWebService.reviews(id).map(ReviewsWrapper::getReviews);
    }

}
