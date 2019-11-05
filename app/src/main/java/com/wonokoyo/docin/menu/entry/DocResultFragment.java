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
import android.widget.TextView;

import com.wonokoyo.docin.R;
import com.wonokoyo.docin.model.Doc;

import java.io.File;

public class DocResultFragment extends Fragment {

    private TextView tvResultMitra;
    private TextView tvResultNoreg;
    private TextView tvResultNoSj;
    private TextView tvResultNopol;
    private TextView tvResultSopir;
    private TextView tvResultKedatangan;
    private TextView tvResultPenerimaan;
    private TextView tvResultJenisDoc;
    private TextView tvResultJumlahBox;
    private TextView tvResultMati;
    private TextView tvResultTerima;
    private TextView tvResultBbRata;
    private TextView tvResultKeterangan;
    private ImageView ivShowSign;
    private Button btnDone;

    private Doc mDoc;

    public DocResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doc_result, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mDoc = (Doc) getArguments().getSerializable("doc");

        tvResultMitra = view.findViewById(R.id.tvResultMitra);
        tvResultMitra.setText(mDoc.getMitra());
        tvResultNoreg = view.findViewById(R.id.tvResultNoreg);
        tvResultNoreg.setText(mDoc.getNoreg());
        tvResultNoSj = view.findViewById(R.id.tvResultNoSj);
        tvResultNoSj.setText(mDoc.getNoSj());
        tvResultNopol = view.findViewById(R.id.tvResultNopol);
        tvResultNopol.setText(mDoc.getNopol());
        tvResultSopir = view.findViewById(R.id.tvResultSopir);
        tvResultSopir.setText(mDoc.getSopir());
        tvResultKedatangan = view.findViewById(R.id.tvResultKedatangan);
        tvResultKedatangan.setText(mDoc.getKedatangan());
        tvResultPenerimaan = view.findViewById(R.id.tvResultPenerimaan);
        tvResultPenerimaan.setText(mDoc.getKedatangan());
        tvResultJenisDoc = view.findViewById(R.id.tvResultJenisDoc);
        tvResultJenisDoc.setText(mDoc.getJenis());
        tvResultJumlahBox = view.findViewById(R.id.tvResultJumlahBox);
        tvResultJumlahBox.setText(String.valueOf(mDoc.getJumlahBox()));
        tvResultMati = view.findViewById(R.id.tvResultMati);
        tvResultMati.setText(String.valueOf(mDoc.getMati()));
        tvResultTerima = view.findViewById(R.id.tvResultJumlahTerima);
        tvResultTerima.setText(String.valueOf(mDoc.getEkorTerima()));
        tvResultBbRata = view.findViewById(R.id.tvResultBB);
        tvResultBbRata.setText(String.valueOf(mDoc.getBbRata()));
        tvResultKeterangan = view.findViewById(R.id.tvResultKeterangan);
        tvResultKeterangan.setText(mDoc.getKeterangan());

        File file = new File(mDoc.getUrlSign());
        Bitmap bitmap = new BitmapDrawable(getContext().getResources(), file.getAbsolutePath()).getBitmap();

        ivShowSign = view.findViewById(R.id.ivShowSign);
        ivShowSign.setImageBitmap(bitmap);

        btnDone = view.findViewById(R.id.btnDone);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(getParentFragment()).navigate(R.id.action_doc_result_to_nav_bap_doc);
            }
        });
    }
}
