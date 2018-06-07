package com.akashdeep.tvshowguide.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.akashdeep.tvshowguide.Activities.MainActivity;
import com.akashdeep.tvshowguide.Activities.ShowDetailActivity;
import com.akashdeep.tvshowguide.Models.Show;
import com.akashdeep.tvshowguide.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Akash on 17-03-2018.
 */

public class ShowRecyclerViewAdapter extends RecyclerView.Adapter<ShowRecyclerViewAdapter.ViewHolder> {

    List<Show> shows;
    Context context;

    private Context getContext() {
        return context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_show, parent, false);
        return new ViewHolder(view);
    }

    public ShowRecyclerViewAdapter(Context context, List<Show> shows) {
        this.shows = shows;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Show show = shows.get(position);
        holder.tvTitle.setText(show.getTitle());
        holder.tvOverview.setText(show.getOverview());
        holder.tvUserScore.setText(show.getUserScore());
        Picasso.with(getContext())
                .load(show.getPosterPath())
                .into(holder.ivShowImage);
    }

    @Override
    public int getItemCount() {
        return shows.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.ivShowImage)
        ImageView ivShowImage;
        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.tvUserScore)
        TextView tvUserScore;
        @BindView(R.id.ivUserScore)
        ImageView ivUserScore;
        @BindView(R.id.cvShows)
        CardView cvShows;
        @BindView(R.id.tvOverview)
        TextView tvOverview;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Show show = shows.get(getAdapterPosition());

            Intent intent = new Intent(getContext() , ShowDetailActivity.class);
            intent.putExtra("SHOW",show);
            getContext().startActivity(intent);
        }
    }
}
