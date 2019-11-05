package com.wonokoyo.docin.menu.features;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
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
import android.widget.Toast;

import com.wonokoyo.docin.R;
import com.wonokoyo.docin.model.Doc;
import com.wonokoyo.docin.model.Voadip;

import java.io.File;

public class CameraResultFragment extends Fragment {

    private ImageView ivResult;
    private Button btnRetake;
    private Button btnNext;

    private String session;
    private String url;
    private Doc mDoc;
    private Voadip mVoadip;

    public CameraResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_camera_result, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        session = getArguments().getString("session");
        url = getArguments().getString("url");
        mDoc = (Doc) getArguments().getSerializable("doc");
        mVoadip = (Voadip) getArguments().getSerializable("voadip");

        final File file = new File(url);
        Bitmap bitmap = new BitmapDrawable(getContext().getResources(), file.getAbsolutePath()).getBitmap();

        ivResult = view.findViewById(R.id.ivResult);
        ivResult.setImageBitmap(bitmap);

        btnRetake = view.findViewById(R.id.btnRetake);
        btnRetake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (file.exists()) {
                    file.delete();

                    Intent mediaStoreUpdate = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                    mediaStoreUpdate.setData(Uri.fromFile(new File(file.getAbsolutePath())));
                    getActivity().sendBroadcast(mediaStoreUpdate);

                    NavHostFragment.findNavController(getParentFragment()).navigateUp();
                }
            }
        });

        btnNext = view.findViewById(R.id.btnNextToForm);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();

                if (session.equalsIgnoreCase("doc")) {
                    bundle.putString("session", session);
                    bundle.putString("url", url);
                    bundle.putSerializable("doc", mDoc);

                    NavHostFragment.findNavController(getParentFragment())
                            .navigate(R.id.action_result_camera_to_spj_form, bundle);
                } else {

                }
            }
        });
    }
}
