package com.gamik.myapplication.api.contributor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.gamik.myapplication.R;
import com.gamik.myapplication.api.client.ApiGenerator;
import com.gamik.myapplication.api.client.GithubClient;
import com.gamik.myapplication.api.model.Author;

import java.util.List;

public class ContributorActivity extends AppCompatActivity implements ContributorContract.view {

    private EditText repoName;
    private EditText repoOwner;
    private ContributorPresenter contributorPresenter;
    private RecyclerView contributorView;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contributor);

        init();
    }

    private void init() {
        repoName = (EditText) findViewById(R.id.repoName);
        repoOwner = (EditText) findViewById(R.id.repoOwner);
        contributorPresenter = new ContributorPresenter(this, ApiGenerator.retrofit.create(GithubClient.class));
        progress = (ProgressBar) findViewById(R.id.progress);

        findViewById(R.id.loadContributor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progress.setVisibility(View.VISIBLE);
                contributorPresenter.loadContributor(repoName.getText().toString(), repoOwner.getText().toString());
            }
        });
        contributorView = (RecyclerView) findViewById(R.id.contributorList);
    }

    @Override
    public void contributorLoaded(List<Author> authors) {
        ContributorAdapter contributorAdapter = new ContributorAdapter(authors);
        contributorView.setAdapter(contributorAdapter);
        contributorView.setLayoutManager(new LinearLayoutManager(this));
        progress.setVisibility(View.GONE);
    }

    @Override
    public void onError(String message) {
        progress.setVisibility(View.GONE);
    }
}
