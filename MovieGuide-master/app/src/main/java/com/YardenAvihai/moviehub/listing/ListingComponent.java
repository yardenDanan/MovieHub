package com.YardenAvihai.moviehub.listing;

import com.YardenAvihai.moviehub.listing.sorting.SortingDialogFragment;
import com.YardenAvihai.moviehub.listing.sorting.SortingModule;

import dagger.Subcomponent;

/**
 * @author arunsasidharan
 */
@ListingScope
@Subcomponent(modules = {ListingModule.class, SortingModule.class})
public interface ListingComponent
{
    MoviesListingFragment inject(MoviesListingFragment fragment);

    SortingDialogFragment inject(SortingDialogFragment fragment);
}
