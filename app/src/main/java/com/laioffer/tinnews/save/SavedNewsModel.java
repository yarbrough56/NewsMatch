package com.laioffer.tinnews.save;

import android.annotation.SuppressLint;

import com.laioffer.tinnews.TinApplication;
import com.laioffer.tinnews.database.AppDatabase;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SavedNewsModel implements SavedNewsContract.Model {

    private SavedNewsContract.Presenter presenter;
    private final AppDatabase db;
    SavedNewsModel () {
        db = TinApplication.getDataBase();
    }

    @Override
    public void setPresenter(SavedNewsContract.Presenter presenter) {
        this.presenter = presenter;

    }

    @SuppressLint("CheckResult")
    @Override
    public void fetchData() {
        //取消监听操作 的时候要附给一个变量
        // DIsposable disposable = db.news
        db.newsDao().getAll().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(newsList -> {
                    presenter.loadSavedNews(newsList);
                }, error -> {
                    System.out.println("error");
                }, () -> {
                    System.out.println("complete");
                });
    }

}
