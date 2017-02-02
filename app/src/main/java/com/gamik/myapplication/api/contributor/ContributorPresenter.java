package com.gamik.myapplication.api.contributor;

import com.gamik.myapplication.api.client.GithubClient;
import com.gamik.myapplication.api.model.Author;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kutigbolahan on 02/02/2017.
 */

public class ContributorPresenter implements ContributorContract.presenter {
    private ContributorContract.view view;
    private GithubClient githubClient;

    public ContributorPresenter(ContributorContract.view view, GithubClient githubClient) {
        this.view = view;
        this.githubClient = githubClient;
    }

    @Override
    public void loadContributor(String repoName, String repoOwner) {
        githubClient.contributors(repoOwner, repoName).enqueue(new Callback<List<Author>>() {
            @Override
            public void onResponse(Call<List<Author>> call, Response<List<Author>> response) {
                if (response.code() <= 400) {
                    view.contributorLoaded(response.body());
                } else {
                    view.onError("Not found");
                }
                }

                @Override
                public void onFailure (Call < List < Author >> call, Throwable t){
                    view.onError("Error occurred");
                }
            }

            );
        }
    }
