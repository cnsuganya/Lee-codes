package com.example.demo.model;

import javax.persistence.GenerationType;
import javax.validation.constraints.Size;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="message")
public class Message {

	public Message(Long messageId, String messagedesc, String username, User user) {
		super();
		this.messageId = messageId;
		this.messagedesc = messagedesc;
		this.username = username;
		this.user = user;
	}


	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", messagedesc=" + messagedesc + ", username=" + username + ", user=" + user
				+ "]";
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="message_id")
	private Long messageId;
	
	@Column(name="message_desc")
	@Size(min = 10, message = "Enter at least 10 Characters...")
	private String messagedesc;
	public String getMessagedesc() {
		return messagedesc;
	}


	public void setMessagedesc(String messagedesc) {
		this.messagedesc = messagedesc;
	}


	private String username;
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	


	public Message() {
		super();
	}


	public Message( String messagedesc) {
		super();
		this.messagedesc=messagedesc;
	}


	public Long getMessageId() {
		return messageId;
	}


	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}



	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
}
