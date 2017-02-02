package com.gamik.myapplication.api.model;

import java.util.List;

public class CommitResponse {
	private Committer committer;
	private Author author;
	private String htmlUrl;
	private Commit commit;
	private String commentsUrl;
	private String sha;
	private String url;
	private List<ParentsItem> parents;

	public void setCommitter(Committer committer){
		this.committer = committer;
	}

	public Committer getCommitter(){
		return committer;
	}

	public void setAuthor(Author author){
		this.author = author;
	}

	public Author getAuthor(){
		return author;
	}

	public void setHtmlUrl(String htmlUrl){
		this.htmlUrl = htmlUrl;
	}

	public String getHtmlUrl(){
		return htmlUrl;
	}

	public void setCommit(Commit commit){
		this.commit = commit;
	}

	public Commit getCommit(){
		return commit;
	}

	public void setCommentsUrl(String commentsUrl){
		this.commentsUrl = commentsUrl;
	}

	public String getCommentsUrl(){
		return commentsUrl;
	}

	public void setSha(String sha){
		this.sha = sha;
	}

	public String getSha(){
		return sha;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setParents(List<ParentsItem> parents){
		this.parents = parents;
	}

	public List<ParentsItem> getParents(){
		return parents;
	}
}