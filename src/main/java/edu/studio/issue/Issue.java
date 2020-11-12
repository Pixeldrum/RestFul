package edu.studio.issue;

import java.util.Date;
import java.util.Objects;

public class Issue implements Comparable<Issue> {
    
    //TODO implement the rest for Part 2
    
    private long id;
    @Override
	public String toString() {
		return "Issue [id=" + id + ", createdAt=" + createdAt + ", user=" + user + ", number=" + number + ", assignee="
				+ assignee + ", state=" + state + ", title=" + title + ", body=" + body + ", closedAt=" + closedAt
				+ "]";
	}

	private Date createdAt;
    private User user;
    private long number;
    public User getAssignee() {
		return assignee;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

	private User assignee;
    public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getClosedAt() {
		return closedAt;
	}

	public void setClosedAt(Date closedAt) {
		this.closedAt = closedAt;
	}

	private String state;
    private String title;
    private String body;
    private Date closedAt;
    
    public Issue() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

    @Override
	public boolean equals(Object obj) {
    	boolean check = false;
		if (this == obj) {
			check = true;
		}
		if (obj == null) {
			check = false;
		}
		if (getClass() != obj.getClass()) {
			check = false;
		}
		Issue other = (Issue) obj;
		if(Objects.equals(id, other.id)) {
			return true;
		}else {
			return check;
		}
		
	}

    @Override
    public int compareTo(Issue other) {
       long result = this.getId() - other.getId();
       
        return (int)result;
    }

}