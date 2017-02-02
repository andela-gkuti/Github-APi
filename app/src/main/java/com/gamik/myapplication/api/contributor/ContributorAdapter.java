package com.gamik.myapplication.api.contributor;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gamik.myapplication.R;
import com.gamik.myapplication.api.model.Author;

import java.util.List;


public class ContributorAdapter extends RecyclerView.Adapter<ContributorAdapter.ViewHolder> {
    private List<Author> list;

    public ContributorAdapter(List<Author> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from((parent.getContext())).inflate(R.layout.contributor_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Author author = list.get(position);
        holder.name.setText(author.getLogin());
        holder.contribution.setText(String.valueOf(author.getContributions()));
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
