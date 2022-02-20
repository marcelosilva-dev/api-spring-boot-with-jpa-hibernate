package com.pbidevs.course.resources.extra;

public class Root {
	private String title;
	private String getUsers;
	private String postUsers;
	private String putUsers;
	private String deleteUsers;
	private String address;
	
	public Root() {
		
	}

	public Root(String title, String getUsers, String postUsers, String putUsers, String deleteUsers, String address) {
		super();
		this.title = title;
		this.getUsers = getUsers;
		this.postUsers = postUsers;
		this.putUsers = putUsers;
		this.deleteUsers = deleteUsers;
		this.address = address;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGetUsers() {
		return getUsers;
	}

	public void setGetUsers(String getUsers) {
		this.getUsers = getUsers;
	}

	public String getPostUsers() {
		return postUsers;
	}

	public void setPostUsers(String postUsers) {
		this.postUsers = postUsers;
	}

	public String getPutUsers() {
		return putUsers;
	}

	public void setPutUsers(String putUsers) {
		this.putUsers = putUsers;
	}

	public String getDeleteUsers() {
		return deleteUsers;
	}

	public void setDeleteUsers(String deleteUsers) {
		this.deleteUsers = deleteUsers;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
