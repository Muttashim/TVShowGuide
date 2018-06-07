package com.akashdeep.tvshowguide.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.akashdeep.tvshowguide.Models.Show;
import com.akashdeep.tvshowguide.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowDetailActivity extends AppCompatActivity {

    @BindView(R.id.ivShowBackdrop)
    ImageView ivShowBackdrop;
    @BindView(R.id.tvGenre)
    TextView tvGenre;
    @BindView(R.id.tvUserScore)
    TextView tvUserScore;
    @BindView(R.id.tvProductionStatus)
    TextView tvProductionStatus;
    @BindView(R.id.tvEpisodes)
    TextView tvEpisodes;
    @BindView(R.id.tvSeasons)
    TextView tvSeasons;
    @BindView(R.id.tvOverview)
    TextView tvOverview;
    @BindView(R.id.tvInitialRelease)
    TextView tvInitialRelease;
    @BindView(R.id.fabb)
    FloatingActionButton fabb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Show show = null;

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            show = (Show) bundle.getSerializable("SHOW");

            this.setTitle(show.getTitleOnly());

            tvInitialRelease.setText(String.format("Initial Release : %s", show.getYear()));
            tvGenre.setText(String.format("Genre : %s", show.getGenre()));
            tvEpisodes.setText(String.format("Number of episodes : %s", show.getNoOfEpisodes()));
            tvOverview.setText(show.getOverview());
            tvSeasons.setText(String.format("Number of seasons : %s", show.getNoOfSeasons()));
            tvUserScore.setText(String.format("User Score : %s", show.getUserScore()));
            if (show.isProduction())
                tvProductionStatus.setText("Production Status : Ongoing");
            else
                tvProductionStatus.setText("Production Status : Completed");

            Picasso.with(this)
                    .load(show.getBackdropPath())
                    .into(ivShowBackdrop);

        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabb);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Show Saved As Favourite", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                listener();
            }
        });
    }

    private void listener() {
        fabb.setImageResource(R.drawable.ic_user_score);
    }
}
