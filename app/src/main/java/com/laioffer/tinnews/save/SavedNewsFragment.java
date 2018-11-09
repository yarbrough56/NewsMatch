package com.laioffer.tinnews.save;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laioffer.tinnews.R;
import com.laioffer.tinnews.common.TinBasicFragment;
import com.laioffer.tinnews.mvp.MvpFragment;
import com.laioffer.tinnews.retrofit.response.News;
import com.laioffer.tinnews.save.detail.SavedNewsDetailedFragment;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
//1.7
public class SavedNewsFragment extends MvpFragment<SavedNewsContract.Presenter> implements SavedNewsContract.View {

    //4.3
    private TextView author;
    private TextView description;

    public static SavedNewsFragment newInstance() {
        SavedNewsFragment fragment = new SavedNewsFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_saved_news, container, false);

        //4.3
        author = view.findViewById(R.id.author);
        description = view.findViewById(R.id.description);
        description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinFragmentManager.doFragmentTransaction(SavedNewsDetailedFragment.newInstance());
            }
        });


        return view;
    }

    //1.8
    @Override
    public SavedNewsContract.Presenter getPresenter() {
        return new SavedNewsPresenter();
    }

    //3.6
    @Override
    public void loadSavedNews(List<News> newsList) {
        if (newsList.size() > 0) {
            News news = newsList.get(newsList.size() - 1);
            author.setText(news.getAuthor());
            description.setText(news.getDescription());
        }
    }
}
