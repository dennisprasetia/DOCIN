package com.wonokoyo.docin.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wonokoyo.docin.R;
import com.wonokoyo.docin.model.ItemVoadip;

import java.util.ArrayList;

public class VoadipFormAdapter extends RecyclerView.Adapter<VoadipFormAdapter.FormViewHolder> {
    ArrayList<ItemVoadip> listItemVoadip;
    Context mContext;
    Activity mActivity;

    public VoadipFormAdapter(Context mContext, Activity mActivity, ArrayList<ItemVoadip> itemVoadips) {
        this.listItemVoadip = itemVoadips;
        this.mContext = mContext;
        this.mActivity = mActivity;
    }

    @NonNull
    @Override
    public FormViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.voadip_item_form, parent, false);
        return new FormViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FormViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listItemVoadip.size();
    }

    public static class FormViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaItem;
        EditText etKemasan;
        EditText etJumlah;

        public FormViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNamaItem = itemView.findViewById(R.id.tvNamaItem);
            etKemasan = itemView.findViewById(R.id.etKemasan);
            etJumlah = itemView.findViewById(R.id.etJumlah);
        }
    }
}
