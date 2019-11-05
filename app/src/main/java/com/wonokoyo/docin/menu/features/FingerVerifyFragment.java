package com.wonokoyo.docin.menu.features;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wonokoyo.docin.R;
import com.wonokoyo.docin.model.Doc;
import com.wonokoyo.docin.model.Voadip;

public class FingerVerifyFragment extends Fragment {

    private String session;
    private Doc mDoc = null;
    private Voadip mVoadip = null;

    public FingerVerifyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doc_finger_verivy, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        session = getArguments().getString("session");
        if (session.equalsIgnoreCase("doc"))
            mDoc = (Doc) getArguments().getSerializable("doc");
        else
            mVoadip = (Voadip) getArguments().getSerializable("voadip");

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Bundle bundle = new Bundle();
                bundle.putString("session", session);
                bundle.putSerializable("doc", mDoc);
                bundle.putSerializable("voadip", mVoadip);

                NavHostFragment.findNavController(getParentFragment())
                        .navigate(R.id.action_verify_finger_to_signature, bundle);
            }
        }, 2000);
    }
}
