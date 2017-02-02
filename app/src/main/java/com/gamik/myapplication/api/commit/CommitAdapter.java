package com.gamik.myapplication.api.commit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gamik.myapplication.R;
import com.gamik.myapplication.api.model.CommitResponse;

import java.util.List;


public class CommitAdapter extends RecyclerView.Adapter<CommitAdapter.ViewHolder> {
    private List<CommitResponse> list;

    public CommitAdapter(List<CommitResponse> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from((parent.getContext())).inflate(R.layout.contributor_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CommitResponse CommitResponse = list.get(position);
        holder.name.setText(CommitResponse.getCommit().getMessage());
        holder.contribution.setText(String.valueOf(CommitResponse.getSha()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView contribution;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.contributorName);
            contribution = (TextView) itemView.findViewById(R.id.contribution);
        }
    }
}
