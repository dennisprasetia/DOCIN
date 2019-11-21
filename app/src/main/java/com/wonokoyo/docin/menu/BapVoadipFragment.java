package com.wonokoyo.docin.menu;


import android.Manifest;
import android.content.pm.PackageManager;
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
import com.wonokoyo.docin.model.Voadip;
import com.wonokoyo.docin.model.viewmodel.VoadipViewModel;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class BapVoadipFragment extends Fragment implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;
    private final static int REQUEST_CAMERA_CODE = 10;

    private FrameLayout frameLayout;

    VoadipViewModel voadipViewModel;

    public BapVoadipFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        requestPermissions(new String[] {Manifest.permission.CAMERA}, REQUEST_CAMERA_CODE);
        return inflater.inflate(R.layout.fragment_bap_voadip, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        voadipViewModel = ((MainActivity) getActivity()).getVoadipViewModel();
        voadipViewModel.init();

        mScannerView = new ZXingScannerView(getActivity());

        frameLayout = view.findViewById(R.id.flScannerVoadip);

        voadipViewModel.getLiveVoadip().observe(this, new Observer<Voadip>() {
            @Override
            public void onChanged(Voadip voadip) {
                if (voadip != null) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("voadip", voadip);

                    NavHostFragment.findNavController(getParentFragment())
                            .navigate(R.id.action_nav_bpb_voadip_to_voadip_information, bundle);
                } else {
                    Toast.makeText(getActivity(), "No OP Tidak ditemukan",
                            Toast.LENGTH_SHORT).show();
                    mScannerView.resumeCameraPreview(BapVoadipFragment.this);
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

        voadipViewModel.getVoadipByOp(noOp);

        // Note:
        // * Wait 2 seconds to resume the preview.
        // * On older devices continuously stopping and resuming camera preview can result in freezing the app.
        // * I don't know why this is the case but I don't have the time to figure out.
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mScannerView.resumeCameraPreview(BapVoadipFragment.this);
            }
        }, 2000);
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }
}
