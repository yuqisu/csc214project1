package project1.csc214.playgames;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Scoreboard extends Fragment {
    private static final String KEY_SCORE1 = "score1";
    private static final String KEY_SCORE2 = "score2";
    public static int score1;
    public static int score2;


    public Scoreboard() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.fragment_scoreboard,container,false);
        final TextView playerName1 = (TextView)view.findViewById(R.id.playername1);
        final TextView playerName2 = (TextView)view.findViewById(R.id.playername2);

        String name1 =NameInput.scoreboard.getArguments().getString(NameInput.KEY_PLAYER1NAME);
        playerName1.setText(name1);
        String name2 =NameInput.scoreboard.getArguments().getString(NameInput. KEY_PLAYER2NAME);
        playerName2.setText(name2);
        return view;
    }



}
