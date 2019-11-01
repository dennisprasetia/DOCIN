package com.wonokoyo.docin.menu;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.wonokoyo.docin.R;
import com.wonokoyo.docin.adapter.PlanningAdapter;
import com.wonokoyo.docin.adapter.PlanningVoadipAdapter;
import com.wonokoyo.docin.model.Doc;
import com.wonokoyo.docin.model.ItemVoadip;
import com.wonokoyo.docin.model.Voadip;

import java.util.ArrayList;

public class PlanningFragment extends Fragment {
    private RecyclerView rvPlanning;
    private Button btnSync;

    ArrayList<Doc> docs;

    PlanningAdapter adapter;

    public PlanningFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        docs = new ArrayList<>();
        ArrayList<Voadip> voadips;
        ArrayList<ItemVoadip> itemVoadips;

        for (int i = 0; i < 3; i++) {
            Doc doc = new Doc();
            doc.setMitra("Dennis " + i);
            doc.setNoreg("11001102" + i);
            doc.setAlamat("Wonokoyo Jaya");
            doc.setKandang(i + 1);
            doc.setPopulasi(20000);
            doc.setTanggalDoc((i + 1) + " November 2019");
            doc.setJumlahBox(200);
            doc.setNoOpDoc(i + "5566/2019");

            voadips = new ArrayList<>();

            for (int j = 1; j <= 3; j++) {
                Voadip voadip = new Voadip();
                voadip.setDoc(doc);
                voadip.setSupplier("PT Sumber " + i + " Supplier " + j);
                voadip.setNoOp("JM" + j + "0002" + i + "/19");
                voadip.setTglKirim(j + " November 2019");

                itemVoadips = new ArrayList<>();

                for (int k = 1; k <= 3; k++) {
                    ItemVoadip itemVoadip = new ItemVoadip();
                    itemVoadip.setVoadip(voadip);
                    itemVoadip.setName("Eurosol " + k + "00");
                    itemVoadip.setPacking("1000mL");
                    itemVoadip.setAmmount(2);

                    itemVoadips.add(itemVoadip);
                }
                voadip.setItemVoadips(itemVoadips);

                voadips.add(voadip);
            }
            doc.setVoadips(voadips);

            docs.add(doc);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_planning, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        adapter = new PlanningAdapter(getContext(), getActivity());

        rvPlanning = view.findViewById(R.id.rvPlanning);
        rvPlanning.setAdapter(adapter);

        btnSync = view.findViewById(R.id.btnSync);
        btnSync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.syncPlanning(docs);
            }
        });
    }
}
