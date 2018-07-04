package com.example.rawanali.rawanfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Rawan Ali on 9/4/2017.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {


    private List<image> movies;
    private OnItemClickListener onItemClickListener;
    public MyRecyclerViewAdapter() {
    }



    public void setMovies(List<image> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
 View layoutHolderView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.recyclerview_item,
                parent,
                false);
        return new ViewHolder(layoutHolderView);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setContent(movies.get(position));
    }
    @Override
    public int getItemCount() {
        return movies != null ? movies.size() : 0;
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageUrl;
        LinearLayout mRootLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            mRootLayout = (LinearLayout) itemView.findViewById(R.id.item_movie);
            imageUrl = (ImageView) itemView.findViewById(R.id.img);
        }

        public void setContent(final image movies) {
            Picasso.with(imageUrl.getContext()).load(movies.getImageUrl()).into(imageUrl);

            mRootLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(movies);
                    }
                }
            });
        }

    }

    public interface OnItemClickListener {
        void onItemClick(image movie);
    }

}
