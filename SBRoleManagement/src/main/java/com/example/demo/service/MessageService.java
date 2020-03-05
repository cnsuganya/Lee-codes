package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Message;

public interface MessageService {

	List < Message > getMessageByUser(String user);

    Optional < Message > getMessageById(long id);

    void updateMessage(Message message);

    void addMessage(long id, String messagedesc);

    void deleteMessage(long id);

    void saveMessage(Message message);
}
