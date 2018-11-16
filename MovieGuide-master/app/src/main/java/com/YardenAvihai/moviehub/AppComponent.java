package com.YardenAvihai.moviehub;

import com.YardenAvihai.moviehub.details.DetailsComponent;
import com.YardenAvihai.moviehub.details.DetailsModule;
import com.YardenAvihai.moviehub.favorites.FavoritesModule;
import com.YardenAvihai.moviehub.listing.ListingComponent;
import com.YardenAvihai.moviehub.listing.ListingModule;
import com.YardenAvihai.moviehub.network.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author arunsasidharan
 * @author pulkitkumar
 */
@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        FavoritesModule.class})
public interface AppComponent
{
    DetailsComponent plus(DetailsModule detailsModule);

    ListingComponent plus(ListingModule listingModule);
}
