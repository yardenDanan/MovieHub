package com.YardenAvihai.moviehub;

import android.app.Application;
import android.os.StrictMode;

import com.YardenAvihai.moviehub.details.DetailsComponent;
import com.YardenAvihai.moviehub.details.DetailsModule;
import com.YardenAvihai.moviehub.favorites.FavoritesModule;
import com.YardenAvihai.moviehub.listing.ListingComponent;
import com.YardenAvihai.moviehub.listing.ListingModule;
import com.YardenAvihai.moviehub.network.NetworkModule;

import io.realm.Realm;

/**
 * @author arun
 */
public class BaseApplication extends Application
{
    private AppComponent appComponent;
    private DetailsComponent detailsComponent;
    private ListingComponent listingComponent;

    @Override
    public void onCreate()
    {
        super.onCreate();
        StrictMode.enableDefaults();
        initRealm();
        appComponent = createAppComponent();
    }

    private AppComponent createAppComponent()
    {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .favoritesModule(new FavoritesModule())
                .build();
    }

    private void initRealm(){
        Realm.init(this);
    }

    public DetailsComponent createDetailsComponent()
    {
        detailsComponent = appComponent.plus(new DetailsModule());
        return detailsComponent;
    }

    public void releaseDetailsComponent()
    {
        detailsComponent = null;
    }

    public ListingComponent createListingComponent()
    {
        listingComponent = appComponent.plus(new ListingModule());
        return listingComponent;
    }

    public void releaseListingComponent()
    {
        listingComponent = null;
    }

    public ListingComponent getListingComponent()
    {
        return listingComponent;
    }
}
