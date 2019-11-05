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
import android.widget.EditText;
import android.widget.ImageView;

import com.wonokoyo.docin.R;
import com.wonokoyo.docin.model.Doc;

import java.io.File;

public class DocSpjFormFragment extends Fragment {

    private Button btnNext;
    private ImageView ivSjDoc;
    private EditText etNoSjDoc;
    private EditText etJenisDoc;
    private EditText etJumlahBox;
    private EditText etMatiEkor;
    private EditText etEkorTerima;
    private EditText etBbRata;
    private EditText etKeteranganDoc;

    private String session;
    private String url;
    private Doc mDoc;

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
        session = getArguments().getString("session");
        url = getArguments().getString("url");
        mDoc = (Doc) getArguments().getSerializable("doc");

        File file = new File(url);
        Bitmap bitmap = new BitmapDrawable(getContext().getResources(), file.getAbsolutePath()).getBitmap();

        ivSjDoc = view.findViewById(R.id.ivSjDoc);
        ivSjDoc.setImageBitmap(bitmap);

        etNoSjDoc = view.findViewById(R.id.etNoSjDoc);
        etJenisDoc = view.findViewById(R.id.etJenisDoc);
        etJumlahBox = view.findViewById(R.id.etJumlahBox);
        etMatiEkor = view.findViewById(R.id.etMatiEkor);
        etEkorTerima = view.findViewById(R.id.etEkorTerima);
        etBbRata = view.findViewById(R.id.etBbRata);
        etKeteranganDoc = view.findViewById(R.id.etKeteranganDoc);

        btnNext = view.findViewById(R.id.btnNextToFinger);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDoc.setNoSj(etNoSjDoc.getText().toString());
                mDoc.setJenis(etJenisDoc.getText().toString());
                mDoc.setJumlahBox(Integer.valueOf(etJumlahBox.getText().toString()));
                mDoc.setMati(Integer.valueOf(etMatiEkor.getText().toString()));
                mDoc.setEkorTerima(Integer.valueOf(etEkorTerima.getText().toString()));
                mDoc.setBbRata(Double.valueOf(etBbRata.getText().toString()));
                mDoc.setKeterangan(etKeteranganDoc.getText().toString());
                mDoc.setUrl(url);

                Bundle bundle = new Bundle();
                bundle.putString("session", session);
                bundle.putSerializable("doc", mDoc);

                NavHostFragment.findNavController(getParentFragment())
                        .navigate(R.id.action_spj_form_to_verify_finger, bundle);
            }
        });
    }
}
