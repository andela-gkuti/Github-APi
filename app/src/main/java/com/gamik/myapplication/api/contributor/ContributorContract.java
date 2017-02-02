package com.gamik.myapplication.api.contributor;

import com.gamik.myapplication.api.model.Author;

import java.util.List;

/**
 * Created by kutigbolahan on 02/02/2017.
 */

public interface ContributorContract {

    interface view {
        void contributorLoaded(List<Author> authors);

        void onError(String message);
    }

    interface presenter {
        void loadContributor(String repoName, String repoOwner);
    }
}
