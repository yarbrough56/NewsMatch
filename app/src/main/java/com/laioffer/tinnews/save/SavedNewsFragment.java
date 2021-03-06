package com.laioffer.tinnews.save;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laioffer.tinnews.R;
import com.laioffer.tinnews.common.TinBasicFragment;
import com.laioffer.tinnews.common.ViewModelAdapter;
import com.laioffer.tinnews.mvp.MvpFragment;
import com.laioffer.tinnews.retrofit.response.News;
import com.laioffer.tinnews.save.detail.SavedNewsDetailedFragment;

import java.util.LinkedList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
//1.7
public class SavedNewsFragment extends MvpFragment<SavedNewsContract.Presenter> implements SavedNewsContract.View {

    //4.3
    private TextView author;
    private TextView description;

    private ViewModelAdapter savedNewsAdapter;
    private TextView emptyState;


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
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        savedNewsAdapter = new ViewModelAdapter();
        recyclerView.setAdapter(savedNewsAdapter);
        emptyState = view.findViewById(R.id.empty_state);
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
        if (newsList.size() == 0) {
            emptyState.setVisibility(View.VISIBLE);
        } else {
            emptyState.setVisibility(View.GONE);
        }
        if (newsList.size() != 0) {
            List<SavedNewsViewModel> models = new LinkedList<>();
            for (News news : newsList) {
                models.add(new SavedNewsViewModel(news,tinFragmentManager));
            }
            savedNewsAdapter.addViewModels(models);
        }


    }
}
