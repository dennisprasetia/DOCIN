package com.wonokoyo.docin.menu;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.zxing.Result;
import com.wonokoyo.docin.R;
import com.wonokoyo.docin.model.Doc;
import com.wonokoyo.docin.model.viewmodel.DocViewModel;
import com.wonokoyo.docin.sqlite.DbHelper;
import com.wonokoyo.docin.sqlite.DbService;

import java.text.SimpleDateFormat;
import java.util.Date;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class BapDocFragment extends Fragment implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;
    private final static int REQUEST_CAMERA_CODE = 10;

    private FrameLayout frameLayout;

    DbService dbService;

    DocViewModel docViewModel;

    public BapDocFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        requestPermissions(new String[] {Manifest.permission.CAMERA}, REQUEST_CAMERA_CODE);

        dbService = new DbService(getContext());

        return inflater.inflate(R.layout.fragment_bap_doc, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        docViewModel = ((MainActivity) getActivity()).getDocViewModel();
        docViewModel.init();

        mScannerView = new ZXingScannerView(getActivity());

        frameLayout = view.findViewById(R.id.flScanner);

        docViewModel.getLiveDoc().observe(this, new Observer<Doc>() {
            @Override
            public void onChanged(Doc doc) {
                if (doc != null) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String date = dateFormat.format(new Date());

                    doc.setKedatangan(date);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("doc", doc);

                    NavHostFragment.findNavController(getParentFragment())
                            .navigate(R.id.action_nav_bap_doc_to_information_confirm, bundle);
                } else {
                    Toast.makeText(getActivity(), "No OP Tidak ditemukan",
                            Toast.LENGTH_SHORT).show();
                    mScannerView.resumeCameraPreview(BapDocFragment.this);
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CAMERA_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                frameLayout.addView(mScannerView);
            } else {
                Toast.makeText(getContext(), "Please grant camera permission to use the Scanner", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void handleResult(Result rawResult) {
        final String noOp = rawResult.getText();

        docViewModel.getDocByOp(noOp);

        // Note:
        // * Wait 2 seconds to resume the preview.
        // * On older devices continuously stopping and resuming camera preview can result in freezing the app.
        // * I don't know why this is the case but I don't have the time to figure out.
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mScannerView.resumeCameraPreview(BapDocFragment.this);
            }
        }, 2000);
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }
}
