package com.wonokoyo.docin.menu.entry;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.wonokoyo.docin.R;

public class VoadipSjFormFragment extends Fragment {
    private ImageView ivSjVoadip;
    private RecyclerView rvItemForm;

    public VoadipSjFormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_voadip_sj_form, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ivSjVoadip = view.findViewById(R.id.ivSjVoadip);

        rvItemForm = view.findViewById(R.id.rvFormVoadip);
    }
}
