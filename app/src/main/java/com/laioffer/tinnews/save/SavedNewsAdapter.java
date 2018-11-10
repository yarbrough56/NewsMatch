package com.laioffer.tinnews.save;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.laioffer.tinnews.R;
import com.laioffer.tinnews.TinFragmentPagerAdapter;
import com.laioffer.tinnews.common.TinFragmentManager;
import com.laioffer.tinnews.retrofit.response.News;

import java.util.List;

public class SavedNewsAdapter extends RecyclerView.Adapter<SavedNewsAdapter.SavedNewsViewHolder> {
    private List<News> newsList;

    private TinFragmentManager tinFragmentManager;

    private static int[] ICON_ARRAY = new int[]{R.drawable.a_news_icon, R.drawable.g_news_icon,
            R.drawable.c_news_icon, R.drawable.y_news_icon, R.drawable.m_news_icon};

    @Override
    public SavedNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(SavedNewsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public static class SavedNewsViewHolder extends  RecyclerView.ViewHolder {
        TextView author;
        TextView description;
        ImageView icon;
        // view only a fragment view
        public SavedNewsViewHolder(View itemView) {
            super(itemView);
            author = itemView.findViewById(R.id.image);

        }
    }
}
