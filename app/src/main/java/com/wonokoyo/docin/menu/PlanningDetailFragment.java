package com.wonokoyo.docin.menu;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wonokoyo.docin.R;
import com.wonokoyo.docin.adapter.PlanningVoadipAdapter;
import com.wonokoyo.docin.model.Doc;
import com.wonokoyo.docin.model.Voadip;

import java.util.ArrayList;

public class PlanningDetailFragment extends Fragment {

    private TextView tvShowDetailDoc;
    private TextView tvShowDetailVoadip;
    private LinearLayout llChildDetail;
    private RecyclerView rvDetailVoadip;

    // variable detail
    private TextView tvNoOpDoc;
    private TextView tvTglDoc;
    private TextView tvMitraDoc;
    private TextView tvNoregDoc;
    private TextView tvKandangDoc;
    private TextView tvAlamatDoc;
    private TextView tvPopulasiDoc;
    private TextView tvJumlahBoxDoc;

    boolean showDoc = true;
    boolean showVoadip = true;

    Doc mDoc;

    PlanningVoadipAdapter voadipAdapter;

    public PlanningDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (getArguments() != null) {
            mDoc = PlanningDetailFragmentArgs.fromBundle(getArguments()).getDetailDoc();
            mDoc.setVoadips(new ArrayList<Voadip>());
        }

        return inflater.inflate(R.layout.fragment_planning_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        voadipAdapter = new PlanningVoadipAdapter(getContext(), getActivity());

        llChildDetail = view.findViewById(R.id.llChildDetail);
        rvDetailVoadip = view.findViewById(R.id.rvVoadip);
        rvDetailVoadip.setAdapter(voadipAdapter);

        voadipAdapter.syncDetailPlanning(mDoc.getVoadips());

        tvNoOpDoc = view.findViewById(R.id.tvNoOpDoc);
        tvTglDoc = view.findViewById(R.id.tvTglDoc);
        tvMitraDoc = view.findViewById(R.id.tvMitraDoc);
        tvNoregDoc = view.findViewById(R.id.tvNoregDoc);
        tvKandangDoc = view.findViewById(R.id.tvKandangDoc);
        tvAlamatDoc = view.findViewById(R.id.tvAlamatDoc);
        tvPopulasiDoc = view.findViewById(R.id.tvPopulasiDoc);
        tvJumlahBoxDoc = view.findViewById(R.id.tvJumlahBox);

        setupDetailDoc(mDoc);

        tvShowDetailDoc = view.findViewById(R.id.tvShowDetailDoc);
        tvShowDetailDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (showDoc) {
                    showDoc = false;
                    llChildDetail.setVisibility(View.VISIBLE);
                    tvShowDetailDoc.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,
                            R.drawable.ic_arrow_drop_up,0);
                } else {
                    showDoc = true;
                    llChildDetail.setVisibility(View.GONE);
                    tvShowDetailDoc.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,
                            R.drawable.ic_arrow_drop_down,0);
                }
            }
        });

        tvShowDetailVoadip = view.findViewById(R.id.tvShowDetailVoadip);
        tvShowDetailVoadip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (showVoadip) {
                    showVoadip = false;
                    rvDetailVoadip.setVisibility(View.VISIBLE);
                    tvShowDetailVoadip.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,
                            R.drawable.ic_arrow_drop_up,0);
                } else {
                    showVoadip = true;
                    rvDetailVoadip.setVisibility(View.GONE);
                    tvShowDetailVoadip.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,
                            R.drawable.ic_arrow_drop_down,0);
                }
            }
        });
    }

    public void setupDetailDoc(Doc doc) {
        tvNoOpDoc.setText(doc.getNoOpDoc());
        tvTglDoc.setText(doc.getTanggalDoc());
        tvMitraDoc.setText(doc.getMitra());
        tvNoregDoc.setText(doc.getNoreg());
        tvKandangDoc.setText(String.valueOf(doc.getKandang()));
        tvAlamatDoc.setText(doc.getAlamat());
        tvPopulasiDoc.setText(String.format("%,d", doc.getPopulasi()));
        tvJumlahBoxDoc.setText(String.valueOf(doc.getJumlahBox()));
    }
}
