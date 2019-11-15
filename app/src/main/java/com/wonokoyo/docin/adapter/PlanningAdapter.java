package com.wonokoyo.docin.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.wonokoyo.docin.R;
import com.wonokoyo.docin.menu.PlanningFragmentDirections;
import com.wonokoyo.docin.model.Doc;

import java.util.ArrayList;
import java.util.List;

public class PlanningAdapter extends RecyclerView.Adapter<PlanningAdapter.PlanningViewHolder> {
    List<Doc> listPlanning;
    Context mContext;
    Activity mActivity;

    public PlanningAdapter(Context context, Activity activity) {
        this.listPlanning = new ArrayList<>();
        this.mContext = context;
        this.mActivity = activity;
    }

    @NonNull
    @Override
    public PlanningViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.planning_doc_listing, parent, false);
        return new PlanningViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanningViewHolder holder, int position) {
        final Doc doc = listPlanning.get(position);

        holder.tvDate.setText(doc.getTanggalDoc());
        holder.tvMitraNoreg.setText(doc.getMitra() + " (" + doc.getNoreg() + ")");
        holder.tvPopulation.setText("Populasi " + doc.getPopulasi() + " ekor");

        holder.cvPlanning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlanningFragmentDirections.ActionPlanningShowDetail directions = PlanningFragmentDirections.actionPlanningShowDetail(doc);
                Navigation.findNavController(mActivity, R.id.fragment_container).navigate(directions);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listPlanning.size();
    }

    public void syncPlanning(List<Doc> listPlanning) {
        this.listPlanning.clear();
        this.listPlanning.addAll(listPlanning);
        this.notifyDataSetChanged();
    }

    public static class PlanningViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cvPlanning;
        TextView tvDate;
        TextView tvMitraNoreg;
        TextView tvPopulation;

        public PlanningViewHolder(View itemView) {
            super(itemView);

            cvPlanning = itemView.findViewById(R.id.cvPlanning);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvMitraNoreg = itemView.findViewById(R.id.tvMitraNoreg);
            tvPopulation = itemView.findViewById(R.id.tvPopulation);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tvDate :
                    break;

                case R.id.tvMitraNoreg :
                    break;

                case R.id.tvPopulation :
                    break;

                case R.id.cvPlanning :
                    break;
            }
        }
    }
}
