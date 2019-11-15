package com.wonokoyo.docin.menu;


import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.wonokoyo.docin.R;
import com.wonokoyo.docin.adapter.PlanningAdapter;
import com.wonokoyo.docin.adapter.PlanningVoadipAdapter;
import com.wonokoyo.docin.model.Doc;
import com.wonokoyo.docin.model.ItemVoadip;
import com.wonokoyo.docin.model.Voadip;
import com.wonokoyo.docin.model.viewmodel.DocViewModel;
import com.wonokoyo.docin.serveraccess.RetrofitInstance;
import com.wonokoyo.docin.sqlite.DbHelper;
import com.wonokoyo.docin.utility.SessionManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlanningFragment extends Fragment {
    private RecyclerView rvPlanning;
    private Button btnSync;

    PlanningAdapter adapter;

    DocViewModel docViewModel;

    public PlanningFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        docViewModel = ((MainActivity) getActivity()).getDocViewModel();
        docViewModel.init();

        adapter = new PlanningAdapter(getContext(), getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_planning, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        docViewModel.getListDoc().observe(this, new Observer<List<Doc>>() {
            @Override
            public void onChanged(List<Doc> docList) {
                adapter.syncPlanning(docList);
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        rvPlanning = view.findViewById(R.id.rvPlanning);
        rvPlanning.setAdapter(adapter);

        btnSync = view.findViewById(R.id.btnSync);
        btnSync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                docViewModel.populateListDoc();
            }
        });
    }
}
