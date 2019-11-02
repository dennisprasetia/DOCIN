package com.wonokoyo.docin.menu.features;


import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.gcacace.signaturepad.views.SignaturePad;
import com.wonokoyo.docin.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SignatureFragment extends Fragment {

    private SignaturePad signaturePad;
    private ImageView ivRefresh;
    private ImageView ivSend;

    private File signFolder;
    private String signFilename;

    public SignatureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        createSignFolder();

        return inflater.inflate(R.layout.fragment_signature, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        signaturePad = view.findViewById(R.id.signPad);

        ivRefresh = view.findViewById(R.id.ivRefresh);
        ivRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signaturePad.clear();
            }
        });

        ivSend = view.findViewById(R.id.ivSendEntry);
        ivSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = signaturePad.getSignatureBitmap();
                File file;

                try {
                    file = createSignFilename();
                    FileOutputStream outputStream = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                    outputStream.flush();
                    outputStream.close();

                    Intent mediaStoreUpdate = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                    mediaStoreUpdate.setData(Uri.fromFile(file));
                    getActivity().sendBroadcast(mediaStoreUpdate);

                    Bundle bundle = new Bundle();
                    bundle.putString("url_sign", file.getAbsolutePath());
                    bundle.putString("url_sj", getArguments().getString("url_sj"));

                    if (getArguments().getString("session").equalsIgnoreCase("doc"))
                        NavHostFragment.findNavController(getParentFragment())
                                .navigate(R.id.action_signature_to_doc_result, bundle);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void createSignFolder() {
        File imageFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        signFolder = new File(imageFile, "DOC IN/Signature");
        if (!signFolder.exists()) {
            signFolder.mkdirs();
        }
    }

    private File createSignFilename() throws IOException {
        String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String prepend = "DOC_SIGN_" + time;
        File imageFile = File.createTempFile(prepend, ".jpg", signFolder);

        signFilename = imageFile.getAbsolutePath();
        return imageFile;
    }
}
