package com.akashdeep.tvshowguide.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akashdeep.tvshowguide.Adapters.ShowRecyclerViewAdapter;
import com.akashdeep.tvshowguide.Models.Show;
import com.akashdeep.tvshowguide.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopRatedFragment extends Fragment {

    List<Show> shows;
    @BindView(R.id.rvShows)
    RecyclerView rvShows;
    Unbinder unbinder;


    public TopRatedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Top Rated");
        View view = inflater.inflate(R.layout.fragment_top_rated, container, false);
        unbinder = ButterKnife.bind(this, view);
        initializeData();
        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        rvShows.setHasFixedSize(true);
        rvShows.setLayoutManager(llm);

        ShowRecyclerViewAdapter adapter = new ShowRecyclerViewAdapter(this.getContext(),shows);
        rvShows.setAdapter(adapter);
        return view;
    }

    private void initializeData() {
        shows = new ArrayList<>();
        shows.add(new Show("60625","Rick and Morty","2013","85","31","3",true,"/qJdfO3ahgAMf2rcmhoqngjBBZW1.jpg","/mzzHr6g1yvZ05Mc7hNj3tUdy2bM.jpg","Sci-Fi & Fantasy | Action & Adventure | Animation","Rick is a mentally-unbalanced but scientifically-gifted old man who has recently reconnected with his family. He spends most of his time involving his young grandson Morty in dangerous, outlandish adventures throughout space and alternate universes. Compounded with Morty's already unstable family life, these events cause Morty much distress at home and school."));
        shows.add(new Show("16946","Life","2009","85","10","1",false,"/ll8NF10NRBRVLmrIQg4LyeA2s3P.jpg","/6LZZSu5OZtYiUqe1toPUKuTVX3r.jpg","Documentary","David Attenborough looks at the extraordinary ends to which animals and plants go in order to survive. Featuring epic spectacles, amazing TV firsts and examples of new wildlife behaviour."));
        shows.add(new Show("66732","Stranger Things","2016","84","24","2",true,"/lXS60geme1LlEob5Wgvj3KilClA.jpg","/56v2KjBlU4XaOv9rVYEQypROD7P.jpg","Drama | Mystery | Sci-Fi & Fantasy","When a young boy vanishes, a small town uncovers a mystery involving secret experiments, terrifying supernatural forces, and one strange little girl."));
        shows.add(new Show("1396","Breaking Bad","2008","83","62","5",false,"/1yeVJox3rjo2jBKrrihIMj7uoS9.jpg","/5sHew9rjOsALuDVxwu0pJexOXWA.jpg","Drama","Breaking Bad is an American crime drama television series created and produced by Vince Gilligan. Set and produced in Albuquerque, New Mexico, Breaking Bad is the story of Walter White, a struggling high school chemistry teacher who is diagnosed with inoperable lung cancer at the beginning of the series. He turns to a life of crime, producing and selling methamphetamine, in order to secure his family's financial future before he dies, teaming with his former student, Jesse Pinkman. Heavily serialized, the series is known for positioning its characters in seemingly inextricable corners and has been labeled a contemporary western by its creator."));
        shows.add(new Show("19885","Sherlock","2010","83","12","4",true,"/f9zGxLHGyQB10cMDZNY5ZcGKhZi.jpg","/bvS50jBZXtglmLu72EAt5KgJBrL.jpg","Crime | Drama | Mystery","A modern update finds the famous sleuth and his doctor partner solving crime in 21st century London."));
        shows.add(new Show("8724","Frozen Planet","2011","83","7","1",false,"/sFAssIrNY2ileQPeUf99Dna3yzN.jpg","/syVmo7m2DPYqRoJpnlpbBQ9EXBv.jpg","Documentary","David Attenborough travels to the end of the earth, taking viewers on an extraordinary journey across the polar regions of our planet."));
        shows.add(new Show("13916","Death Note","2006","82","37","1",false,"/vfo9GzhCX7x5VEfkCkYIepbKvY.jpg","/cILHCR7USDcczTLNC3Ef5L54EIA.jpg","Animation | Mystery","Light Yagami is an ace student with great prospects—and he’s bored out of his mind. But all that changes when he finds the Death Note, a notebook dropped by a rogue Shinigami death god. Any human whose name is written in the notebook dies, and Light has vowed to use the power of the Death Note to rid the world of evil. But will Light succeed in his noble goal, or will the Death Note turn him into the very thing he fights against?"));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
