package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Message;
import com.example.demo.repository.MessageRepository;


@Service
public class MessageServiceImpl implements MessageService {
	 @Autowired
	    private MessageRepository messageRepository;

	    @Override
	    public List < Message > getMessageByUser(String user) {
	        return messageRepository.findByUsername(user);
	    }

	    @Override
	    public Optional < Message > getMessageById(long id) {
	        return messageRepository.findById(id);
	    }

	    @Override
	    public void updateMessage(Message message) {
	    	messageRepository.save(message);
	    }

	    @Override
	    public void addMessage(long id, String messagedesc) {
	    	messageRepository.save(new Message(messagedesc));
	    }

	    @Override
	    public void deleteMessage(long id) {
	        Optional < Message > message = messageRepository.findById(id);
	        if (message.isPresent()) {
	        	messageRepository.delete(message.get());
	        }
	    }

	    @Override
	    public void saveMessage(Message message) {
	    	System.out.println("message==========="+message);
	    	messageRepository.saveAndFlush(message);
	    }

		

}
