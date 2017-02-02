package com.gamik.myapplication.api.contributor;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gamik.myapplication.R;
import com.gamik.myapplication.api.commit.CommitActivity;
import com.gamik.myapplication.api.model.Author;

import java.util.List;


public class ContributorAdapter extends RecyclerView.Adapter<ContributorAdapter.ViewHolder> {
    private List<Author> list;
    private Activity activity;
    private String repoName;
    private String repoOwner;

    public ContributorAdapter(List<Author> list, Activity activity, String repoName, String repoOwner) {
        this.activity = activity;
        this.list = list;
        this.repoName = repoName;
        this.repoOwner = repoOwner;
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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(activity, CommitActivity.class);
                    intent.putExtra("repoName", repoName);
                    intent.putExtra("repoOwner", repoOwner);
                    activity.startActivity(intent);
                }
            });
        }
    }
}
