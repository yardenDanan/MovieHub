package com.YardenAvihai.moviehub.listing.sorting;

/**
 * @author arun
 */
class SortingDialogInteractorImpl implements SortingDialogInteractor
{
    private SortingOptionStore sortingOptionStore;

    SortingDialogInteractorImpl(SortingOptionStore store)
    {
        sortingOptionStore = store;
    }

    @Override
    public int getSelectedSortingOption()
    {
        return sortingOptionStore.getSelectedOption();
    }

    @Override
    public void setSortingOption(SortType sortType)
    {
        sortingOptionStore.setSelectedOption(sortType);
    }
}
