package com.wonokoyo.docin.menu.entry;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wonokoyo.docin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VoadipInformationFragment extends Fragment {


    public VoadipInformationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_voadip_information, container, false);
    }

}
