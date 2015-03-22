package com.dealers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealers.dao.Message;
import com.dealers.dao.MessagesDao;

@Service
public class MessageService {

	@Autowired
	private MessagesDao messagesDao;
	
	public void saveOrUpdate(Message message) {
		messagesDao.saveOrUpdate(message);
	}

	public List<Message> getAllMessages() {
		return messagesDao.getMessages();
	}

}
