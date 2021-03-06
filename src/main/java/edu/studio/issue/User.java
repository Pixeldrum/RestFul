package edu.studio.issue;

import java.util.Objects;

public class User implements Comparable<User>{
	private String login;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private long id;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "User [login=" + login + ", id=" + id + "]";
	}
	@Override
	public int compareTo(User o) {
		 long result = this.getId() - o.getId();
	       
	        return (int)result;
	}
}
