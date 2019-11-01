package com.wonokoyo.docin.menu.entry;


import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.wonokoyo.docin.R;

import java.io.File;

public class DocSpjFormFragment extends Fragment {

    private Button btnNext;
    private ImageView ivSjDoc;

    public DocSpjFormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doc_sj_form, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final String url = getArguments().getString("url");
        final String session = getArguments().getString("session");

        File file = new File(url);
        Bitmap bitmap = new BitmapDrawable(getContext().getResources(), file.getAbsolutePath()).getBitmap();

        ivSjDoc = view.findViewById(R.id.ivSjDoc);
        ivSjDoc.setImageBitmap(bitmap);

        btnNext = view.findViewById(R.id.btnNextToFinger);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("session", session);
                bundle.putString("url_sj", url);

                NavHostFragment.findNavController(getParentFragment())
                        .navigate(R.id.action_spj_form_to_verify_finger, bundle);
            }
        });
    }
}
