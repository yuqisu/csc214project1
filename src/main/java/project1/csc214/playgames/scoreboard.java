package project1.csc214.playgames;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class scoreboard extends Fragment {


    public interface MessageChangeListener {
        public void messageChanged(CharSequence message);
        public void messageCanceled();
    }

    private   MessageChangeListener messageChangeListener;

    public scoreboard() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.activity_scoreboard,container,false);
        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        messageChangeListener = (MessageChangeListener)context;

        if (context instanceof Activity){
            messageChangeListener= (MessageChangeListener) context;
        }
    }

}
