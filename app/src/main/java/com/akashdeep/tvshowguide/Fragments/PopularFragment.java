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
public class PopularFragment extends Fragment {

    List<Show> shows;
    @BindView(R.id.rvShows)
    RecyclerView rvShows;
    Unbinder unbinder;

    public PopularFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Popular");
        View view = inflater.inflate(R.layout.fragment_popular, container, false);
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
        shows.add(new Show("1399", "Game of Thrones", "2011", "81", "67", "7", true, "/67o6EdiVBjx4l2qG88dk51VH7Du.jpg", "/4kTINu9mv2YV1PqFqPGG1FZMnhi.jpg", "Sci-Fi & Fantasy | Drama | Action & Adventure", "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond."));
        shows.add(new Show("1688", "Friends", "1994", "78", "243", "10", false, "/s4M7cBkacJFw02YWdk3yqVoJYri.jpg", "/sCx2r2bw49OqxnjWaU9DsPwdR0C.jpg", "Comedy", "Friends is an American sitcom revolving around a group of friends in the New York City borough of Manhattan. Episodes typically depict the friends' comedic and romantic adventures and career issues, such as Joey auditioning for roles or Rachel seeking jobs in the fashion industry. The six characters each have many dates and serious relationships, such as Monica with Richard Burke and Ross with Emily Waltham. Other frequently recurring characters include Ross and Monica's parents in Long Island, Ross's ex-wife and their son, Central Perk barista Gunther, Chandler's ex-girlfriend Janice, and Phoebe's twin sister Ursula."));
        shows.add(new Show("1418", "The Big Bang Theory", "2007", "68", "248", "11", true, "/601ZMSOeyE6athApsONyzi2u0XI.jpg", "/ngoiHQul4QetfA62SdmZZOdDFAP.jpg", "Comedy", "The Big Bang Theory is centered on five characters living in Pasadena, California: roommates Leonard Hofstadter and Sheldon Cooper; Penny, a waitress and aspiring actress who lives across the hall; and Leonard and Sheldon's equally geeky and socially awkward friends and co-workers, mechanical engineer Howard Wolowitz and astrophysicist Raj Koothrappali. The geekiness and intellect of the four guys is contrasted for comic effect with Penny's social skills and common sense."));
        shows.add(new Show("1402", "The Walking Dead", "2010", "74", "110", "8", true, "/wVYtM75OHG4Fufe9qsNadxyE1um.jpg", "/kF6S8ARwwtbnl3ccWnIxm1wOwUg.jpg", "Action & Adventure | Drama | Sci-Fi & Fantasy", "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way."));
        shows.add(new Show("60735", "The Flash", "2014", "67", "94", "4", true, "/lUFK7ElGCk9kVEryDJHICeNdmd1.jpg", "/megezPWQIaYOFRT8iW4VDzzqTm9.jpg", "Drama | Sci-Fi & Fantasy", "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash."));
        shows.add(new Show("456", "The Simpsons", "1989", "72", "691", "29", true, "/yTZQkSsxUFJZJe67IenRM0AEklc.jpg", "/f5uNbUC76oowt5mt5J9QlqrIYQ6.jpg", "Animation | Comedy", "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general."));
        shows.add(new Show("1622", "Supernatural", "2005", "72", "284", "13", true, "/pui1V389cQft0BVFu9pbsYLEW1Q.jpg", "/koMUCyGWNtH5LXYbGqjsUwvgtsT.jpg", "Drama | Mystery | Sci-Fi & Fantasy", "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way."));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
