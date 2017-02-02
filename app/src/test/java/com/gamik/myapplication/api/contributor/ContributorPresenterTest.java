package com.gamik.myapplication.api.contributor;

import com.gamik.myapplication.api.client.GithubClient;
import com.gamik.myapplication.api.model.Author;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by kutigbolahan on 02/02/2017.
 */
public class ContributorPresenterTest {

    private Response<List<Author>> response;

    @Mock
    ContributorContract.view view;

    @Mock
    GithubClient githubClient;

    @Mock
    Call<List<Author>> call;

    @Captor
    ArgumentCaptor<Callback<List<Author>>> loadContributorCallbackCaptor;

    private ContributorPresenter contributorPresenter;

    @Before
    public void setUpPresenter() {
        MockitoAnnotations.initMocks(this);

        contributorPresenter = new ContributorPresenter(view, githubClient);
    }

    @Test
    public void loadContributor() throws Exception {

        String repoName = "react";
        String repoOwner = "javascript";

        when(githubClient.contributors(repoOwner, repoName)).thenReturn(call);

        doNothing().when(call).enqueue(loadContributorCallbackCaptor.capture());

        contributorPresenter.loadContributor(repoName, repoOwner);

        verify(githubClient.contributors(repoOwner, repoName)).enqueue(loadContributorCallbackCaptor.getValue());

        List<Author> authors = new ArrayList<>();

        response = Response.success(authors);

        loadContributorCallbackCaptor.getValue().onResponse(call, response);

        verify(view).contributorLoaded(response.body());

        response = Response.error(404, ResponseBody.create(MediaType.parse("application/json"), ""));

        loadContributorCallbackCaptor.getValue().onResponse(call, response);
        verify(view).onError("Not found");

        Throwable throwable = new Throwable();
        loadContributorCallbackCaptor.getValue().onFailure(call, throwable);
        verify(view).onError("Error occurred");

    }

}