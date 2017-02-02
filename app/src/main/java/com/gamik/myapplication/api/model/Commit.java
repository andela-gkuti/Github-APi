package com.gamik.myapplication.api.model;

public class Commit{
	private int commentCount;
	private Committer committer;
	private Author author;
	private Tree tree;
	private String message;
	private String url;

	public void setCommentCount(int commentCount){
		this.commentCount = commentCount;
	}

	public int getCommentCount(){
		return commentCount;
	}

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

	public void setTree(Tree tree){
		this.tree = tree;
	}

	public Tree getTree(){
		return tree;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}
}
