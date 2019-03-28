package com.ramanic.swipenavfrag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * Ramanic Code !!!
 */


public class MiscFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //just change the fragment_misc
        //with the fragment you want to inflate
        //like if the class is HomeFragment it should have R.layout.home_fragment
        //if it is MiscFragment it should have R.layout.fragment_misc
        return inflater.inflate(R.layout.fragment_misc, null);
    }
}
