package com.laioffer.tinnews.save;

import com.laioffer.tinnews.retrofit.response.News;

import java.util.List;

public class SavedNewsPresenter implements SavedNewsContract.Presenter {
    // have to have initialize
    private final SavedNewsContract.Model model;
    private SavedNewsContract.View view;

    public SavedNewsPresenter() {
        model = new SavedNewsModel();
        model.setPresenter(this);
        // model and presenter has no life cycle
    }
    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onViewAttached(SavedNewsContract.View view) {
        this.view = view;
        this.model.fetchData();
    }

    @Override
    public void onViewDetached() {
        this.view = null;
    }

    //3.5
    @Override
    public void loadSavedNews(List<News> newsList) {
        if (view != null) {
            view.loadSavedNews(newsList);
        }
    }

}
