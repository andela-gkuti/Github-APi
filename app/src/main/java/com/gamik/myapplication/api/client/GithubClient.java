package com.gamik.myapplication.api.client;

import com.gamik.myapplication.api.model.Author;
import com.gamik.myapplication.api.model.CommitResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by kutigbolahan on 02/02/2017.
 */

public interface GithubClient {
    @GET("repos/{repoOwner}/{repoName}/contributors")
    Call<List<Author>> contributors(@Path("repoOwner") String repoOwner, @Path("repoName") String repoName);

    @GET("repos/{repoOwner}/{repoName}/contributors")
    Call<List<CommitResponse>> commits(@Path("repoOwner") String repoOwner,
                                       @Path("repoName") String repoName,
                                       @Query("commits") String contributorName);
}
