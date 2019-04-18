package org.tarena.entity;

import java.io.Serializable;
import java.util.Set;

public class User implements Serializable{
	private String id;
	private String name;
	private String password;
	private String token;
	private String descr;
	//追加一个关联属性,用于加载相关的book信息
	private Set<NoteBook> books;
	
	public Set<NoteBook> getBooks() {
		return books;
	}
	public void setBooks(Set<NoteBook> books) {
		this.books = books;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	
	
}
